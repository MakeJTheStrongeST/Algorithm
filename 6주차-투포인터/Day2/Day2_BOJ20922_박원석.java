package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day2_BOJ20922_¹Ú¿ø¼® {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(in.readLine());
		for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
		int[] cnt = new int[100001];
		
		int lt = 0, rt = 0, len = 0, max = Integer.MIN_VALUE;
		
		while(rt < N) {
			if(lt == rt) {
				len = 1;
				rt++;
				cnt[arr[lt]]++;
				continue;
			}
			
			if(cnt[arr[rt]] + 1 <= K) {
				cnt[arr[rt]]++;
				len++;
				rt++;
			} else {
				cnt[arr[lt]]--;
				len--;
				lt++;
			}
			
			max = Math.max(max, len);
		}
		
		System.out.println(max);
	}
}
