import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;

	static long n,m;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		n = Long.parseLong(st.nextToken());
		m = Long.parseLong(st.nextToken());
		arr = new int[(int)n];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int l,r,mid;
		l = 0;
		r = Integer.MAX_VALUE;
		while(l+1<r) {
			mid = (l+r)/2;
			if(f(mid)) l = mid;
			else r = mid;
		}
		System.out.println(l);
		
	}
	
	static boolean f(int mid) {
		long chk = 0;
		for(int i=0;i<n;i++) {
			chk += Math.max(0, arr[i]-mid);
		}
		return chk >= m;
	}
}
