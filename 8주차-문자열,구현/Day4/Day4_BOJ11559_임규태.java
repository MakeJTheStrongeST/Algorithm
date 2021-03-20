import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;

	static char[][] map = new char[12][];
	static boolean[][] chk1 = new boolean[12][6],chk2 = new boolean[12][6];
	static int[] dy = {1,-1,0,0}, dx = {0,0,1,-1};
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0;i<12;i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		int ans = 0;
		while(play()) {
			ans++;
			move();
			reset();
		};
		System.out.println(ans);
	}
	
	static void move() {
		for(int j=0;j<6;j++) {
			int idx = 11;
			for(int i=11;i>=0;i--) {
				if(map[i][j] != '.') {
					char tmp = map[i][j];
					map[i][j] = '.';
					map[idx--][j] = tmp;
				}
			}
		}
	}
	
	static void reset() {
		for(int i=0;i<12;i++) for(int j=0;j<6;j++) {
			chk1[i][j] = false;
			chk2[i][j] = false;
		}
	}
	
	static boolean play() {
		boolean ret = false;
		
		for(int i=0;i<12;i++) {
			for(int j=0;j<6;j++) {
				if(map[i][j] != '.' && chk1[i][j] == false) {
					chk1[i][j] = true;
					if(chain(i,j) < 4) continue;
					ret = true;
					chk2[i][j] = true;
					boom(i,j);
				}
			}
		}
		
		return ret;
	}
	
	static void boom(int y,int x) {
		for(int i=0;i<4;i++) {
			int nxty = y+dy[i];
			int nxtx = x+dx[i];
			if(isValid(nxty,nxtx) && !chk2[nxty][nxtx] && map[nxty][nxtx] == map[y][x]) {
				chk2[nxty][nxtx] = true;
				boom(nxty,nxtx);
			}
		}
		map[y][x] = '.';
	}
	
	static boolean isValid(int y,int x) {
		return y>=0 && y<12 && x>=0 && x<6;
	}
	
	static int chain(int y,int x) {
		int ret = 1;
		for(int i=0;i<4;i++) {
			int nxty = y+dy[i];
			int nxtx = x+dx[i];
			if (isValid(nxty,nxtx) && !chk1[nxty][nxtx] && map[nxty][nxtx] == map[y][x]) {
				chk1[nxty][nxtx] = true;
				ret += chain(nxty,nxtx);
			}
		}
		return ret;
	}
}
