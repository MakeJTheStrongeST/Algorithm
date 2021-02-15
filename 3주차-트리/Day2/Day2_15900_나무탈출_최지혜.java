/*트리순회*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_15900 {
	static String YesOrNo = "";
	static int N, cnt;
	static int[][] edges;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String str;
		edges = new int[N+1][N+1];
		for(int n=0;n<N-1;n++) {
			str = br.readLine();
			int i = str.charAt(0)-'0';
			int j = str.charAt(2)-'0';
			edges[i][j] = 1;
			edges[j][i] = 1;
		}
		for(int i=1;i<=N;i++) {
			int sum=0;
			for(int j=1;j<=N;j++) {
				sum += edges[i][j];
			}
			if(sum == 1) escape(i);
		}
		
		if(cnt%2 == 1) System.out.println("Yes");
		else System.out.println("No");
		
	}
	private static void escape(int current) {
//		System.out.println(current);
		if(current==1) return;
		cnt++;
		for(int i=1;i<=N;i++) {
			if(edges[current][i]!=0) {
				escape(i);
				break;
			}
		}	
	}
}
