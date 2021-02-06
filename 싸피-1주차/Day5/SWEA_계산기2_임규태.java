import java.io.*;
import java.util.*;

public class 계산기2 {
	static BufferedReader br;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=1;i<=10;i++) System.out.println("#"+i+" "+solve());
	}
	
	static int solve() throws NumberFormatException, IOException {
		int n = Integer.parseInt(br.readLine());
		char[] in = br.readLine().toCharArray();
		List<Character> post = new ArrayList<Character>();
		Stack<Character> first = new Stack<Character>();
		Stack<Integer> second = new Stack<Integer>();
		
		for(char c : in) {
			if('0' <= c && c <= '9') post.add(c);
			else if(c == '+'){
				while(!first.isEmpty()) post.add(first.pop());
				first.push(c);
			}
			else {
				while(!first.isEmpty() && first.peek() == '*') post.add(first.pop());
				first.push(c);
			}
		}
		
		while(!first.isEmpty()) post.add(first.pop());
		
		
		for(char c : post) {
			if(c == '+' || c == '*') {
				if(c == '+') second.push(second.pop()+second.pop());
				else second.push(second.pop()*second.pop());
			}
			else {
				second.push(c-'0');
			}
		}
		
		return second.peek();
	}
}
