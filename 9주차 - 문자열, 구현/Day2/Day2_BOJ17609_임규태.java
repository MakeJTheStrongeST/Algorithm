import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int tc=0;tc<t;tc++) {
			System.out.println(solve());
		}
	}
	static int solve() throws IOException{
		String in = br.readLine();
		int ret1 = 0;
		for(int l=0,r=in.length()-1;l<r && ret1 < 2;l++,r--) {
			if(in.charAt(l) != in.charAt(r)) {
				if(ret1 == 1) {
					ret1 = 2;
					break;
				}
				ret1 = 1;
				if(in.charAt(l+1) == in.charAt(r)) {
					l++;
				}else if(in.charAt(l) == in.charAt(r-1)) {
					r--;
				}else {
					ret1 = 2;
				}
			}
		}

		int ret2 = 0;
		for(int l=0,r=in.length()-1;l<r && ret2 < 2;l++,r--) {
			if(in.charAt(l) != in.charAt(r)) {
				if(ret2 == 1) {
					ret2 = 2;
					break;
				}
				ret2 = 1;
				if(in.charAt(l) == in.charAt(r-1)) {
					r--;
				}else if(in.charAt(l+1) == in.charAt(r)) {
					l++;
				}else {
					ret2 = 2;
				}
			}
		}
		
		return Math.min(ret1, ret2);
	}
}
