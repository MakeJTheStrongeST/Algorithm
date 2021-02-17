package week3.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1992_쿼드트리_박원석 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static int[][] map;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		// input
		N = Integer.parseInt(in.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			String row = in.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = row.charAt(j) - '0';
			}
		}

		func(N, 0, 0);

		System.out.println(sb.toString());
	}

	private static void func(int size, int x, int y) {
		boolean zero = true, one = true;
		for (int i = y; i < y + size; i++) {
			for (int j = x; j < x + size; j++) {
				if(map[i][j] == 0) one = false;
				else zero = false;
			}
		}

		if (zero) {
			sb.append(0);
		} else if(one) {
			sb.append(1);
		} else {
			size /= 2;
			sb.append("(");
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 2; j++) {
					func(size, x + j * size, y + i * size);
				}
			}
			sb.append(")");
		}
	}
}
