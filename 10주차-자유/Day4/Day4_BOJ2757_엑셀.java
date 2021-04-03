package algorithm;

import java.util.Scanner;

public class Day4_BOJ2757_엑셀 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			String answer = "";
			String[] RC = sc.next().split("[RC]");
			int n = Integer.parseInt(RC[1]);
			int m = Integer.parseInt(RC[2]);
			
			if(n == 0 && m == 0) break;
			
			while(m > 0) {
				m--;
				char c = (char) (m % 26 + 'A');
				answer = c + answer;
				m /= 26;
			}
			
			sb.append(answer).append(RC[1]).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
