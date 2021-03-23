import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Day1_BOJ5525_박원석 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// init
		int N = Integer.parseInt(in.readLine());
		int tLength = Integer.parseInt(in.readLine());
		int pLength = 3 + 2 * (N - 1);
		char[] text = in.readLine().toCharArray();
		char[] pattern = new char[pLength];
		for(int i = 0; i < pLength; i++) {
			if(i % 2 == 0) pattern[i] = 'I';
			else pattern[i] = 'O';
		}
		
		// KMP(Knuth–Morris–Pratt) algorithm
		// Create fail function 
		int[] fail = new int[pLength];
	    	for(int i=1, j=0; i<pLength; i++){
			while(j > 0 && pattern[i] != pattern[j]) 
				j = fail[j-1];  
			if(pattern[i] == pattern[j]) fail[i] = ++j;
		}
	    
	    	int cnt = 0;
		// i : text pointer , j: pattern pointer 
		for(int i=0,j=0; i<tLength; ++i) { 
			while(j>0 && text[i] != pattern[j]) j = fail[j-1]; 
			
			if(text[i] == pattern[j]) {
				if(j == pLength-1) { 
					cnt++; 
					j=fail[j]; 
				}else { 
					j++;
				}
			}
		}
		
		System.out.println(cnt);
	}
}
