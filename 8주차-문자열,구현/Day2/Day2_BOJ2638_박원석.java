import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	static int[][] map;
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		// 입력
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		BFS(0, 0); // 외부 공기를 2로 변경
		
		int answer = 0;
		while(true) {
			// 녹는 치즈 위치 저장
			boolean flag = true; // 녹는 치즈 있는지 없는지
			ArrayList<int[]> meltList = new ArrayList<>();
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(map[i][j] == 1 && meltCheck(j, i)) {
						meltList.add(new int[] {i, j});
						flag = false;
					}
				}
			}
			
			if(flag) break; // 녹는 치즈 더이상 없으면 종료
			
			// 저장해둔 치즈 위치 녹이기
			for(int i = 0; i < meltList.size(); i++) {
				int r = meltList.get(i)[0];
				int c = meltList.get(i)[1];
				map[r][c] = 2;
				BFS(r, c); // 외부 공기 갱신
			}
			
			answer++;
		}
		
		System.out.println(answer);
	}

	private static void BFS(int r, int c) {
		Deque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {c, r});
		map[r][c] = 2;
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			int x = tmp[0];
			int y = tmp[1];
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
				if(map[ny][nx] == 0) {
					map[ny][nx] = 2;
					q.offer(new int[] {nx, ny});
				}
			}
		}
	}
	
	private static boolean meltCheck(int x, int y) {
		int cnt = 0;
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
			if(map[ny][nx] == 2) cnt++;
		}
		if(cnt >= 2) return true;
		else return false;
	}
}
