package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Day2_15900_����Ż��_�ڿ��� {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
	static int N, a, b, totalCnt;
	static boolean[] ch;

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(in.readLine()); // ���� ����
		for (int i = 0; i <= N; i++)
			tree.add(new ArrayList<Integer>()); // ����Ʈ �ȿ� N + 1���� ��� �ִ� ����Ʈ�� �����Ѵ�.
												// ��������Ʈ�� Ʈ�� ����
		ch = new boolean[N + 1]; // �θ� ���� ���� ���� �����ϱ� ���� �湮 üũ (��������� ������ �����ؼ�...)

		// ��� ����
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			// ����� ����
			tree.get(b).add(a);
			tree.get(a).add(b);
		}

		ch[1] = true; // ��Ʈ 1���� �����ϹǷ� �湮 üũ
		DFS(1, 0);
		
		// ���������� ���� ���� Ȧ������ �����̰� �̱� �� ����
		// ������忡�� ��Ʈ���� ���������� ���ٰ� �����ϸ� ��
		if (totalCnt % 2 != 0)
			System.out.println("Yes");
		else
			System.out.println("No");
	}

	static void DFS(int v, int cnt) {
		// ��������� ��� ���̸� ī�����ϰ� ��͸� �����Ѵ�.
		// �������� �θ��常 �ִ� ����̴�.
		if (tree.get(v).size() == 1 && ch[tree.get(v).get(0)]) {
			totalCnt += cnt;
			return;
		}

		// ���� �켱 Ž��
		for (int i = 0; i < tree.get(v).size(); i++) {
			if (!ch[tree.get(v).get(i)]) { // �湮���� ���� ��常 Ž��(=�ڽ� ���θ� Ž��)
				ch[tree.get(v).get(i)] = true; // ���� ��忡�� �θ� ���� ���� �ʱ� ���� �湮 üũ
				DFS(tree.get(v).get(i), cnt + 1); // ���� ���� Ž���� ������.
				ch[tree.get(v).get(i)] = false; // ���� �ڽĳ�带 Ž���س����� ���� �湮 üũ ����
			}
		}
	}
}
