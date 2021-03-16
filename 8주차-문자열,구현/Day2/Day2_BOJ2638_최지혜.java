import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;
import java.util.StringTokenizer;

public class Day2_BOJ2638__최지혜 {
	static int[][] map;
	static int N,M,cheese;
	static ArrayList<int[]> list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==1) cheese++;
			}
		}

		int ans=0;	
		while(cheese>0) { //외부와 2변 이상 접한 치즈 제거하며 ans+1

			ans++;
			bfs(new int[] {0,0});//치즈 외부와 내부 구분하기 (모눈종이 맨 가장자리에는 치즈가 놓이지 않는다고 가정하는 조건 있음) : bfs로 4방 탐색하면서 -1로 채움

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j] == 1) check(new int[] {i,j}); 
				}
			}
			melt();
		}
		System.out.println(ans);
		
	}
	private static void melt() {
		
		Iterator<int[]> it = list.iterator();
		while(it.hasNext()) {
			int[] curr = it.next();
			map[curr[0]][curr[1]] = 8;
			cheese--;
		}
		list.clear();
	}
	private static void check(int[] curr) {
		
		int cnt=0;
		int[] dr = {-1,1,0,0};
		int[] dc = {0,0,-1,1};
		
		for(int d=0;d<4;d++) {
			int nr = curr[0] + dr[d];
			int nc = curr[1] + dc[d];
			if(map[nr][nc] == 8) cnt++;
			
		}
		
		if(cnt>=2) list.add(new int[] {curr[0],curr[1]});
		
		
	}
	private static void bfs(int[] start) {
		Queue<int[]> q = new ArrayDeque<>();
		boolean[][] isVisited = new boolean[N][M];
 		q.offer(start);
		isVisited[start[0]][start[1]] = true;
			
		int[] dr = {-1,1,0,0};
		int[] dc = {0,0,-1,1};
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			map[curr[0]][curr[1]] = 8;
			for(int d=0;d<4;d++) {
				int nr = curr[0] + dr[d];
				int nc = curr[1] + dc[d];
				if(nr>=0 && nr<N && nc>=0 && nc<M && !isVisited[nr][nc] && map[nr][nc] != 1) {
					q.offer(new int[] {nr,nc});
					isVisited[nr][nc] = true;
				}
			}
		}
	}

}
