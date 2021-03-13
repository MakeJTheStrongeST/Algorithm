package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Day4_BOJ1504_박원석 {
	static int N;
	static ArrayList<ArrayList<Edge>> edges;
	static int[] dis;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		// 인접리스트
		edges = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			edges.add(new ArrayList<Edge>());
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			edges.get(a).add(new Edge(b, c));
			edges.get(b).add(new Edge(a, c));
		}
		
		st = new StringTokenizer(in.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());

		// 1 -> v1 -> v2 -> N
		// 1 -> v2 -> v1 -> N 의 2가지 경로 중 최소
		int path1 = 0, path2 = 0;
		
		dijkstra(1);
		path1 = dis[v1];
		path2 = dis[v2];
		
		dijkstra(v1);
		if(path1 != Integer.MAX_VALUE && dis[v2] != Integer.MAX_VALUE) path1 += dis[v2];
		else path1 = Integer.MAX_VALUE;
		if(path2 != Integer.MAX_VALUE && dis[N] != Integer.MAX_VALUE) path2 += dis[N];
		else path2 = Integer.MAX_VALUE;
		
		dijkstra(v2);
		if(path1 != Integer.MAX_VALUE && dis[N] != Integer.MAX_VALUE) path1 += dis[N];
		else path1 = Integer.MAX_VALUE;
		if(path2 != Integer.MAX_VALUE && dis[v1] != Integer.MAX_VALUE) path2 += dis[v1];
		else path2 = Integer.MAX_VALUE;

		// 결과 출력
		if(path1 == Integer.MAX_VALUE && path2 == Integer.MAX_VALUE) System.out.println("-1");
		else if(path1 <= path2) System.out.println(path1);
		else System.out.println(path2);
	}
	
	static void dijkstra(int start) {
		dis = new int[N + 1];
		for (int i = 0; i <= N; i++)
			dis[i] = Integer.MAX_VALUE;

		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(start, 0));
		dis[start] = 0;
		
		while (!pq.isEmpty()) {
			Edge cur = pq.poll();
			int curPos = cur.v;
			int curCost = cur.w;

			if (curCost > dis[curPos])
				continue;

			for (int i = 0; i < edges.get(curPos).size(); i++) {
				int nextPos = edges.get(curPos).get(i).v;
				int nextCost = curCost + edges.get(curPos).get(i).w;

				if (dis[nextPos] > nextCost) {
					dis[nextPos] = nextCost;
					pq.add(new Edge(nextPos, nextCost));
				}
			}
		}
	}

	static class Edge implements Comparable<Edge> {
		int v, w;

		Edge(int v, int w) {
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			return this.w - o.w;
		}
	}
}
