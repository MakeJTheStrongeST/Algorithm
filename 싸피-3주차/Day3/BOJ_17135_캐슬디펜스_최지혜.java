import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

/*A형 기출 - 캐슬디펜스*/
public class Main {
	static int N,M,D,cnt;
	static int max = Integer.MIN_VALUE;
	static Set<String> target = new HashSet<>();
	static int[][] map, map2;
	static int[] archer = new int[3];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		map2 = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<M;j++) {
				int num = Integer.parseInt(st.nextToken());
				map[i][j] = num;
				map2[i][j] = num;
			}
		}
		//궁수 배치 
		combi(0,0);	
		//출력
		System.out.println(max);
	}
	private static void play() {
//		System.out.println("========= case : archers at " + Arrays.toString(archer) + " ===========");
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				map[i][j] = map2[i][j];
			}
		}
		cnt=0;
//		print();
		for(int turn=0;turn<N;turn++) {
			target.clear();
			for(int a=0; a<3; a++) { //궁수 3명에 대해 반복
				searchEnemy(archer[a]);//궁수 위치 (열)		
			}
			attackEnemy(target);
//			System.out.println("attack");
//			print();
			moveEnemy();
//			System.out.println("move");
//			print();
		}
		max = Math.max(cnt, max);
//		System.out.println("max :" + max);
	}
	private static void searchEnemy(int c) {
//		System.out.println("search ememy from c: "+ c);
		int dist=1;
		while(dist<=D) {	
			int i=N-1, j=c-dist+1;
			//행감소 열증가
			while(i>=N-dist) {
//				System.out.println("i:"+i+", j:"+j);
				if(i>=0 && i<N && j>=0 && j<M && map[i][j]==1) {
					target.add(i+" "+j);
					return;
				}
				i--; j++;
			}
			i=N-dist+1;
			//행증가 열증가
			while(i<N && j<c+dist) {
				if(i>=0 && i<N && j>=0 && j<M && map[i][j]==1) {
					target.add(i+" "+j);
					return;
				}
				i++; j++;
			}
			dist++;
		}	
	}

	private static void attackEnemy(Set<String> targets) {
		Iterator<String> it = targets.iterator();
		StringTokenizer st;
		while(it.hasNext()) {
			String str = it.next();
			st = new StringTokenizer(str," ");
			map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]=0;
			cnt++;
		}
	}
	private static void moveEnemy() {
		
		for(int i=N-1;i>0;i--) {
			for(int j=0;j<M;j++) {
				map[i][j] = map[i-1][j];
			}
		}
		for(int j=0;j<M;j++) {
			map[0][j] = 0;
		}
//		System.out.println("enemy moved :");
//		print();
	}
	private static void combi(int cnt, int start) {
		if(cnt==3) {
			play();
			return;
		}
		for(int i=start;i<M;i++) {
			archer[cnt] = i;
			combi(cnt+1,i+1);
		}
	}
	private static void print() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
}
