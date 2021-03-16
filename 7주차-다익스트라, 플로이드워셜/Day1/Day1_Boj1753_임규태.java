import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(br.readLine());
		
		List<p>[] path = new List[v+1];
		int[] dist = new int[v+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		for(int i=1;i<=v;i++) path[i] = new ArrayList();
		
		for(int i=0;i<e;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			path[a].add(new p(b,w));
		}
		
		PriorityQueue<p> pq = new PriorityQueue();
		pq.add(new p(s,0));
		while(!pq.isEmpty()) {
			p curp = pq.poll();
			int curnum = curp.num;
			int curdist = curp.w;
			if(dist[curnum] < curdist) continue;
			dist[curnum] = curdist;
			
			for(p nxt : path[curnum]) {
				int nxtnum = nxt.num;
				int nxtdist = nxt.w;
				if(dist[nxtnum] > curdist+nxtdist) {
					dist[nxtnum] = curdist+nxtdist;
					pq.add(new p(nxtnum,dist[nxtnum]));
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=v;i++) {
			sb.append(dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]).append("\n");
		}
		System.out.println(sb);
	}
	
	static class p implements Comparable<p>{
		int num,w;
		public p(int num, int w) {
			this.num = num;
			this.w = w;
		}
		
		@Override
		public int compareTo(p o) {
			return this.w - o.w;
		}
		
	}
}
