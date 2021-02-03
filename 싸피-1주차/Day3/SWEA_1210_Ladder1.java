import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1210_Ladder1 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int T, dir, answer;
	static int[][] ladder = new int[100][100];
	static int endX;

	public static void main(String[] args) throws NumberFormatException, IOException {
		for (int i = 1; i <= 10; i++) {
			T = Integer.parseInt(in.readLine());
			
			// �Է�
			for (int j = 0; j < 100; j++) {
				st = new StringTokenizer(in.readLine(), " ");
			    for (int k = 0; k < 100; k++) {
					ladder[j][k] = Integer.parseInt(st.nextToken());
					if (j == 99 && ladder[j][k] == 2)
						endX = k;
				}
			}
			
			// Ǯ��
			int x = endX, y = 99;
			while(y != 0) {
				if(dir == 0) {
					// ��
					if(x - 1 >= 0) {
						if(ladder[y][x - 1] == 1) {
							x -= 1;
							dir = 1;
							continue;
						}
					}
					
					// ��
					if(x + 1 < 100) {
						if(ladder[y][x + 1] == 1) {
							x += 1;
							dir = 2;
							continue;
						}
					}
					
					// ��
					y -= 1;
				} else if(dir == 1) {
					// ��
					if(ladder[y - 1][x] == 1) {
						y -= 1;
						dir = 0;
						continue;
					}
					
					// ��
					x -= 1;
				} else {
					// ��
					if(ladder[y - 1][x] == 1) {
						y -= 1;
						dir = 0;
						continue;
					}
					
					// ��
					x += 1;
				}
			}
			
			// ���
			System.out.println("#" + T + " " + x);
		}
	}
}
