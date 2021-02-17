import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;

	static List<p> home = new ArrayList(),chicken = new ArrayList();
	static int n,m,ans = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j=0;j<n;j++) {
				int x = Integer.parseInt(st.nextToken());
				if(x == 1) home.add(new p(i,j,13));
				else if(x == 2) chicken.add(new p(i,j));
			}
		}
		for(p homep : home) {
			for(int i=0;i<chicken.size();i++) {
				p chickenp = chicken.get(i);
				homep.chickenDist[i] = Math.abs(homep.y - chickenp.y) + Math.abs(homep.x - chickenp.x);
			}
		}
		f(0,0,0);
		System.out.println(ans);
	}
	
	static void f(int idx,int cnt,int mask) {
		if(cnt == m) {
			int sum = 0;
			for(p homep : home) {
				int minval = Integer.MAX_VALUE;
				for(int i=0;i<chicken.size();i++) {
					if((mask&1<<i) != 0) {
						minval = Math.min(homep.chickenDist[i], minval);
					}
				}
				sum += minval;
			}
			ans = Math.min(ans, sum);
			return;
		}
		if(idx == chicken.size()) return;
		
		if((mask&1<<idx) == 0) {
			f(idx+1,cnt+1,mask|1<<idx);
		}
		f(idx+1,cnt,mask);
	}
		
	static class p{
		int y,x;
		int[] chickenDist;
		public p(int y,int x) {
			this.y = y;
			this.x = x;
		}
		public p(int y,int x,int m) {
			this.y = y;
			this.x = x;
			this.chickenDist = new int[m];
		}
	}
}
