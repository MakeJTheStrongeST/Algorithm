import java.io.*;
import java.util.*;

public class  {
	static BufferedReader br;
	static StringTokenizer st;

	static int d,n,m;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		d = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n+2];
		
		arr[0] = 0; 
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		arr[n+1] = d;
		
		Arrays.sort(arr);
		
		long l = 0;
		long r = Integer.MAX_VALUE;
		long mid = 0;
		while(l+1<r) {
			mid = (l+r)/2;
			if(f(mid)) l = mid;
			else r = mid;
		}
		System.out.println(l);
	}
	
	static boolean f(long test) {
		
		int jump = 0;
		int tmpm = m;
		for(int i=0;i<n+1;i++) { // i+1
			if(arr[i+1]-arr[i]+jump < test) {
				tmpm--;
				jump += arr[i+1]-arr[i];
			}
			else {
				jump = 0;
			}
		}
		if(jump > 0 && jump < test) return false;
		if(jump > 0) tmpm--;
		
		return tmpm >= 0;
	}
}
