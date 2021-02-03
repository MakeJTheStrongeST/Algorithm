import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Parenthesis {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		Stack<Integer> st = new Stack<>();
		Loop:for(int i=0; i<TC ;i++) {
			st.setSize(0);
			char[] parenthesis = br.readLine().toCharArray();
			for(int j=0, size = parenthesis.length; j<size ;j++) {
				if(parenthesis[j]==')') {
					if(st.isEmpty()) {
						 sb.append("NO\n");
						 continue Loop;
					}
					st.pop();
				
				}else st.push(1);
			}
			if(st.size()>0) sb.append("NO\n");
			else sb.append("YES\n");
		}
			
		System.out.println(sb);
	}

}
