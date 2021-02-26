package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Day4_BOJ6209_¹Ú¿ø¼® {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int d = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(in.readLine());
	
		Arrays.sort(arr);
		
		int left = 0, right = d, answer = Integer.MIN_VALUE;
		while(left <= right) {
			int mid = (left + right) >> 1;
			
			int pos = 0, cnt = 0;
			for(int i = 0; i < n; i++) {
				if(arr[i] - pos >= mid) pos = arr[i];
				else cnt++;
			}
			if(d - pos < mid) cnt++;
			
			if(cnt > m) right = mid - 1;
			else {
				answer = mid;
				left = mid + 1;
			}
			
		}
		
		System.out.println(answer);
	}
}
