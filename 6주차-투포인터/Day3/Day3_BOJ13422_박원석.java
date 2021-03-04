package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day3_BOJ13422_¹Ú¿ø¼® {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(in.readLine());
		for(int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(in.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int[] arr = new int[N];
			st = new StringTokenizer(in.readLine());
			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			if(N == M) {
				int sum = 0;
				for(int i = 0; i < N; i++) sum += arr[i];
				if(sum < K) sb.append("1\n");
				else sb.append("0\n");
				continue;
			}
			
			int lt = 0, rt = M - 1, sum = 0, cnt = 0;
			for(int i = lt; i <= rt; i++) sum += arr[i];
			if(sum < K) cnt++;
			
			while(true) {
				sum = sum - arr[lt++] + arr[++rt];
				
				if(sum < K) cnt++;
				
				if(rt == N - 1) rt = -1;
				if(rt == M - 2) break;
			}
			
			sb.append(cnt).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
