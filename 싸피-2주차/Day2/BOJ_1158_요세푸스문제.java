package week2.day2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1158_요세푸스문제 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] res = new int[N];
		
		Queue<Integer> queue = new LinkedList<>();
		for(int i=1; i<=N; i++)
			queue.offer(i);
		
		int cnt = 1, idx = 0;
		while(!queue.isEmpty()) {
			if(cnt == K) {
				cnt = 0;
				res[idx++] = queue.poll();
			} else {
				queue.offer(queue.poll());
			}
			cnt++;
		}
		
		StringBuilder sb = new StringBuilder("<");
		for(int i=0; i<N; i++) {
			sb.append(res[i]);
			if(i == N - 1) break;
			sb.append(", ");
		}
		sb.append(">");
		System.out.println(sb.toString());
	}
}
