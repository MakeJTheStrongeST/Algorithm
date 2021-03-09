package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Day1_BOJ1753_박원석 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(in.readLine());

		// 인접리스트
		ArrayList<ArrayList<Edge>> edges = new ArrayList<>();
		for (int i = 0; i <= V; i++) {
			edges.add(new ArrayList<Edge>());
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(in.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			edges.get(from).add(new Edge(to, weight));
		}

		// 다익스트라
		int[] dis = new int[V + 1];
		for (int i = 0; i <= V; i++)
			dis[i] = Integer.MAX_VALUE;

		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(K, 0));
		dis[K] = 0;

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

		// 결과 출력
		for (int i = 1; i <= V; i++) {
			if (dis[i] == Integer.MAX_VALUE)
				System.out.println("INF");
			else
				System.out.println(dis[i]);
		}
	}

	static class Edge implements Comparable<Edge>{
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
