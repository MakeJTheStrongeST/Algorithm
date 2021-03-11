package floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_11404_플로이드_최지혜 {
	
	final static int INF = 1000000000;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 도시의 개수
		int M = Integer.parseInt(br.readLine()); // 버스의 개수
		
		int[][] dist = new int[N+1][N+1]; //배열 크기 +1 크게 줌 
		for(int i = 0; i <= N; i++) Arrays.fill(dist[i], INF); //최단거리 갱신하기 위해 초기값 Long.MAX_VALUE로 설정	
		
		StringTokenizer st;
		//간선 정보 입력
		for (int i = 0; i < M; i++) {
			
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			dist[a][b] = Math.min(dist[a][b], c);
		}
		//플로이드-와샬
		for(int k = 1; k <= N ; k++) { 
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) { 
					// i에서 j까지 (1) 1 ~ k-1번 정점을 (각각) 거쳐서 가는 경우 계산된 최단거리 dist[i][j]와 
					// 		   (2) k번 정점을 거쳐서 가는 거리를 비교
					if(i!=j) dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
					
				}
			}
		}
		//결과 출력
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				System.out.print(dist[i][j]==INF ? 0 +" " : dist[i][j] +" ");
			}
			System.out.println();
		}
	}

}
