import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	static final String[] compressed = {"3(hi)", "2(3(hi)co)", "10(p)", "2(2(hi)2(co))x2(bo)", "2(2(hi)2(co)3(ho))"};
	
	public static void main(String[] args) {
		for(String s : compressed) {
			System.out.println(solution(s));
		}
	}
	
	private static String solution(String compressed) {
		int len = compressed.length(); // 압축된 문자열 길이
		Deque<String> stack = new ArrayDeque<>();
		// 압축 문자열을 K(S)로 표현할 때
		String S = ""; // S를 표현하기 위한 임시 문자열
		String K = ""; // K를 표현하기 위한 임시 문자열
		
		for(int i=0; i<len; i++) {
			char c = compressed.charAt(i);
			
			// 숫자인 경우
			if(c >= '0' && c <= '9') {
				K += c; // K를 만들어감
			} 
			// '(' 인 경우
			else if(c == '(') {
				stack.push(K); // 만들어진 K 스택에 푸쉬
				K = ""; // 다음 K를 위해 빈 문자열로 초기화
				stack.push(String.valueOf(c)); // '('를 안 넣으면 나중에 정수, 문자열 구분을 하기 어려움
			} 
			// ')' 인 경우
			else if(c == ')') {
				if(stack.peek().equals("(")) {
					stack.pop(); // '(' 제거
					int n = Integer.parseInt(stack.pop()); // 스택에서 K 추출
					
					// 압축 문자열 복원
					String tmp = "";
					for(int j = 0; j < n; j++) {
						tmp += S;
					}
					
					stack.push(tmp); // 복원한 문자열 스택에 푸쉬
					S = ""; // 다음 S를 위해 빈 문자열로 초기화
				} 
				// '(' 전까지 복원 마친 문자열이 여러개 저장되어 있으면 
				else { 
					// 남아있는 각각의 복원한 문자열 합치기
					String tmp = "";
					Deque<String> stack2 = new ArrayDeque<>();
					while(!stack.peek().equals("(")) {
						stack2.push(stack.poll());
					}
					while(!stack2.isEmpty()) {
						tmp += stack2.poll();
					}
					
					stack.pop(); // '(' 제거
					int n = Integer.parseInt(stack.pop()); // 스택에서 K 추출
					
					// 복원
					String tmp2 = "";
					for(int j = 0; j < n; j++) {
						tmp2 += tmp;
					}
					stack.push(tmp2);
				}
				
			} 
			// 문자인 경우
			else {
				if(stack.peek().equals("(")) {
					S += c;
				} else {
					stack.push(stack.pop() + c);
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		Deque<String> stack2 = new ArrayDeque<>();
		while(!stack.isEmpty()) {
			stack2.push(stack.poll());
		}
		while(!stack2.isEmpty()) {
			sb.append(stack2.pop());
		}
		return sb.toString();
	}
}
