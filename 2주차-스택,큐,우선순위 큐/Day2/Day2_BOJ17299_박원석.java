import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Day2_BOJ17299_�ڿ��� {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Stack<Pair> stack = new Stack<>();
		int N = Integer.parseInt(in.readLine());
		int[] A = new int[N];
		int[] cnt = new int[1000001];
		int[] answer = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		for(int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
			cnt[A[i]]++;
		}
		
		// �������� Ȯ��
		for(int i = N - 1; i >= 0; i--) {
			// ���纸�� ���� �� ���� ���ÿ� �ִٸ� ���̻� �ʿ� �����Ƿ� ���ÿ��� �����Ѵ�.
			while(!stack.empty() && cnt[A[i]] >= stack.peek().cnt)
				stack.pop();
			
			// ������ ����ִٸ� ���纸�� ū �󵵼��� ���ÿ� ���ٴ� ���̴�.
			// ���ÿ� �����ִ� ���� �ִٸ� ū �󵵼� �߿� ���� �ε������� ���ÿ��� ���� ���� ���� �� �ֵ��� ����Ǿ� �ִ�.
			if(stack.empty())
				answer[i] = -1;
			else
				answer[i] = stack.peek().num;
			
			// ���ÿ� ����ؼ� �����Ѵ�.
			stack.add(new Pair(A[i], cnt[A[i]]));
		}
		
		// ���
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++)
			sb.append(answer[i]).append(" ");
		System.out.println(sb.toString());
	}
}

class Pair {
	int num;
	int cnt;
	
	Pair(int num, int cnt) {
		this.num = num;
		this.cnt = cnt;
	}
}