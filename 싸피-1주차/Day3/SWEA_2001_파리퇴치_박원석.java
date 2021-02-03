import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2001_파리퇴치_박원석 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int T, N, M, num, sum, answer;
	static int[][] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(in.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(in.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			dp = new int[N + 1][N + 1];
			answer = Integer.MIN_VALUE;

			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				for (int j = 1; j <= N; j++) {
					num = Integer.parseInt(st.nextToken());
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + num;
				}
			}
			
//			for (int i = 1; i <= N; i++) {
//				for (int j = 1; j <= N; j++) {
//					System.out.print(dp[i][j] + " ");
//				}
//				System.out.println();
//			}

			for (int i = M; i <= N; i++) {
				for (int j = M; j <= N; j++) {
					sum = dp[i][j] - dp[i - M][j] - dp[i][j - M] + dp[i - M][j - M];
					answer = Math.max(answer, sum);
				}
			}
			
			System.out.println("#" + tc + " " + answer);
		}
	}
}
