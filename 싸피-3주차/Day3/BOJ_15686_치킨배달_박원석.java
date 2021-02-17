package week3.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_15686_치킨배달_박원석 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M, hSize, cSize, answer = Integer.MAX_VALUE;
	static ArrayList<int[]> home = new ArrayList<>();
	static ArrayList<int[]> chicken = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for(int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());
				if(num == 1) {
					hSize++;
					home.add(new int[] {i, j});
				}
				else if(num == 2) {
					cSize++;
					chicken.add(new int[] {i, j});
				}
			}
		}
		
		int[] P = new int[cSize];
		for(int i = 0; i < M; i++) P[cSize -1 - i] = 1;
		
		do {
			int cnt = 0;
			int[] cIdx = new int[M];
			for(int i = 0; i < cSize; i++) {
				if(P[i] == 1) {
					cIdx[cnt++] = i;
				}
			}
			
			int sum = 0;
			for(int i = 0; i < hSize; i++) {
				int min = Integer.MAX_VALUE;
				int hX = home.get(i)[0];
				int hY = home.get(i)[1];
				
				for(int j = 0; j < M; j++) {
					int cX = chicken.get(cIdx[j])[0];
					int cY = chicken.get(cIdx[j])[1];
					min = Math.min(min, Math.abs(hX - cX) + Math.abs(hY - cY));
				}
				
				sum += min;
			}
			
			answer = Math.min(answer, sum);
		} while(nextPerm(P));
		
		System.out.println(answer);
	}

	private static boolean nextPerm(int[] arr) {
		int i = cSize - 1;
		while (i > 0 && arr[i - 1] >= arr[i]) --i;

		if (i == 0) return false;

		int j = cSize - 1;
		while (arr[i - 1] >= arr[j]) --j;

		swap(arr, i - 1, j);

		int k = cSize - 1;
		while (i < k)
			swap(arr, i++, k--);
		return true;
	}

	private static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
