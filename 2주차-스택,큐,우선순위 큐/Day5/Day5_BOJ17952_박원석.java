package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Day5_BOJ17952_¹Ú¿ø¼® {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, A, T, answer;
	static Stack<int[]> stack = new Stack<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(in.readLine());
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			if(st.nextToken().charAt(0) == '1') {
				A = Integer.parseInt(st.nextToken());
				T = Integer.parseInt(st.nextToken());
				stack.push(new int[] {A, T});
			} 
			
			if(!stack.isEmpty()) {
				int[] tmp = stack.pop();
				A = tmp[0];
				T = tmp[1] - 1;
				if(T == 0) answer += A;
				else stack.push(new int[] {A, T});
			}		
		}
		System.out.println(answer);
	}
}
