import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;

	static int[][] map;
	static int[] dy = {1,-1,0,0}, dx = {0,0,1,-1};
	static int n,m;
	static boolean[][] chk;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		chk = new boolean[n][m];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int time = 0;
		while(simulation(0,0)) {
			delete();
			time++;
			chk = new boolean[n][m];
		}
		System.out.println(time);
	}
	
	static void delete() {
		for(int i=0;i<n;i++) for(int j=0;j<m;j++) {
			if(map[i][j] != 0) {
				if(map[i][j] >= 3) map[i][j] = 0;
				else map[i][j] = 1;
			}
		}
	}
	
	static boolean isValid(int y,int x) {
		return y>=0 && y<n && x>=0 && x<m;
	}
	
	static boolean simulation(int cy,int cx) {
		chk[cy][cx] = true;
		boolean ret = false;
		for(int i=0;i<4;i++) {
			int ny = cy+dy[i];
			int nx = cx+dx[i];
			if(isValid(ny,nx) && !chk[ny][nx]) {
				if(map[ny][nx] == 0) {
					if(simulation(ny,nx)) ret = true;
				}
				else {
					map[ny][nx]++;
					ret = true;
				}
			}
		}
		
		return ret;
	}
}
