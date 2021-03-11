import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Day4_Boj1504_최지혜 {
	
	static ArrayList<ArrayList<int[]>> adj;
	static long[] dist;
	static boolean[] isVisited;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		if(E==0) {
			System.out.println(-1);
			return;
		}
		
		dist = new long[N+1];
		isVisited = new boolean[N+1];
		adj = new ArrayList<>();
		for(int i=0; i<=N;i++) adj.add(new ArrayList<>());
		
		for(int i=0; i<E;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			adj.get(u).add(new int[] {v,c});
			adj.get(v).add(new int[] {u,c});
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		
		long len1 = dijk(1,v1) + dijk(v1,v2) + dijk(v2,N); // 1>v1>v2>N
		long len2 = dijk(1,v2) + dijk(v2,v1) + dijk(v1,N); // 1>v2>v1>N

		if(len1==-1 && len2==-1) System.out.println(-1);
		else if(len1==-1)	System.out.println(len2);
		else if(len2==-1)	System.out.println(len1);
		else System.out.println(Math.min(len1, len2));
	}
	
	private static long dijk(int start, int end) {
		Arrays.fill(dist, Long.MAX_VALUE);
		dist[start] = 0L;
		PriorityQueue<long[]> pq = new PriorityQueue<>((o1,o2)->(int)(o1[0]-o2[0]));
		pq.offer(new long[] {0L, start});
			
		while(!pq.isEmpty()) {
			
			long[] curr = pq.poll();
			Iterator<int[]> it = adj.get((int)curr[1]).iterator();
			while(it.hasNext()) {
				int[] next = it.next();
				if(!isVisited[next[0]] && dist[(int)next[0]] > dist[(int)curr[1]]+next[1]) {
					dist[next[0]] = dist[(int)curr[1]]+next[1];
					pq.offer(new long[] {dist[next[0]],next[0]});
				}
			}
		}
		return dist[end]==Long.MAX_VALUE? -1 : dist[end];
	}

}
