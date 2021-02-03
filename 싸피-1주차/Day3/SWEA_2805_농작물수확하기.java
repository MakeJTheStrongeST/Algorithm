import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2805_���۹���Ȯ�ϱ� {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int T, N;
	static int[][] farm;

	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(in.readLine());

		for (int i = 1; i <= T; i++) {
			// �Է�
			N = Integer.parseInt(in.readLine());
			farm = new int[N][N];
			for (int j = 0; j < N; j++) {
				String row = in.readLine();
				for (int k = 0; k < N; k++) {
					farm[j][k] = row.charAt(k) - '0';
				}
			}

			// ��� �� ���� ������ ���� �հ�
			int sum = 0, range = 1;
			for (int j = 0; j < N / 2; j++) {
				int start = N / 2 - j;
				for (int k = 0; k < range; k++) {
					sum += farm[j][start + k];
				}
				range += 2;
			}
			
			// ��� �� �հ�
			for (int j = 0; j < N; j++) {
				sum += farm[N / 2][j];
			}
			
			// ��� �� ���� ������ �Ʒ��� �հ�
			range -= 2;
			for (int j = N / 2 + 1; j < N; j++) {
				int start = Math.abs(N / 2 - j);
				for (int k = 0; k < range; k++) {
					sum += farm[j][start + k];
				}
				range -= 2;
			}
			
			// ���
			System.out.println("#" + i + " " + sum);
		}
	}
}
