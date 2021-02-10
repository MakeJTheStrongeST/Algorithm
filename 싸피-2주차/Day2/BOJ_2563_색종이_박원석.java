package week2.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2563_������_�ڿ��� {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(in.readLine()); // ������ ��
		boolean[][] ch = new boolean[100][100]; // ������ ������ true, �� ������ false
		int cnt = 0; // ������ ���� ����

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int x = Integer.parseInt(st.nextToken()); // ������ x��ǥ (���� �Ʒ� ������)
			int y = Integer.parseInt(st.nextToken()); // ������ y��ǥ (���� �Ʒ� ������)

			// ������ ������ true�� ����
			for (int j = x; j < x + 10; j++) {
				for (int k = y; k < y + 10; k++) {
					// ���� true�� ������� ���� ������ ������ true�� �����ϰ� ī����
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
