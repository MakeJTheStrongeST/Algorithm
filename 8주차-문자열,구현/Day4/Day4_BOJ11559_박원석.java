import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Day4_BOJ11559_박원석 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static char[][] map = new char[12][6];
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	static int answer;
	
	public static void main(String[] args) throws IOException {	
		for(int i = 0; i < 12; i++) {
			String row = in. readLine();
			for(int j = 0; j < 6; j++) {
				map[i][j] = row.charAt(j);
			}
		}
		
		while(true) {
			boolean flag = false;
			for(int i = 11; i >= 0; i--) {
				for(int j = 0; j < 6; j++) {
					if(map[i][j] != '.' && checkBFS(i, j, map[i][j])) {
						flag = true;
						bombBFS(i, j, map[i][j]);
					}
				}
			}
			if(!flag) break;
			drop();
			answer++;
		}
		
		System.out.println(answer);
	}
	
	private static boolean checkBFS(int r, int c, char puyo) {
		Deque<int[]> q = new ArrayDeque<>();
		boolean[][] visited = new boolean[12][6];
		int cnt = 1;
		q.offer(new int[] {c, r});
		visited[r][c] = true;
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			int x = tmp[0];
			int y = tmp[1];
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx < 0 || ny < 0 || nx >= 6 || ny >= 12) continue;
				if(map[ny][nx] == puyo && !visited[ny][nx]) {
					visited[ny][nx] = true;
					q.offer(new int[] {nx, ny});
					cnt++;
				}
			}
		}
		if(cnt >= 4) return true;
		else return false;
	}
	
	private static void bombBFS(int r, int c, char puyo) {
		Deque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {c, r});
		map[r][c] = '.';
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			int x = tmp[0];
			int y = tmp[1];
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx < 0 || ny < 0 || nx >= 6 || ny >= 12) continue;
				if(map[ny][nx] == puyo) {
					map[ny][nx] = '.';
					q.offer(new int[] {nx, ny});
				}
			}
		}
	}
	
	private static void drop() {
		for(int j = 0; j < 6; j++) {
			while (true) {
				boolean flag = false;
				for (int i = 11; i >= 1; i--) {
					if (map[i][j] == '.' && map[i - 1][j] != '.') {
						map[i][j] = map[i - 1][j];
						map[i - 1][j] = '.';
						flag = true;
					}
				}
				if (!flag) break; 
			}
		}
	}
}
