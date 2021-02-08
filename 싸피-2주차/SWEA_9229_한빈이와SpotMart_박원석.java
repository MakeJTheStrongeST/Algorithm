package week2.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_9229_한빈이와SpotMart_박원석 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, M, T, max;
	static int[] arr, res;

	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(in.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(in.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			arr = new int[N];
			st = new StringTokenizer(in.readLine(), " ");
			for (int i = 0; i < N; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			res = new int[2];
			max = -1;

			DFS(0, 0, 0);

			System.out.println("#" + tc + " " + max);
		}
	}

	static void DFS(int cnt, int start, int sum) {
		if(sum > M)
			return;
		
		if (cnt == 2) {
			if (sum <= M) {
				max = Math.max(max, sum);
			}
			return;
		}

		for (int i = start; i < N; i++) {
			DFS(cnt + 1, i + 1, sum + arr[i]);
		}
	}
}
