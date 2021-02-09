package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Day2_15900_나무탈출_박원석 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
	static int N, a, b, totalCnt;
	static boolean[] ch;

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(in.readLine()); // 정점 개수
		for (int i = 0; i <= N; i++)
			tree.add(new ArrayList<Integer>()); // 리스트 안에 N + 1개의 비어 있는 리스트를 저장한다.
							    // 인접리스트로 트리 구현
		ch = new boolean[N + 1]; // 부모 노드로 가는 것을 방지하기 위해 방문 체크 (양방향으로 간선을 연결해서...)

		// 노드 연결
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			// 양방향 연결
			tree.get(b).add(a);
			tree.get(a).add(b);
		}

		ch[1] = true; // 루트 1부터 시작하므로 방문 체크
		DFS(1, 0);
		
		// 리프노드들의 높이 합이 홀수여야 성원이가 이길 수 있음
		// 리프노드에서 루트까지 일직선으로 간다고 생각하면 됨
		if (totalCnt % 2 != 0)
			System.out.println("Yes");
		else
			System.out.println("No");
	}

	static void DFS(int v, int cnt) {
		// 리프노드인 경우 높이를 카운팅하고 재귀를 종료한다.
		// 리프노드는 부모노드만 있는 경우이다.
		if (tree.get(v).size() == 1 && ch[tree.get(v).get(0)]) {
			totalCnt += cnt;
			return;
		}

		// 깊이 우선 탐색
		for (int i = 0; i < tree.get(v).size(); i++) {
			if (!ch[tree.get(v).get(i)]) { // 방문하지 않은 노드만 탐색(=자식 노드로만 탐색)
				ch[tree.get(v).get(i)] = true; // 다음 노드에서 부모 노드로 가지 않기 위한 방문 체크
				DFS(tree.get(v).get(i), cnt + 1); // 다음 노드로 탐색해 나간다.
				ch[tree.get(v).get(i)] = false; // 다음 자식노드를 탐색해나가기 위해 방문 체크 해제
			}
		}
	}
}
