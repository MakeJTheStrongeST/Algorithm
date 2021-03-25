import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		String compressed = sc.nextLine();
		String[] split = compressed.split(":");
		
		// :: 복원
		int cnt = 8;
		for(String s : split) 
			if(!s.equals("")) cnt--;
		String tmp = "";
		if(compressed.indexOf("::") == compressed.length() - 2) {
			for(int i = 0; i < cnt; i++)
				tmp += ":0000";
		} else if(compressed.indexOf("::") == 0) {
			for(int i = 0; i < cnt; i++)
				tmp += "0000:";
		} else {
			tmp = ":";
			for(int i = 0; i < cnt; i++)
				tmp += "0000:";
		}
		compressed = compressed.replace("::", tmp);
		
		// 4자리 아닌 수 복원
		split = compressed.split(":");
		for(int i = 0; i < 8; i++) {
			int sLen = split[i].length();
			if(sLen != 4) {
				for(int j =0; j < 4 - sLen; j++) {
					split[i] = "0" + split[i];
				}
			}
		}
		
		// 출력
		for(int i = 0; i < 8; i++) {
			if(i == 7) System.out.print(split[i]);
			else System.out.print(split[i] + ":");
		}
	}
}
