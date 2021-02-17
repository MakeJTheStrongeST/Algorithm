import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N,M,dist,min=Integer.MAX_VALUE;
	static int[][] map, map2;
	static List<int[]> bbqs = new ArrayList<>();
	static int[][] selected;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N+1][N+1];
		map2 = new int[N+1][N+1];
		selected = new int[M][];
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=1;j<=N;j++) {
				int num = Integer.parseInt(st.nextToken());
				if(num==1) {
					map[i][j] = num;
					map2[i][j] = num;
				}
				if(num==2) bbqs.add(new int[] {i,j});
			}
		}
		combi(0,0);//치킨집중M개만 남기기
		System.out.println(min);
	}
	private static void chickenDist() {
		dist=0;
		//쭉 돌면서 집이면 치킨거리 구해서 dist 값에 더함
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				if(map[i][j]==1) {
					dist += search(i,j);
				}
			}
		}
		min = Math.min(min, dist);
	}
	private static int search(int r, int c) {
		
		int dist = Integer.MAX_VALUE;
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=N;j++) {
					if(map[i][j]==2) {
//						System.out.println("find chicken! "+r+ " " + c +" "+Math.abs(i-r) + Math.abs(j-c));
						dist = Math.min(dist, Math.abs(i-r) + Math.abs(j-c));
					}
				}
			}
		return dist;
	
	}
	private static void putChicken() {
//		for(int[] arr:selected) {
//			System.out.print(Arrays.toString(arr)+" ");
//		}
//		System.out.println();
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				map[i][j] = map2[i][j];
			}
		}
		for(int[] chicken : selected) {
			map[chicken[0]][chicken[1]] = 2;
		}
//		System.out.println("select complete:");
//		print();
	}
	private static void combi(int cnt, int start) {
		if(cnt==M) {
			putChicken(); //선택된 치킨집만 2로 세팅함
			chickenDist(); //집 기준 치킨거리 계산
			return;
		}
		for(int i=start;i<bbqs.size();i++) {
			selected[cnt] = bbqs.get(i);
			combi(cnt+1,i+1);
		}
	}
}
