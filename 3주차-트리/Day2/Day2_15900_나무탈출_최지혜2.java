/*나무탈출*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Boj_15900_2 {
	static int N, cnt=0;
	static ArrayList<ArrayList<Integer>> edges;
	static boolean[] isVisited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		isVisited = new boolean[N];
		StringTokenizer st;
		edges = new ArrayList<>();
		for(int i=0;i<N;i++) {
			edges.add(new ArrayList<>());
		}
		for(int n=0;n<N-1;n++) {
			st = new StringTokenizer(br.readLine(), " ");
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			edges.get(i-1).add(j);
			edges.get(j-1).add(i);
		}
		escape(0,0);//루트노드인 1번에서 시작
//		System.out.println("cnt : "+cnt);
		if(cnt%2 == 1) System.out.println("Yes");
		else System.out.println("No");
	}
	private static void escape(int current, int level) {
//		System.out.println("node"+(current+1));
		if(current!=0 && edges.get(current).size()==1) {
			cnt+=level;
			return;
		}
		isVisited[current] = true;
		Iterator<Integer> it = edges.get(current).iterator();
		while(it.hasNext()) {
			int num = it.next();
			if(isVisited[num-1]) continue;
			escape(num-1, level+1);
		}
	}
}
