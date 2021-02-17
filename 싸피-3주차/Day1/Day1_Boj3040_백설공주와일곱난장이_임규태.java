import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;

	static int[] arr = new int[9];
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0;i<9;i++) arr[i] = Integer.parseInt(br.readLine());
		
		f(0,0,0);
	}
	
	static boolean f(int idx,int cnt, int mask) {
		if(cnt == 7) {
			int sum = 0;
			for(int i=0;i<9;i++) {
				if((mask&1<<i) != 0) sum += arr[i];
			}
			if(sum == 100) {
				for(int i=0;i<9;i++) {
					if((mask&1<<i) != 0) System.out.println(arr[i]);
				}
				return true;
			}
			return false;
		}
		if(idx == 9) return false;

		if(f(idx+1,cnt,mask)) return true;
		if(f(idx+1,cnt+1,mask|1<<idx)) return true;
		
		return false;
	}
}
