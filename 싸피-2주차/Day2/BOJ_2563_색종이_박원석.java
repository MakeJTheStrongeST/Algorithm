package week2.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2563_색종이_박원석 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(in.readLine()); // 색종이 수
		boolean[][] ch = new boolean[100][100]; // 색종이 영역은 true, 빈 영역은 false
		int cnt = 0; // 색종이 영역 넓이

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int x = Integer.parseInt(st.nextToken()); // 색종이 x좌표 (왼쪽 아래 꼭지점)
			int y = Integer.parseInt(st.nextToken()); // 색종이 y좌표 (왼쪽 아래 꼭지점)

			// 색종이 영역은 true로 변경
			for (int j = x; j < x + 10; j++) {
				for (int k = y; k < y + 10; k++) {
					// 아직 true로 변경되지 않은 색종이 영역만 true로 변경하고 카운팅
					if(!ch[j][k]) {
						ch[j][k] = true;
						cnt++; 
					}
				}
			}
		}
		
		System.out.println(cnt);
	}
}
