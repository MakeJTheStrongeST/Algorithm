import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;

	static int[] arr = new int[100000];
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr,0,n);
		int ans1 = (int)1e9;
		int ans2 = (int)1e9;
		
		for(int i=0;i<n-1;i++) {
			int l = i+1;
			int r = n;
			int mid = 0;
			while(l+1<r) {
				mid = (l+r)/2;
				if(arr[mid]+arr[i] <= 0) l = mid;
				else r = mid;
			}
			if(l != n-1 && Math.abs(arr[l+1]+arr[i]) < Math.abs(arr[l]+arr[i])) l++;
			if(Math.abs(ans1 + ans2) > Math.abs(arr[l]+arr[i]) ) {
				ans1 = arr[i];
				ans2 = arr[l];
			}
		}
		
		System.out.println(Math.min(ans1,ans2)+" "+Math.max(ans1,ans2));
	}
}
