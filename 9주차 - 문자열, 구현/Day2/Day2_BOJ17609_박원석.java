import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Day2_BOJ17609_박원석 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(in.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			String word = in.readLine();
			sb.append(isPalindrome(word)).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	private static int isPalindrome(String word) {
		int result = 0, lt = 0, rt = word.length() - 1;
		
		while(lt < rt) {
			if(word.charAt(lt) == word.charAt(rt)) {
				lt++;
				rt--;
			} else {
				if(word.charAt(lt + 1) == word.charAt(rt) && word.charAt(lt) == word.charAt(rt - 1))
					result = Math.min(isPseudoPalindrom(word, lt + 1, rt), isPseudoPalindrom(word, lt, rt - 1));
				else if(word.charAt(lt + 1) == word.charAt(rt)) 
					result = isPseudoPalindrom(word, lt + 1, rt);
				else if(word.charAt(lt) == word.charAt(rt - 1))
					result = isPseudoPalindrom(word, lt, rt - 1);
				else
					result = 2;
				break;
			}
		}
		
		return result;
	}

	private static int isPseudoPalindrom(String word, int lt, int rt) {
		int result = 1;
		
		while(lt < rt) {
			if(word.charAt(lt) == word.charAt(rt)) {
				lt++;
				rt--;
			} else {
				result = 2;
				break;
			}
		}
		
		return result;
	}
}
