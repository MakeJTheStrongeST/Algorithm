import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
	static Scanner sc = new Scanner(System.in);
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int t = Integer.parseInt(br.readLine());
		for(int i=0;i<t;i++) solve();
	}
	
	static void solve() throws IOException {
		String in = br.readLine();
		Stack<Character> st = new Stack(); 
		boolean ans = true;
		for(int i=0;i<in.length();i++) {
			if(in.charAt(i) == '(') st.push('(');
			else {
				if(!st.isEmpty()) st.pop();
				else ans = false;
			}
		}
		if(!st.isEmpty()) ans = false;
		if(ans) System.out.println("YES");
		else System.out.println("NO");
	}
	
}
