/*종이의 개수 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1780 {
	static int N;
	static int[][] map;
	static int[] cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		cnt = new int[3]; //0인덱스:-1개수, 1인덱스:0개수, 2인덱스: 1개수
		divide(N,0,0);
	
		//출력
		System.out.println(cnt[0]);
		System.out.println(cnt[1]);
		System.out.println(cnt[2]);
	}
	private static void divide(int n,int r, int c) {
//		System.out.println("n: "+n+", r: "+r+", c: "+c);
		if(n==1) {
			cnt[map[r][c]+1]++;
			return;
		}
		if(!checkBorder(n,r,c)) {
			for(int i=0;i<n;i+=n/3) {
				for(int j=0;j<n;j+=n/3) {
					divide(n/3,r+i,c+j);		
				}
			}
		}
		else {
			cnt[map[r][c]+1]++;
			return;
		}
	}
	private static boolean checkBorder(int n, int r, int c) {	
		for(int i=n/3;i<n;i+=n/3) {
			for(int j=0;j<n;j++) {
				if(map[r+i][c+j]!=map[r+i-1][c+j]) return false;
				if(map[r+j][c+i]!=map[r+j][c+i-1]) return false;			
			}
		}
		return true;
	}
}
