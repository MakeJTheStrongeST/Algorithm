package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Day1_BOJ1920_박원석 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// N개의 정수 배열 A 입력 받기
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] A = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		for(int i=0; i<N; i++) 
			A[i] = Integer.parseInt(st.nextToken());
		
		// 이분탐색을 위한 정렬
		Arrays.sort(A);
		
		// M 개의 자연수 A 배열에 존재하는지 이분탐색으로 확인
		int M = Integer.parseInt(in.readLine());
		st = new StringTokenizer(in.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<M; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			if(Arrays.binarySearch(A, num) >= 0)
				sb.append("1\n");
			else
				sb.append("0\n");
		}
		
		// 결과
		System.out.println(sb.toString());
	}
}
