import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;

	static int[] colmask = new int[9], rowmask = new int[9];
	static int[][] sqmask = new int[3][3],map = new int[9][9];
	static List<p> blankList = new ArrayList();
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0;i<9;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<9;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0) blankList.add(new p(i,j));
			}
		}
		
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				rowmask[i] |= 1<<map[i][j];
				colmask[j] |= 1<<map[i][j];
				sqmask[i/3][j/3] |= 1<<map[i][j];
			}
		}
		
		f(0);
	}
	
	static void print() {
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	static boolean f(int idx) {
		if(idx == blankList.size()) {
			print();
			return true;
		}
		
		p cur = blankList.get(idx);
		int cury = cur.y;
		int curx = cur.x;

		int sqy = cury/3;
		int sqx = curx/3;
		for(int i=1;i<=9;i++) {
			if((colmask[curx]&1<<i) == 0 && (rowmask[cury]&1<<i) == 0 && (sqmask[sqy][sqx]&1<<i) == 0) {
				map[cury][curx] = i;
				colmask[curx] |= 1<<i;
				rowmask[cury] |= 1<<i;
				sqmask[sqy][sqx] |= 1<<i;
				if(f(idx+1)) return true;
				colmask[curx] &= ~(1<<i);
				rowmask[cury] &= ~(1<<i);
				sqmask[sqy][sqx] &= ~(1<<i);
			}
		}
		return false;
	}
	
	static class p{
		int y,x;
		public p(int y,int x) {
			this.y = y;
			this.x = x;
		}
	}
}
