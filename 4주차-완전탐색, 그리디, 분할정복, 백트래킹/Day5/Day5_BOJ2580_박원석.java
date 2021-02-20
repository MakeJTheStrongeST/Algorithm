package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Day5_BOJ2580_�ڿ��� {
	static int[][] sudoku = new int[9][9];
	static ArrayList<int[]> blankList = new ArrayList<>();
	static int blankListSize;
	static boolean flag;

	public static void main(String[] args) throws IOException {
		// �Է�
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < 9; j++) {
				sudoku[i][j] = Integer.parseInt(st.nextToken());
				if (sudoku[i][j] == 0) {
					blankList.add(new int[] { j, i });
				}
			}
		}
		blankListSize = blankList.size();

		// �� ĭ 1 ~ 9 �־�鼭 Ž�� (��ȿ���� �ʴٸ� ��Ʈ��ŷ)
		DFS(0);
	}

	// ���� �˻�
	static boolean rowCheck(int n, int y) {
		for (int i = 0; i < 9; i++) {
			if (n == sudoku[y][i]) {
				return false;
			}
		}
		return true;
	}

	// ���� �˻�
	static boolean columnCheck(int n, int x) {
		for (int i = 0; i < 9; i++) {
			if (n == sudoku[i][x]) {
				return false;
			}
		}
		return true;
	}

	// 3X3 �˻�
	static boolean squareCheck(int n, int x, int y) {
		x = x / 3 * 3;
		y = y / 3 * 3;
		for (int i = y; i < y + 3; i++) {
			for (int j = x; j < x + 3; j++) {
				if (n == sudoku[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

	static void DFS(int idx) {
		if (idx == blankListSize) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(sudoku[i][j]).append(" ");
				}
				sb.append("\n");
			}
			System.out.println(sb.toString());
			flag = true;
			return;
		}

		int x = blankList.get(idx)[0];
		int y = blankList.get(idx)[1];
		for (int i = 1; i <= 9; i++) {
			if(flag) return;
			
			if (rowCheck(i, y) && columnCheck(i, x) && squareCheck(i, x, y)) {
				sudoku[y][x] = i;
				DFS(idx + 1);
				sudoku[y][x] = 0;
			}
		}
	}
}
