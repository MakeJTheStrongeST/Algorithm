import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] cnt = new int[100001];
		int l = 0;
		int r = 0;
		int ans = 0;
		while(r<n) {
			cnt[arr[r]]++;
			while(cnt[arr[r]] > k) {
				cnt[arr[l]]--;
				l++;
			}
			r++;
			ans = Math.max(ans,r-l);
		}
		System.out.println(ans);
	}
}
