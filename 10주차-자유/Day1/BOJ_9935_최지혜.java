package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_9935_문자열폭발 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] input = br.readLine().toCharArray();
		char[] bomb = br.readLine().toCharArray();
		
		Stack<Character> stk = new Stack<>();
		int ilen = input.length;
		int blen = bomb.length;
		
		for (int i = 0; i < ilen; i++) {
			stk.push(input[i]); //일단 모두 스택에 push
			
			if(stk.size() >= blen) { //스택 크기가 폭발할 문자열 길이보다 같거나 클 때만 비교 시작
				boolean flag = true;
				for (int j = 0; j < blen; j++) {
					if(stk.get(stk.size() - blen + j) != bomb[j]) { // pop 하지 않고 get으로 보기만 함 (pop하고 폭발문자열 아니면 다시 push => 시간초과)
						flag = false;
						break;
					}
				}
				if(flag) {
					for (int j = 0; j < blen; j++) {
						stk.pop();
					}
				}
			}
		}
		
		//출력
		StringBuilder sb = new StringBuilder();
		for (Character ch : stk) {
			sb.append(ch);
		}
		
		System.out.println(sb.length()==0 ? "FRULA" : sb.toString());
	}

}
