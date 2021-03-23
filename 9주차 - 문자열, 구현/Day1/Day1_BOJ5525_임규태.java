import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		String in = br.readLine();
		int cnt = 0;
		int ans = 0;
		for(int r=0;r<in.length();r++) {
			char c = in.charAt(r);
			cnt = 0;
			if(c == 'I') {
				r++; // I --
				while(r < in.length()-1 && in.charAt(r) == 'O' && in.charAt(r+1) == 'I') {
					r += 2;
					cnt++;
					if(cnt >= n) ans++;
				}
				r--;
			}
		}
		System.out.println(ans);
	}
}
