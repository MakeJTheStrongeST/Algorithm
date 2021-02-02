import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1954_달팽이숫자_박원석 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int[][] arr;
		int[] dx = { 1, 0, -1, 0 };
		int[] dy = { 0, 1, 0, -1 };

		int t = Integer.parseInt(in.readLine());
		for (int i = 1; i <= t; i++) {
			int n = Integer.parseInt(in.readLine());
			arr = new int[n][n];
			
			int idx = 0, x = 0, y = 0;
			for (int j = 1; j <= n * n; j++) {
				if(x < 0 || y < 0 || x >= n || y >= n || arr[y][x] > 0) {
					--j;
					x -= dx[idx];
					y -= dy[idx];
					idx++;
					if(idx > 3)
						idx %= 4;
				} else {
					arr[y][x] = j;
				}
				
				x += dx[idx];
				y += dy[idx];
			}
			
			System.out.println("#" + i);
			for(int j = 0; j < n; j++){
				for(int k = 0; k < n; k++){
					System.out.print(arr[j][k] + " ");
				}
				System.out.println();
			}
		}
	}
}
