import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int i=0;i<t;i++) solve();
	}
	static void solve() throws IOException {
		int n,m,k;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		int LIMIT = n == m ? n : n+m-1;
		int[] house = new int[LIMIT];
		for(int i=0;i<n;i++) {
			house[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=n;i<LIMIT;i++) {
			house[i] = house[i-n];
		}
		
		int l,r,sum,ans;
		ans = sum = l = r = 0;
		
		for(r=0;r<m-1;r++) {
			sum += house[r];
		}
		
		while(r<LIMIT) {
			sum += house[r++];
			if(sum < k) ans++;
			sum -= house[l++];
		}
		System.out.println(ans);
	}
}
