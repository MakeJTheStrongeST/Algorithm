import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int n,d,k,c;
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n*2];
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		for(int i=n;i<n+k-1;i++) {
			arr[i] = arr[i-n];
		}
		
		int l,r,cnt;
		cnt = l = r = 0;
		int[] chk = new int[3001];
        chk[c]++;
        cnt++;
		for(r = 0;r<k-1;r++) {
			if(chk[arr[r]] == 0) {
				cnt++;
			}
			chk[arr[r]]++;
		}
		int ans = 0;
		for(;r<n+k-1;r++) {
			if(chk[arr[r]] == 0) {
				cnt++;
			}
			chk[arr[r]]++;
			
			ans = Math.max(ans, cnt);
			
			chk[arr[l]]--;
			if(chk[arr[l]] == 0) {
				cnt--;
			}
			l++;
		}
		System.out.println(ans);
	}
}
