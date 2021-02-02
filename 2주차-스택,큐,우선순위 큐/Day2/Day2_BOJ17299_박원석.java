import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Day2_BOJ17299_박원석 {
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
		
		// 역순으로 확인
		for(int i = N - 1; i >= 0; i--) {
			// 현재보다 작은 빈도 수가 스택에 있다면 더이상 필요 없으므로 스택에서 제거한다.
			while(!stack.empty() && cnt[A[i]] >= stack.peek().cnt)
				stack.pop();
			
			// 스택이 비어있다면 현재보다 큰 빈도수가 스택에 없다는 것이다.
			// 스택에 남아있는 값이 있다면 큰 빈도수 중에 왼쪽 인덱스부터 스택에서 먼져 빠져 나올 수 있도록 저장되어 있다.
			if(stack.empty())
				answer[i] = -1;
			else
				answer[i] = stack.peek().num;
			
			// 스택에 계속해서 저장한다.
			stack.add(new Pair(A[i], cnt[A[i]]));
		}
		
		// 결과
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