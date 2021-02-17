import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;

	static int n,m,d,ans;
	static List<p> enemies = new ArrayList(), archers = new ArrayList(), targetList;
	static p[] selected = new p[3];
	static boolean flag;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				int x = Integer.parseInt(st.nextToken());
				if(x == 1) enemies.add(new p(i,j,false));
			}
		}
		for(int i=0;i<m;i++) {
			archers.add(new p(n,i));
		}
		f(0,0);
		System.out.println(ans);
	}
	
	static boolean shot(p archer,p enemy,int step) {
		return dist(archer,enemy,step) <= d;
	}
	
	static int dist(p archer, p enemy, int step) {
		return Math.abs(archer.y - (enemy.y + step)) + Math.abs(archer.x - enemy.x);
	}
	
	static void reset() {
		for(p enemy : enemies) enemy.dead = false;
	}
	
	static p getTarget(p archer,int step) {
		p target = null;
		for(p enemy : enemies) {
			if(validEnemy(enemy,step)) {
				flag = true;
				if(shot(archer,enemy,step)) {
					if(target == null) {
						target = enemy;
						continue;
					}
					int targetdist = dist(archer,target,step);
					int enemydist = dist(archer,enemy,step);
					if(targetdist == enemydist && enemy.x < target.x ||
							enemydist < targetdist) {
						target = enemy;
					}
				}
			}
		}
		return target;
	}
	
	static boolean validEnemy(p enemy,int step) {
		if(enemy.y+step < n && !enemy.dead) return true;
		return false;
	}
	
	static void f(int idx,int cnt) {
		if(cnt == 3) {
			flag = true;
			int step = 0;
			int subans = 0;
			while(flag) {
				flag = false;
				targetList = new ArrayList();
				for(int i=0;i<3;i++) {
					p archer = selected[i];
					p target = getTarget(archer,step);
					if(target != null) {
						targetList.add(target);
					}
				}
				for(p tg : targetList) tg.dead = true;
				step++;
			}
			
			for(p enemy : enemies) {
				if(enemy.dead) {
					subans++;
				}
			}
			ans = Math.max(ans, subans);
			
			reset();
			return;
		}
		
		for(int i=idx;i<m;i++) {
			selected[cnt] = archers.get(i);
			f(i+1,cnt+1);
		}
	}
	
	static class p{
		int y,x;
		boolean dead;
		public p(int y,int x) {
			this.y = y;
			this.x = x;
		}
		public p(int y,int x,boolean dead) {
			this.y = y;
			this.x = x;
			this.dead = dead;
		}
	}
}
