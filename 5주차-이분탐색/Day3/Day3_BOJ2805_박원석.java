package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Day3_BOJ2805_박원석 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		// 입력
		int N = Integer.parseInt(st.nextToken()); // 나무의 수
		int M = Integer.parseInt(st.nextToken()); // 필요한 나무 길이
		long[] tree = new long[N]; // N개의 나무 높이
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++) tree[i] = Long.parseLong(st.nextToken());
		
		// 파라메트릭 서치를 위해 오름차순 정렬
		Arrays.sort(tree);
		
		// 파라메트릭 서치 (주어진 범위 내에서 원하는 조건에 가장 일치하는 값을 찾아내는 알고리즘)
		long left = 0, right = tree[N - 1], answer = Integer.MIN_VALUE;
		while(left <= right) {
			long mid = (left + right) / 2;
			long sum = 0;
			
			// mid 높이로 잘랐을 때, 가져갈 수 있는 나무 길이
			for(int i = 0; i < N; i++) {
				if(tree[i] > mid) {
					sum += (tree[i] - mid);
				}
			}
			
			// 딱 원하는 길이를 가져올 수 있다면, 이 때의 높이가 최대
			if(sum == M) {
				answer = mid;
				break;
			}
			
			if(sum < M) { // 부족하다면 더 낮은 높이로 시도
				right = mid - 1;
			} else { // 남는다면 더 높은 높이로 시도 (이 부분의 값들은 모두 정답 후보)
				left = mid + 1;
				answer = Math.max(answer, mid); // 정답 후보들 중 최대값 뽑아내기
			}
		}
		
		System.out.println(answer);
	}
}
