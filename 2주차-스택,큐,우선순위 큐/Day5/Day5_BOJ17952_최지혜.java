import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class HwNeverEnd {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		Stack<int[]> stk = new Stack<>();
		int score = 0;
		for(int i = 0; i<T; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			if(st.nextToken().equals("1")) { //새 과제 받음
				int[] hw = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())}; //일단 1분동안은 함
				if(--hw[1]==0) 
					score += hw[0];
				else 
					stk.push(hw);
//				System.out.println("new hw : push " + hw[0] + " "+hw[1]);
			}else if(!stk.isEmpty()) { //새 과제 없음
				int[] hw = stk.pop();
//				System.out.println("last hw : push " + hw[0] + " "+hw[1]);
				if(--hw[1]==0) 
					score += hw[0];
				else 
					stk.push(hw);
			}
		}
		System.out.println(score);
	}
}
