import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ladder {
	static BufferedReader br; 
	static StringTokenizer st;

	static int[][] map = new int[100][100];
	static int cury,curx,dir;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=1;i<=10;i++) solve(i);
	}
	
	static void solve(int tc) throws IOException {
		int t = Integer.parseInt(br.readLine());
		for(int i=0;i<100;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<100;j++) map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<100;i++) if(map[0][i] == 1 && simulation(i)) {
			System.out.println("#"+tc+" "+i);
			return;
		}
	}
	
	static boolean isValid(int y,int x) {
		return y>=0 && y<100 && x>=0 && x<100;
	}
	
	static boolean simulation(int start) {
		cury = 0;
		curx = start;
		dir = 0;
		
		boolean ret = false;
		while(cury < 99 && map[cury][curx] == 1) {
			if(dir == 0) {
				if(isValid(cury,curx+1) && map[cury][curx+1] != 0) {
					curx++;
					dir = 1;
				}
				else if(isValid(cury,curx-1) && map[cury][curx-1] != 0) {
					curx--;
					dir = 2;
				}
				else cury++;
			}
			else if(dir == 1) {
				if(isValid(cury+1,curx) && map[cury+1][curx] != 0) {
					cury++;
					dir = 0;
				}
				else curx++;
			}
			else {
				if(isValid(cury+1,curx) && map[cury+1][curx] != 0) {
					cury++;
					dir = 0;
				}
				else curx--;
			}
		}
		
		if(map[cury][curx] == 2) ret = true;
		return ret;
	}
}
