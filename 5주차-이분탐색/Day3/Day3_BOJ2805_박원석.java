package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Day3_BOJ2805_�ڿ��� {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		// �Է�
		int N = Integer.parseInt(st.nextToken()); // ������ ��
		int M = Integer.parseInt(st.nextToken()); // �ʿ��� ���� ����
		long[] tree = new long[N]; // N���� ���� ����
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++) tree[i] = Long.parseLong(st.nextToken());
		
		// �Ķ��Ʈ�� ��ġ�� ���� �������� ����
		Arrays.sort(tree);
		
		// �Ķ��Ʈ�� ��ġ (�־��� ���� ������ ���ϴ� ���ǿ� ���� ��ġ�ϴ� ���� ã�Ƴ��� �˰���)
		long left = 0, right = tree[N - 1], answer = Integer.MIN_VALUE;
		while(left <= right) {
			long mid = (left + right) / 2;
			long sum = 0;
			
			// mid ���̷� �߶��� ��, ������ �� �ִ� ���� ����
			for(int i = 0; i < N; i++) {
				if(tree[i] > mid) {
					sum += (tree[i] - mid);
				}
			}
			
			// �� ���ϴ� ���̸� ������ �� �ִٸ�, �� ���� ���̰� �ִ�
			if(sum == M) {
				answer = mid;
				break;
			}
			
			if(sum < M) { // �����ϴٸ� �� ���� ���̷� �õ�
				right = mid - 1;
			} else { // ���´ٸ� �� ���� ���̷� �õ� (�� �κ��� ������ ��� ���� �ĺ�)
				left = mid + 1;
				answer = Math.max(answer, mid); // ���� �ĺ��� �� �ִ밪 �̾Ƴ���
			}
		}
		
		System.out.println(answer);
	}
}
