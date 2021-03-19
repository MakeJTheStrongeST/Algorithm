import java.io.*;
import java.util.*;

public class mnsoft {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb,sb2;
	
	
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int i=1;i<=t;i++) solve();
	}
	
	static void solve() throws Exception {
		String in = br.readLine();
		Stack<Character> stack = new Stack<>();
		Stack<Integer> intStack = new Stack<>();
		
		for(int i=0;i<in.length();i++) {
			char cur = in.charAt(i);
			if(Character.isAlphabetic(cur) || cur == '(') {
				stack.push(cur);
			}else if(Character.isDigit(cur)) {
				sb = new StringBuilder();
				while(Character.isDigit(in.charAt(i))) {
					sb.append(in.charAt(i));
					i++;
				}
				i--;
				int k = Integer.parseInt(sb.toString());
				intStack.push(k);
			}else {
				sb = new StringBuilder();
				sb2 = new StringBuilder();
				while(stack.peek() != '(') {
					sb.append(stack.pop());
				}
				sb = sb.reverse();
				stack.pop();
				int k = intStack.pop();
				for(int j=0;j<k;j++) {
					sb2.append(sb.toString());
				}
				for(int j=0;j<sb2.length();j++) {
					stack.push(sb2.charAt(j));
				}
			}
		}
		
		sb = new StringBuilder();
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		System.out.println(sb.reverse().toString());
	}
}
