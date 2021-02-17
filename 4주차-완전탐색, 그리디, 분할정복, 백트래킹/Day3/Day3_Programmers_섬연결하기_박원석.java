package week4;

import java.util.Arrays;

public class Day3_Programmers_섬연결하기_박원석 {
	static int n = 4;
	static int[][] costs = { { 0, 1, 1 }, { 0, 2, 2 }, { 1, 2, 5 }, { 1, 3, 1 }, { 2, 3, 8 } };
	static int[] unf = new int[100];
	
	public static void main(String[] args) {
		int answer = 0;

		Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);
		
		for(int i = 0; i < n; i++) unf[i] = i;
		
		for(int i = 0, len = costs.length; i < len; i++) {
			int fa = find(costs[i][0]);
			int fb = find(costs[i][1]);
			
			if(fa != fb) {
				answer += costs[i][2];
				union(costs[i][0], costs[i][1]);
			}
		}
		
		System.out.println(answer);
	}

	static int find(int v) {
		if(v == unf[v]) return v;
		else return unf[v] = find(unf[v]);
	}
	
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a != b) unf[b] = a;
	}
}
