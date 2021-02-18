import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;

	static int R,C,ans;
	static int[][] map = new int[20][20];
	static int[] dy = {1,-1,0,0}, dx = {0,0,1,-1};
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<R;i++) {
			String in = br.readLine();
			for(int j=0;j<C;j++) {
				map[i][j] = in.charAt(j)-'A';
			}
		}
		
		f(0,0,1<<map[0][0],1);
		System.out.println(ans);
	}
	
	static boolean isValid(int r,int c) {
		return r>=0 && r<R && c>=0 && c<C;
	}
	
	static void f(int r,int c,int mask,int cnt) {
		ans = Math.max(ans, cnt);
		for(int i=0;i<4;i++) {
			int nxtr = r+dy[i];
			int nxtc = c+dx[i];
			
			if(isValid(nxtr,nxtc) && (mask&1<<map[nxtr][nxtc]) == 0) {
				f(nxtr,nxtc,mask|1<<map[nxtr][nxtc],cnt+1);
			}
		}
	}
}
