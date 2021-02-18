import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;

	static int R,C;
	static char[][] map = new char[10000][500];
	static boolean[][] chk = new boolean[10000][500];
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<R;i++) {
			String in = br.readLine();
			for(int j=0;j<C;j++) map[i][j] = in.charAt(j);
		}
		
		int ans = 0;
		for(int i=0;i<R;i++) ans += f(i,0);
		System.out.println(ans);
	}
	
	static boolean isValid(int r,int c) {
		return r>=0 && r<R && c>=0 && c<C;
	}
	
	static int f(int r,int c) {
		if(c == C-1) {
			return 1;
		}
		
		for(int i=-1;i<2;i++) {
			int nxtr = r+i;
			int nxtc = c+1;
			
			if(isValid(nxtr,nxtc) && map[nxtr][nxtc] == '.' && !chk[nxtr][nxtc]) {
				chk[nxtr][nxtc] = true;
				if(f(nxtr,nxtc) == 1) return 1;
			}
		}
		
		return 0;
	}
}
