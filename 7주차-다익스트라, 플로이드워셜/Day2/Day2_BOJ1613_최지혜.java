import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day2_Boj1613_최지혜 {

	static int N,K;
	static int[][] dist;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken()); // 사건의 개수
		K = Integer.parseInt(st.nextToken()); // 전후관계의 개수
		dist = new int[N+1][N+1];
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine()," ");
			dist[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
		}
		
		//floyd
		for(int k = 1; k <= N; k++) {
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {
					if(i == j) dist[i][j] = 0;
					else if(dist[i][k] == 1 && dist[k][j] == 1) dist[i][j]=1; 
				}
			}
		}
		
		int S = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int j = 0; j < S; j++) {
			
			st = new StringTokenizer(br.readLine()," ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			if(dist[u][v]==1) sb.append(-1).append("\n");
			else if(dist[v][u]==1) sb.append(1).append("\n");
			else sb.append(0).append("\n");
		
		}
		System.out.println(sb.toString());
	}

}
