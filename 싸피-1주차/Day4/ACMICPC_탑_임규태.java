import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n], ans = new int[n];
		
		Stack<Integer> stk = new Stack();
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=n-1;i>=0;i--) {
			while(!stk.isEmpty() && arr[stk.peek()] <= arr[i]) {
				int idx = stk.pop();
				ans[idx] = i+1;
			}
			stk.add(i);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) sb.append(ans[i]).append(" ");
		System.out.print(sb.toString());
		
	}
}
