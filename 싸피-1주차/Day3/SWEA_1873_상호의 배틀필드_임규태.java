import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 배틀필드 {
	static BufferedReader br;
	static StringTokenizer st;

	static char[][] map = new char[20][20];
	static int cury,curx,dir,h,w;
	static int[] dy = {-1,0,1,0}, dx = {0,1,0,-1};
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int i=1;i<=t;i++) solve(i);
	}
	
	static boolean isValid(int y,int x) {
		return y>=0 && y<h && x>=0 && x<w;
	}
	
	static void solve(int tc) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		h = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		String in;
		for(int i=0;i<h;i++) {
			in = br.readLine();
			for(int j=0;j<w;j++) {
				map[i][j] = in.charAt(j);
				if(dirToInt(map[i][j]) < 4) {
					cury = i;
					curx = j;
					dir = dirToInt(map[i][j]);
				}
			}
		}
		
		int k = Integer.parseInt(br.readLine());
		in = br.readLine();
		for(int t=0;t<k;t++) {
			char action = in.charAt(t);
			if(action == 'S') {
				int tmpy = cury;
				int tmpx = curx;
				while(isValid(tmpy,tmpx) && map[tmpy][tmpx] != '#' && map[tmpy][tmpx] != '*') {
					tmpy += dy[dir];
					tmpx += dx[dir];
				}
				if(isValid(tmpy,tmpx) && map[tmpy][tmpx] == '*') map[tmpy][tmpx] = '.';
			}
			else {
				dir = dirToInt(actionToChar(action));
				map[cury][curx] = actionToChar(action);
				int nxty = cury+dy[dir];
				int nxtx = curx+dx[dir];
				if(isValid(nxty,nxtx) && map[nxty][nxtx] == '.') {
					map[cury][curx] = '.';
					cury = nxty;
					curx = nxtx;
					map[cury][curx] = actionToChar(action);
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("#").append(tc).append(" ");
		for(int i=0;i<h;i++) {
			for(int j=0;j<w;j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		System.out.print(sb.toString());
		
	}
	
	static int dirToInt(char c) {
		int ret = 0;
		if(c == '^') ret = 0;
		else if(c == '>') ret = 1;
		else if(c == 'v') ret = 2;
		else if(c == '<') ret = 3;
		else ret = 5;
		return ret;
	}
	
	static char actionToChar(char c) {
		char ret = '.';
		if(c == 'U') ret = '^';
		else if(c == 'R') ret = '>';
		else if(c == 'D') ret = 'v';
		else if(c == 'L') ret = '<';
		return ret;
	}
}
