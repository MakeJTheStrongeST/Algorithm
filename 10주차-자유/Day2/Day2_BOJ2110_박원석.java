package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Day2_BOJ2110_박원석 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int[] x = new int[N]; 
		for(int i = 0; i < N; i++) {
			x[i] = Integer.parseInt(in.readLine());
		}
		
		Arrays.sort(x);
		
		int lt = 1, rt = x[N - 1] - x[0], mid = 0, cnt = 0, prev = 0, answer = 0;
		while(lt <= rt) {
			mid = (lt + rt) / 2;
			cnt = 1; 
			prev = x[0];
			
			for(int i = 1; i < N; i++) {
				if(x[i] - prev >= mid) {
					cnt++;
					prev = x[i];
				} 
			}
			
			if(cnt < C) rt = mid - 1;
			else {
				answer = mid;
				lt = mid + 1;
			}
		}
		
		System.out.println(answer);
	}
}
