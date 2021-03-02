import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int k = Integer.parseInt(br.readLine());
		
		int ans = 0;
		int l = 0;
		int r = n-1;
		while(l<r) {
			if(arr[l]+arr[r] == k) ans++;
			
			if(arr[l]+arr[r] >= k) r--;
			else if(arr[l]+arr[r] < k) l++;
		}
		System.out.println(ans);
	}
}
