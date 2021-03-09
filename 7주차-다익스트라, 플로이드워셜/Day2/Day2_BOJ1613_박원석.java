package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day2_BOJ1613_¹Ú¿ø¼® {
	public static void main(String[] args) throws IOException {
		// input
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[][] fw = new int[n + 1][n + 1];
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(in.readLine());
			int prev = Integer.parseInt(st.nextToken());
			int after = Integer.parseInt(st.nextToken());

			fw[prev][after] = -1;
			fw[after][prev] = 1;
		}

		// solution
		for (int m = 1; m <= n; m++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (fw[i][j] == 0 && fw[i][m] == fw[m][j]) {
						fw[i][j] = fw[i][m];
					}
				}
			}
		}

		// result
		int s = Integer.parseInt(in.readLine());
		for (int i = 0; i < s; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			System.out.println(fw[a][b]);
		}
	}
}
