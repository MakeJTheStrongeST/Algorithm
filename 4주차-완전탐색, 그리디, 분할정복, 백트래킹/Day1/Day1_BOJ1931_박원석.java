package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Day1_BOJ1931_¹Ú¿ø¼® {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(in.readLine());
		PriorityQueue<Meeting> pq = new PriorityQueue<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			pq.offer(new Meeting(start, end));
		}
		
		int end = pq.poll().end;
		int answer = 1;
		while(!pq.isEmpty()) {
			Meeting m = pq.poll();
			if(m.start >= end) {
				end = m.end;
				answer++;
			}
		}
		
		System.out.println(answer);
	}
	
	static class Meeting implements Comparable<Meeting> {
		int start, end;
		Meeting(int start, int end){
			this.start = start;
			this.end = end;
		}
		@Override
		public int compareTo(Meeting o) {
			if(this.end == o.end)
				return this.start -o.start;
			return this.end - o.end;
		}
	}
}
