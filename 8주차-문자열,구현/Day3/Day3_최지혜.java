package string;
/*
3(hi)
2(3(hi)co)
10(p)
2(2(hi)2(co))x2(bo)
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Pgms_codingTest {
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		for (int i = 0; i < 4; i++) {
			
			String input = br.readLine();
			System.out.println(decom(input));
		}
	}
	
	private static String decom(String str) {

		Stack<Integer> stk = new Stack<>(); //괄호쌍 위치 파악하기 위한 스택. 스택이 비면 괄호가 끝난 것
		char[] chArr = str.toCharArray();
		int start = -1, end = -1, num = -1, ch = -1, res=0;
		int[] rep = new int[100];
		boolean flag = false;
		StringBuilder sb = new StringBuilder();
		int i = 0;
		for(i = 0; i < chArr.length; i++) {
			if(chArr[i]=='(') {
				break;
			}else if(chArr[i]>='0' && chArr[i]<='9') {
				num = i;
			}else {
				ch = i;
			}
		}
		if(i==chArr.length) return str; //괄호 없음
		
		for(i = num; i > ch; i--) res += (chArr[i]-'0')*Math.pow(10, num-i);

		for(i = 0; i < chArr.length; i++) {

			if(chArr[i]=='(') {
				stk.push(i);
				flag = true;
				
			}else if(chArr[i]==')') {

				int temp = stk.pop();
				if(stk.isEmpty()) {
					start = temp;
					end = i;
					
					if(num!=0 && 0<ch+1)sb.append(str.substring(0, ch+1));
					if(start+1<end) for(i = 0; i < res; i++) sb.append(decom(str.substring(start+1, end)));
					if(end+1<chArr.length)sb.append(decom(str.substring(end+1, chArr.length)));

					break;
				}	
			}
		}

		return sb.toString();
	}

}
