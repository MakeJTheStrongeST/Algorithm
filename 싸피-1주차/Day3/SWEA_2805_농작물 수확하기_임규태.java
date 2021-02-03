import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int i=1;i<=t;i++) solve(i);
	}
	
	static void solve(int tc) throws NumberFormatException, IOException {
		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[n][n];
		
		String s = "";
		for(int i=0;i<n;i++) {
			s = br.readLine();
			for(int j=0;j<n;j++) {
				map[i][j] = (s.charAt(j)-'0');
			}
		}
		
		int ans = 0;
		for(int i=0;i<=n/2;i++) {
			int subans1 = 0;
			int subans2 = 0;
			for(int j=n/2-i;j<n/2+i+1;j++) {
				subans1 += map[i][j];
				subans2 += map[n-i-1][j];
			}
			if(i == n/2) {
				ans += subans1;
			}
			else {
				ans += subans1+subans2;
			}
		}
		
		System.out.println("#"+tc+" "+ans);
	}
}
