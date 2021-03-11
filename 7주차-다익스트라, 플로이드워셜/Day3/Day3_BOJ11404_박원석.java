package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day3_BOJ11404_¹Ú¿ø¼® {
	public static void main(String[] args) throws IOException {
		// input
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(in.readLine());
		int m = Integer.parseInt(in.readLine());
		int INF = Integer.MAX_VALUE;

		int[][] fw = new int[n + 1][n + 1];
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				if(i == j) {
					fw[i][j] = 0;
				} else {
					fw[i][j] = INF;
				}
			}
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			fw[a][b] = Math.min(fw[a][b], c);
		}

		// solution
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if(fw[i][k] != INF && fw[k][j] != INF)
						fw[i][j] = Math.min(fw[i][j], fw[i][k] + fw[k][j]);
				}
			}
		}

		// result
		for (int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				if(fw[i][j] == INF)
					System.out.print("0 ");
				else
					System.out.print(fw[i][j] + " ");
			}
			System.out.println();
		}
	}
}
