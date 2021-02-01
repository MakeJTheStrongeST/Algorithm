package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Day1_BOJ9012_박원석 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());

		for (int i = 1; i <= T; i++) {
			String str = in.readLine();
			int sum = 0;
			boolean flag = true;

			for (int j = 0, len = str.length(); j < len; j++) {
				if(str.charAt(j) == '(') sum++;
				else sum--;
				
				if(sum < 0) {
					flag = false;
					break;
				}
			}
			
			if(sum != 0) flag = false;
			
			if(flag) System.out.println("YES");
			else System.out.println("NO");
		}

	}
}