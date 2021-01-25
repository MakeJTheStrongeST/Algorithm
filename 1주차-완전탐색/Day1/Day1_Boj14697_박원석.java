package week1;

import java.util.Scanner;

public class Day1_Boj14697_박원석 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] beds = new int[3]; // 방의 정원
		int n; // 학생 수
		int[] possible; // n명 분배 가능 -> possible[n] = 1
						// n명 분배 불가능 -> possible[n] = 0

		// 초기화
		for (int i = 0; i < 3; i++) {
			beds[i] = sc.nextInt();
		}
		n = sc.nextInt();
		possible = new int[n + 1];

		// 0명은 무조건 가능
		possible[0] = 1;

		// n명 가능 여부 확인
		for (int i = 0; i < 3; i++) {
			for (int j = beds[i]; j <= n; j++) {
				if (possible[j - beds[i]] == 1)
					possible[j] = 1;
			}
		}
		
		// 결과
		System.out.println(possible[n]);
		
		sc.close();
	}
}
