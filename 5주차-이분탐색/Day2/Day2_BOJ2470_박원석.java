package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Day2_BOJ2470_¹Ú¿ø¼® {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
	
		Arrays.sort(arr);
		
		int lIdx = 0, rIdx = N - 1, min = Integer.MAX_VALUE, answer1 = 0, answer2 = 0;
		while(lIdx < rIdx) {
			int left = arr[lIdx];
			int right = arr[rIdx];
			int sum = left + right;
			
			if(sum == 0) {
				answer1 = left;
				answer2 = right;
				break;
			}
			
			if(Math.abs(sum) < min) {
				answer1 = left;
				answer2 = right;
				min = Math.abs(sum);
			}
			
			if(sum < 0) lIdx++;
			else rIdx--;
		}
		
		System.out.println(answer1 + " " + answer2);
	}
}
