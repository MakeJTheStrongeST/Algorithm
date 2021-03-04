package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Day1_BOJ3273_¹Ú¿ø¼® {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(in.readLine());
		
		Arrays.sort(arr);
		
		int lt = 0, rt = n - 1, cnt = 0;
		while(lt < rt) {
			int sum = arr[lt] + arr[rt];
			
			if(sum == x) {
				cnt++;
				lt++;
				rt--;
			}
			if(sum < x) lt++;
			if(sum > x) rt--;
		}
		
		System.out.println(cnt);
	}
}
