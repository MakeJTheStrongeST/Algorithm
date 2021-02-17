import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;

	static int[] dp = new int[(int)5e3+1];
	static int INF = (int)1e9;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		Arrays.fill(dp, -1);
		
		int n = Integer.parseInt(br.readLine());
		dp[3] = dp[5] = 1;
		System.out.println(f(n) == INF ? -1 : f(n));
	}
	
	static int f(int n) {
		if(n < 3) return INF;
		if(~dp[n] != 0) return dp[n];
		dp[n] = INF;
		dp[n] = Math.min(dp[n],f(n-3)+1);
		dp[n] = Math.min(dp[n],f(n-5)+1);
		return dp[n];
	}
}
