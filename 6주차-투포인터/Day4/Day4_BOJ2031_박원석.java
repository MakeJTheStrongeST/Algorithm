package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day4_BOJ2031_¹Ú¿ø¼® {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		for(int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(in.readLine());
		int[] check = new int[d + 1];
		
		int cnt = 0, max = Integer.MIN_VALUE;
		for(int i=0; i<k; i++) {
			if(check[arr[i]] == 0) cnt++;
			check[arr[i]]++;
		}
		if(check[c] == 0) max = cnt + 1;
		
		int lt = 0, rt = k - 1;
		while(true) {
			if(check[arr[lt]] == 1) cnt--;
			check[arr[lt++]]--;
			
			rt++;
			if(rt >= N) rt = 0;
			if(check[arr[rt]] == 0) cnt++;
			check[arr[rt]]++;
			
			if(check[c] == 0) max = Math.max(max, cnt + 1);
			else max = Math.max(max, cnt);
			
			if(lt == N - 1) break;
		}
		
		System.out.println(max);
	}
}
