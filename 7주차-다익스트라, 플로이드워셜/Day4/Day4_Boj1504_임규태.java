import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;

	static int INF = (int)1e8;
	static int[][] dist;
	static List<p>[] path;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int n,e;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		
		dist = new int[n+1][];
		path = new List[n+1];
		for(int i=1;i<=n;i++) path[i] = new ArrayList<>();
		for(int i=0;i<e;i++) {
			int a,b,c;
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			path[a].add(new p(b,c));
			path[b].add(new p(a,c));
		}
		
		int v1,v2;
		st = new StringTokenizer(br.readLine());
		v1 = Integer.parseInt(st.nextToken());
		v2 = Integer.parseInt(st.nextToken());
		
		dist[1] = new int[n+1]; dist[v1] = new int[n+1]; dist[v2] = new int[n+1];
		Arrays.fill(dist[v1], INF); Arrays.fill(dist[v2],INF); Arrays.fill(dist[1],INF);
		
		dijk(1);dijk(v1);dijk(v2);
		int ans1 = dist[1][v1] + dist[v1][v2] + dist[v2][n];
		int ans2 = dist[1][v2] + dist[v2][v1] + dist[v1][n];
		if(ans1 < INF || ans2 < INF) System.out.println(Math.min(ans1, ans2));
		else System.out.println(-1);
	}
	
	static void dijk(int start) {
		PriorityQueue<p> pq = new PriorityQueue<>((e1,e2) -> e1.cost - e2.cost);
		pq.add(new p(start,0));
		dist[start][start] = 0;
		while(!pq.isEmpty()) {
			p cur = pq.poll();
			if(cur.cost > dist[start][cur.num]) continue;
			for(p nxt : path[cur.num]) {
				if(dist[start][nxt.num] > dist[start][cur.num]+nxt.cost) {
					dist[start][nxt.num] = dist[start][cur.num]+nxt.cost;
					pq.add(new p(nxt.num,dist[start][nxt.num]));
				}
			}
		}
	}
	
	static class p{
		int num,cost;
		public p(int num,int cost) {
			this.num = num;
			this.cost = cost;
		}
	}
}
