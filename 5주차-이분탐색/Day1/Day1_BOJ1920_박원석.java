package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Day1_BOJ1920_�ڿ��� {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// N���� ���� �迭 A �Է� �ޱ�
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] A = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		for(int i=0; i<N; i++) 
			A[i] = Integer.parseInt(st.nextToken());
		
		// �̺�Ž���� ���� ����
		Arrays.sort(A);
		
		// M ���� �ڿ��� A �迭�� �����ϴ��� �̺�Ž������ Ȯ��
		int M = Integer.parseInt(in.readLine());
		st = new StringTokenizer(in.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<M; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			if(Arrays.binarySearch(A, num) >= 0)
				sb.append("1\n");
			else
				sb.append("0\n");
		}
		
		// ���
		System.out.println(sb.toString());
	}
}
