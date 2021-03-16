import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;

	static int LIMIT = (int)1e6;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		int n,m;
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		int[][] dist = new int[n+1][n+1];
		for(int i=1;i<=n;i++) {
			Arrays.fill(dist[i], LIMIT);
		}
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int a,b;
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			dist[a][b] = 1;
		}
		for(int k=1;k<=n;k++) for(int i=1;i<=n;i++) for(int j=1;j<=n;j++) {
			dist[i][j] = Math.min(dist[i][j], dist[i][k]+dist[k][j]);
		}
		
		int s = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<s;i++) {
			st = new StringTokenizer(br.readLine());
			int a,b;
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			if(dist[a][b] < LIMIT) sb.append(-1);
			else if(dist[b][a] < LIMIT) sb.append(1);
			else sb.append(0);
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
}
