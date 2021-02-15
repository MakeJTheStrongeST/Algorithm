/*트리순회*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

public class Boj_15900 {
	static String YesOrNo = "";
	static int N, cnt=0;
	static ArrayList<ArrayList<Integer>> edges;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String str;
		edges = new ArrayList<>();
		for(int i=0;i<N+1;i++) {
			edges.add(new ArrayList<>());
		}
		for(int n=0;n<N-1;n++) {
			str = br.readLine();
			int i = str.charAt(0)-'0';
			int j = str.charAt(2)-'0';
			edges.get(i).add(j);
			edges.get(j).add(i);
		}
		escape(1);
//		System.out.println("cnt : "+ +cnt);
		if(cnt%2 == 1) System.out.println("Yes");
		else System.out.println("No");
	}
	private static void escape(int current) {
		if(edges.get(current).isEmpty()) {
			cnt++;
//			System.out.println(current+" "+ cnt);
			return;
		}
//		System.out.println(current+" "+ cnt);
		Iterator<Integer> it = edges.get(current).iterator();
		while(it.hasNext()) {
			int num = it.next();
			edges.get(num).remove(Integer.valueOf(current));
			cnt += edges.get(num).size();
			escape(num);
		}
	}
}
