import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Day1_Boj1753_최지혜 {

	static Long[] dist;
	static boolean[] isVisited;
	static ArrayList<ArrayList<int[]>> adj;
	static final long INF = Long.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		
		adj = new ArrayList<>();
		for(int i = 0; i <= V; i++) adj.add(new ArrayList<>());
		isVisited = new boolean[V+1];
		dist = new Long[V+1];
		Arrays.fill(dist, INF);
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine()," ");
			adj.get(Integer.parseInt(st.nextToken()))
				.add(new int[] {Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken())});
		} 
		dijk(K);
		
		for (int i = 1; i <= V; i++) {
			System.out.println(dist[i]==INF ? "INF" : dist[i]);
		}
	}
	
	private static void dijk(int start) {
		
		PriorityQueue<long[]> pq = new PriorityQueue<>((o1,o2)->(int)(o1[0]-o2[0]));
		dist[start]=0L;
		pq.offer(new long[] {0,start});
		
		while(!pq.isEmpty()) {
			int num = (int)pq.poll()[1];
			isVisited[num] = true;
			Iterator<int[]> it = adj.get(num).iterator();
			
			while(it.hasNext()) {
				int[] ew = it.next();
				if(!isVisited[ew[0]] && dist[ew[0]] > dist[num]+ew[1]) {
					dist[ew[0]] = dist[num]+ew[1];
					pq.offer(new long[] {dist[ew[0]],ew[0]});
				}
			}		
		}	
	}

}
