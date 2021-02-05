import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class NGF2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] F = new int[1000001];
		int[][] numbers = new int[N+1][];
		int[] ngf = new int[N+1];
		Stack<int[]> stk = new Stack<>();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1;i<=N;i++) {
			int num =  Integer.parseInt(st.nextToken());
			numbers[i] = new int[] {i, num};
			F[num]++;
		}
		ngf[N] = -1;
		Loop:for(int i=N-1; i>=1; i--) {
			if(F[numbers[i][1]] < F[numbers[i+1][1]]) {
				stk.push(numbers[i+1]);
			}
			while(!stk.isEmpty()) {
				int[] popNum = stk.pop();
				if(F[numbers[i][1]]<F[popNum[1]]) {
					ngf[i] = popNum[1];
					stk.push(popNum);
					continue Loop;
				}
			}
			ngf[i]=-1;
		}
		//출력
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=N; i++) {
			sb.append(ngf[i]).append(" ");
		}
		System.out.println(sb);
	}
}
