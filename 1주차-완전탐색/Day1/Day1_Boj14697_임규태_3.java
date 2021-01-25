import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] arr = new int[3], dp = new int[301];
	static boolean ans = false;
	static int n;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		for(int i=0;i<3;i++) arr[i] = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		for(int i=0;i<301;i++) dp[i] = -1;
		f(n);
		
		if(ans) System.out.println(1);
		else System.out.println(0);
	}
	
	static int f(int x) {
		if(x == 0) {
			ans = true;
			return 1;
		}
		if(dp[x] != -1) return dp[x];
		dp[x] = 0;
		for(int i=0;i<3;i++) {
			if(x-arr[i] >= 0 && f(x-arr[i]) == 1) {
				return dp[x] = 1;
			}
		}
		return dp[x];
		
	}
}
