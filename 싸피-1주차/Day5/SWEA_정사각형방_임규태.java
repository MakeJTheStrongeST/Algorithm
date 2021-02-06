import java.io.*;
import java.util.*;

public class 정사각형방 {
	static BufferedReader br;
	static StringTokenizer st;

	static int[][] map = new int[(int)1e3][(int)1e3], dp = new int[(int)1e3][(int)1e3];
	static int[] dy = {-1,0,1,0}, dx = {0,1,0,-1};
	static int n;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int i=1;i<=t;i++) solve(i);
	}
	
	static void solve(int tc) throws NumberFormatException, IOException {
		n = Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = 0;
			}
		}
		
		int ansval = 0;
		int ansnum = Integer.MAX_VALUE;
		for(int i=0;i<n;i++) for(int j=0;j<n;j++) {
			int subval = f(i,j);
			if(subval >= ansval) {
				if(subval == ansval) ansnum = Math.min(ansnum, map[i][j]);
				else ansnum = map[i][j];
				ansval = Math.max(ansval, subval);
			}
		}
		System.out.println("#"+tc+" "+ansnum+" "+ansval);
	}
	
	static boolean isValid(int y,int x) {
		return y>=0 && y<n && x>=0 && x<n;
	}
	
	static int f(int cury,int curx) {
		if(dp[cury][curx] != 0) return dp[cury][curx];
		int ret = dp[cury][curx] = 1;
		
		for(int i=0;i<4;i++) {
			int nxty = cury+dy[i];
			int nxtx = curx+dx[i];
			if(isValid(nxty,nxtx) && map[nxty][nxtx] == map[cury][curx]+1) {
				ret += f(nxty,nxtx);
			}
		}
		
		return dp[cury][curx] = ret;
	}
}
