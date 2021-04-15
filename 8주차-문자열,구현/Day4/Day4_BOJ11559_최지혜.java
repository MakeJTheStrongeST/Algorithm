import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class Day4_BOJ11559_최지혜 {

	static char[][] map = new char[12][];
	static boolean[][] isVisited = new boolean[12][6];
	static int cnt;//연쇄횟수
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0; i<12; i++) map[i] = br.readLine().toCharArray();
		
		ArrayList<int[]> checklist = new ArrayList<>();
		while(true) {

			for(int i=0;i<12;i++) Arrays.fill(isVisited[i], false);
			checklist.clear();
			for(int i=0;i<12;i++) {
				for(int j=0; j<6;j++) {
					if(map[i][j]!='.') {
						checklist.add(new int[] {i,j});
					}
				}
			}
			for(int[] pos : checklist) {

				if(!isVisited[pos[0]][pos[1]]) checkIfRemovable(pos[0],pos[1]);
			}
			if(!isRemoved()) break; //뿌요가 남아있지 않으면 종료.
			cnt++;
		}
		
		System.out.println(cnt); // 연쇄횟수 출력
	}

	

	private static void checkIfRemovable(int r, int c) {

		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {r,c});
		isVisited[r][c] = true;
		int[] dr = {-1,1,0,0};
		int[] dc = {0,0,-1,1};
		int len=0;
		ArrayList<int[]> list = new ArrayList<>();
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			list.add(new int[] {curr[0],curr[1]});
			len++;
			for(int d=0;d<4;d++) {
				
				int nr = curr[0]+dr[d];
				int nc = curr[1]+dc[d];
				if(nr>=0 && nr<12 && nc>=0 && nc<6 && !isVisited[nr][nc] && map[nr][nc]==map[curr[0]][curr[1]]) {
					q.offer(new int[] {nr,nc});
					isVisited[nr][nc] = true;
					
				}
			}
		}
	
		if(len>=4) remove(list);
	
	}

	private static void remove(ArrayList<int[]> list) {
		for(int[] pos : list) map[pos[0]][pos[1]] = 'X';
		//print();
	}
	
	private static boolean isRemoved() {//X 개수 찾기

		boolean flag=false;
		for(int i=0;i<12;i++) {
			for(int j=0; j<6;j++) {
				if(map[i][j]=='X') {
					flag=true;
				}
			}
		}
		if(flag) down();

		return flag;

	}

	private static void down() {
		while(true) {
			boolean flag = false;
			for (int c = 0; c < 6; c++) {
				for (int r = 11; r > 0; r--) {
					if(map[r][c] == 'X' && map[r-1][c] != 'X') {
						map[r][c] = map[r-1][c];
						map[r-1][c] = 'X';
						flag = true;
					}
				}
				
			}
			if(!flag) break;
		}
		//print();
		for (int c = 0; c < 6; c++) {
			for (int r = 11; r >= 0; r--) {
				if(map[r][c] == 'X') {
					map[r][c] = '.';
				}
			}
		}
		//print();

	}
	

	private static void print() {

		for(int i=0;i<12;i++) {
			for(int j=0; j<6;j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		
	}
	
}
