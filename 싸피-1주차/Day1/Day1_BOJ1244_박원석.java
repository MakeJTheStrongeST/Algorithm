package com.ssafy.hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1244 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int sNum = Integer.parseInt(in.readLine()); // 스위치 개수
		int[] status = new int[sNum + 1]; // 스위치 상태
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		for (int i = 1; i <= sNum; i++)
			status[i] = Integer.parseInt(st.nextToken());

		int pNum = Integer.parseInt(in.readLine()); // 학생수
		for (int i = 0; i < pNum; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int gender = Integer.parseInt(st.nextToken()); // 성별
			int number = Integer.parseInt(st.nextToken()); // 받은 수

			if (gender == 1) { // 남학생인 경우
				// 받은 수의 배수 인덱스의 스위치 변경
				for (int j = number; j <= sNum; j += number)
					status[j] ^= 1;
			} else { // 여학생인 경우
				// 받은 수의 위치는 바로 변경
				status[number] ^= 1;
				
				int left = number - 1; // 받은 수 좌측
				int right = number + 1; // 받은 수 우측
				
				// (1 ~ 스위치) 개수 범위 안에서만 체크
				while(left >= 1 && right <= sNum) {
					if(status[left] == status[right]) {
						status[left] ^= 1;
						status[right] ^= 1;
					} else {
						break;
					}
					left--;
					right++;
				}
			}
		}

		// 결과 출력
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= sNum; i++) {
			sb.append(status[i]).append(" ");
			if(i % 20 == 0)
				sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
