import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;

	static List<Integer>[] path;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		path = new List[n+1];
		
		for(int i=0;i<=n;i++) path[i] = new ArrayList<Integer>();
		
		for(int i=0;i<n-1;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			path[a].add(b);
			path[b].add(a);
		}
		
		if((f(1,0,0)&1) == 1) System.out.println("Yes");
		else System.out.println("No");
	}
	
	static int f(int cur,int parent,int cnt) {
		int ret = 0;
		List<Integer> list = path[cur];
		if(cur != 1 && list.size() == 1) {
			return cnt;
		}
		
		for(int nxt : list) {
			if(nxt != parent)  {
				ret += f(nxt,cur,cnt+1);
			}
		}
		return ret;
		
	}
}
