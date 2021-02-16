package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day2_BOJ1780_¹Ú¿ø¼® {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int[][] map;
	static int[] answer = new int[3];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(in.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		recur(0, 0, N);

		for (int ans : answer)
			sb.append(ans).append("\n");
		System.out.println(sb.toString());
	}

	private static void recur(int x, int y, int size) {
		if (size == 1) {
			answer[map[y][x] + 1]++;
			return;
		}

		boolean minus = true, zero = true, plus = true;
		for (int i = y; i < y + size; i++) {
			for (int j = x; j < x + size; j++) {
				if (map[i][j] == -1) {
					zero = false;
					plus = false;
				} else if (map[i][j] == 0) {
					minus = false;
					plus = false;
				} else {
					minus = false;
					zero = false;
				}
			}
		}

		if (minus)
			answer[0]++;
		else if (zero)
			answer[1]++;
		else if (plus)
			answer[2]++;
		else {
			int nextSize = size / 3;
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					recur(x + j * nextSize, y + i * nextSize, nextSize);
				}
			}
		}
	}
}
