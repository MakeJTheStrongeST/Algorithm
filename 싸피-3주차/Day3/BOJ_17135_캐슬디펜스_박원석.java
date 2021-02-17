package week3.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_17135_ĳ�����潺_�ڿ��� {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M, D, answer = Integer.MIN_VALUE;
	static int[][] map;
	static int[] dx = {-1, 0, 1};
	static int[] dy = {0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] P = new int[M];
		for(int i = 0; i < 3; i++) P[M - 1 - i] = 1;
		
		do {
			// �ü� ����
			int cnt = 0;
			int[] archer = new int[3]; 
			for(int i = 0; i < M; i++) {
				if(P[i] == 1) {
					archer[cnt++] = i;
				}
			}
			
			// map ����
			int[][] copyMap = new int[N][M]; 
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					copyMap[i][j] = map[i][j];
				}
			}
			
			// N�� ��ŭ �� �̵�
			int attackCnt = 0; // ������ �� ��
			for(int i = 0; i < N; i++) {
				// ���ÿ� ���̱� ���� �����ϴ� �� �����س�����
				ArrayList<int[]> killEnemy = new ArrayList<>();
				
				// 3���� �ü��� �����Ÿ��� �ִ� ���� ����� �� ����
				for(int j = 0; j < 3; j++) {
					// BFS�� Ÿ����
					Deque<int[]> q = new ArrayDeque<>();
					q.offer(new int[] {archer[j], N, 0});
					
					Loop:while(!q.isEmpty()) {
						int[] tmp = q.poll();
						int x = tmp[0];
						int y = tmp[1];
						int dis = tmp[2];
						
						for(int k = 0; k < 3; k++) {
							int nx = x + dx[k];
							int ny = y + dy[k];
							int nextDis = dis + 1;
							
							if(nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
							
							if(nextDis <= D) {
								if(copyMap[ny][nx] == 1) {
									killEnemy.add(new int[] {nx, ny});
									break Loop;
								} else {
									q.offer(new int[] {nx, ny, nextDis});
								}
							}
						}
					}
				}
				
				// ���ÿ� �� ����
				for(int j = 0, len = killEnemy.size(); j < len; j++) {
					int[] pos = killEnemy.get(j);
					if(copyMap[pos[1]][pos[0]] == 1) {
						copyMap[pos[1]][pos[0]] = 0;
						attackCnt++;
					}
				}
				
				// �� �Ʒ��� 1ĭ �̵�
				for(int j = N - 1; j > 0; j--) {
					for(int k = 0; k < M; k++) {
						copyMap[j][k] = copyMap[j - 1][k];
					}
				}
				for(int j = 0; j < M; j++)
					copyMap[0][j] = 0;
			}
			
			answer = Math.max(answer, attackCnt);
		} while(nextPerm(P));
		
		System.out.println(answer);
	}
	
	private static boolean nextPerm(int[] arr) {
		int i = M - 1;
		while(i > 0 && arr[i - 1] >= arr[i]) --i;
		
		if(i == 0) return false;
		
		int j = M - 1;
		while(arr[i - 1] >= arr[j]) --j;
		
		swap(arr, i - 1, j);
		
		int k = M - 1;
		while(i < k)
			swap(arr, i++, k--);
		return true;
	}
	
	private static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
