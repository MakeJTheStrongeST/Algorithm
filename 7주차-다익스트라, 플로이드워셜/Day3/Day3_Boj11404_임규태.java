import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;

	static int INF = (int)1e9;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		int[][] dist = new int[101][101];
		for(int i=1;i<=n;i++) for(int j=1;j<=n;j++) {
			dist[i][j] = i == j ? 0 : INF;
		}
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			dist[a][b] = Math.min(dist[a][b], c);
		}
		
		for(int k=1;k<=n;k++) for(int i=1;i<=n;i++) for(int j=1;j<=n;j++) {
			dist[i][j] = Math.min(dist[i][j], dist[i][k]+dist[k][j]);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				sb.append(dist[i][j] == INF ? 0 : dist[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
		
	}
}
