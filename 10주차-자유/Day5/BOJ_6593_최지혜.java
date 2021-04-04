import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int L,R,C;
		
	static class Graph {
		int N;
		ArrayList<ArrayList<int[]>> adj;
		boolean[][][] isVisited;
		
		Graph(){}
		Graph(int n){
			N=n;
			adj = new ArrayList<>();
			for(int i=0;i<N;i++) adj.add(new ArrayList<>());
			isVisited = new boolean[L+1][R+1][C+1];
		}
		
		void addEdge(int[] u, int[] v) {
			adj.get((u[0]-1)*R*C+(u[1]-1)*C+u[2]-1).add(v);
//			adj.get((v[0]-1)*R*C+(v[1]-1)*C+v[2]-1).add(u);
		}
		
		int bfs(int[] s, int[] e) {
			
			Queue<int[]> q = new ArrayDeque<>();
			q.offer(s);
			isVisited[s[0]][s[1]][s[2]] = true;
			int len = 1;
			
			while(!q.isEmpty()) {
				
				int size = q.size();
				while(--size>=0) {
					
					int[] curr = q.poll(); 
//					System.out.println("curr: "+curr[0]+" "+curr[1]+" "+curr[2]);
					Iterator<int[]> it = adj.get((curr[0]-1)*R*C+(curr[1]-1)*C+curr[2]-1).iterator();
					
					while(it.hasNext()) {
						int[] next = it.next();
//						System.out.println("next: "+next[0]+" "+next[1]+" "+next[2]);
						if(next[0] == e[0] && next[1] == e[1] && next[2] == e[2]) return len;
						if(!isVisited[next[0]][next[1]][next[2]]) {
							q.offer(next);
							isVisited[next[0]][next[1]][next[2]] = true;
						}
					}
				}
				len++;
			}
			
			return -1;
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			L = Integer.parseInt(st.nextToken()); //층수
			R = Integer.parseInt(st.nextToken()); //한 층의 행 개수
			C = Integer.parseInt(st.nextToken()); //한 층의 열 개수
			char[][][] map = new char[L+2][R+2][C+2]; //경계값 체크 생략하기 위해 배열 크기에 패딩 지정
			
			if(L==0 && R==0 && C==0) break;
			
			for (int i = 1; i <= L; i++) {
				for(int j = 1; j <= R; j++) {
					char[] chArr = br.readLine().toCharArray();
					for(int k = 1; k <= C; k++) {
						map[i][j][k] = chArr[k-1];
					}
				}
				br.readLine();
			}
			
			Graph g = new Graph((L+1)*(R+1)*(C+1));
			int[] dl = {-1,1,0,0,0,0};//위 아래 상 하 좌 우
			int[] dr = {0,0,-1,1,0,0};
			int[] dc = {0,0,0,0,-1,1};
			int[] S = {-1,-1,-1}, E= {-1,-1,-1};
		
			for (int i = 1; i <= L; i++) {
				for (int j = 1; j <= R; j++) {
					for (int k = 1; k <= C; k++) {
						for(int d=0; d<6; d++) {
							int nl = i+dl[d];
							int nr = j+dr[d];
							int nc = k+dc[d];
							
							if(map[nl][nr][nc]=='S') S = new int[] {nl, nr, nc};
							else if(map[nl][nr][nc]=='E') {
								E = new int[] {nl, nr, nc};
								g.addEdge(new int[] {i,j,k}, new int[] {nl, nr, nc});
							}
							else if(map[nl][nr][nc]=='.') g.addEdge(new int[] {i,j,k}, new int[] {nl, nr, nc});
						}
					}
				}
			}
			
			int res = g.bfs(S,E);
			System.out.println(res == -1 ? "Trapped!" : "Escaped in "+ res +" minute(s).");
		}
	}
	
}
