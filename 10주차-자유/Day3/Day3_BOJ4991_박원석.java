package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Day3_BOJ4991_박원석 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int w, h, minDis[][], nodeListLen, result[], answer;
	static char[][] map;
	static ArrayList<int[]> nodeList;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	
	public static void main(String[] args) throws IOException {
		Loop:while(true) {
			st = new StringTokenizer(in.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			if(w == 0 && h == 0) break;
			
			// 위치 정보 초기화
			map = new char[h][w]; // 방의 정보
			nodeList = new ArrayList<>(); // 0: 로봇 위치, 1~:더러운칸 위치 
			nodeList.add(new int[] {0, 0}); // 로봇 위치 저장을 위한 더미 데이터
			for(int i = 0; i < h; i++) {
				String row = in.readLine();
				for(int j = 0; j < w; j++) {
					map[i][j] = row.charAt(j);
					if(map[i][j] == 'o') {
						nodeList.set(0, new int[] {i, j});
					} else if(map[i][j] == '*') {
						nodeList.add(new int[] {i, j});
					}
				}
			}
			nodeListLen = nodeList.size(); // 노드 개수
			
			// 각 노드 간의 최소 거리
			minDis = new int[nodeListLen][nodeListLen];
			int[][] copyMap = new int[h][w];
			
			for(int i = 0; i < h; i++) {
				for(int j = 0; j < w; j++) {
					if(map[i][j] == 'x') copyMap[i][j] = 'x';
					else copyMap[i][j] = '.';
				}
			}
			
			for(int i = 0; i < nodeListLen; i++) {
				int[] node = nodeList.get(i);
				int[][] dis = new int[h][w];
				for(int j = 0; j < h; j++) {
					for(int k = 0; k < w; k++) {
						dis[j][k] = -1;
					}
				}
				
				ArrayDeque<int[]> q = new ArrayDeque<>();
				q.offer(new int[] {node[1], node[0]});
				dis[node[0]][node[1]] = 0;
				int dirtCnt = 0;
				
				while(!q.isEmpty()) {
					int[] cur = q.poll();
					int x = cur[0];
					int y = cur[1];
					int d = dis[y][x];
					
					for(int j = 0; j < 4; j++) {
						int nx = x + dx[j];
						int ny = y + dy[j];
						
						if(nx < 0 || ny < 0 || nx >= w || ny >= h) continue;
						
						if(copyMap[ny][nx] == '.' && dis[ny][nx] == -1) {
							dis[ny][nx] = d + 1;
							q.offer(new int[] {nx, ny});
							if(map[ny][nx] == '*') {
								if(i == 0) dirtCnt++;
								int idx = 0;
								for(int k = 1; k < nodeListLen; k++) {
									if(nodeList.get(k)[0] == ny && nodeList.get(k)[1] == nx) {
										idx = k;
										break;
									}
								}
								minDis[i][idx] = d + 1;
							}
						}
					}
				}
				
				// 이동 불가능한 더러운칸이 존재하는 경우
				if(i == 0 && dirtCnt < nodeListLen - 1) {
					System.out.println("-1");
					continue Loop;
				}
			}
			
			// 순열을 통해서 최소 비용 경로 찾기
			answer = Integer.MAX_VALUE;
			result = new int[nodeListLen - 1];
			permutation(0, 0);
			
			System.out.println(answer);
		}
	}

	private static void permutation(int cnt, int flag) {
		if(cnt == nodeListLen - 1) {
			int sum = minDis[0][result[0]];
			for(int i = 0; i < nodeListLen - 2; i++) {
				sum += minDis[result[i]][result[i + 1]];
			}
			answer = Math.min(answer, sum);
			return;
		}
		
		for(int i = 1; i < nodeListLen; i++) {
			if((flag & 1 << i) == 0) {
				result[cnt] = i;
				permutation(cnt + 1, flag | 1 << i);
			}
		}
	}
}
