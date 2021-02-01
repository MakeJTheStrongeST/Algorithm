package com.ssafy.hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1244 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int sNum = Integer.parseInt(in.readLine()); // ����ġ ����
		int[] status = new int[sNum + 1]; // ����ġ ����
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		for (int i = 1; i <= sNum; i++)
			status[i] = Integer.parseInt(st.nextToken());

		int pNum = Integer.parseInt(in.readLine()); // �л���
		for (int i = 0; i < pNum; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int gender = Integer.parseInt(st.nextToken()); // ����
			int number = Integer.parseInt(st.nextToken()); // ���� ��

			if (gender == 1) { // ���л��� ���
				// ���� ���� ��� �ε����� ����ġ ����
				for (int j = number; j <= sNum; j += number)
					status[j] ^= 1;
			} else { // ���л��� ���
				// ���� ���� ��ġ�� �ٷ� ����
				status[number] ^= 1;
				
				int left = number - 1; // ���� �� ����
				int right = number + 1; // ���� �� ����
				
				// (1 ~ ����ġ) ���� ���� �ȿ����� üũ
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

		// ��� ���
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= sNum; i++) {
			sb.append(status[i]).append(" ");
			if(i % 20 == 0)
				sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
