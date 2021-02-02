import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int[] chk = new int[1000001],ans = new int[1000001], arr = new int[1000001];

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			chk[arr[i]]++;
		}
		
		Stack<Integer> st = new Stack();
		for(int i=0;i<n;i++) {
			while(!st.isEmpty() && chk[arr[st.peek()]] < chk[arr[i]]) {
				ans[st.peek()] = arr[i];
				st.pop();
			}
			st.push(i);
		}
		while(!st.isEmpty()) {
			ans[st.peek()] = -1;
			st.pop();
		}
		StringBuilder sb = new StringBuilder(); 
		for(int i=0;i<n;i++) sb.append(ans[i]).append(" ");
		System.out.println(sb.toString());
	}
}

