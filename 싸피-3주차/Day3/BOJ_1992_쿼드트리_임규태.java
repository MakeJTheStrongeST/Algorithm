import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;

	static int n;
	static char[][] map;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new char[n][];
		for(int i=0;i<n;i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		f(0,0,n-1,n-1,n);
		System.out.println(sb);
	}
	
	static void f(int sy,int sx,int ey,int ex,int cursize) {
		char pivot = map[sy][sx];
		boolean flag = true;
		for(int i=sy;i<=ey && flag;i++) {
			for(int j=sx;j<=ex && flag;j++) {
				if(map[i][j] != pivot) flag = false;
			}
		}
		
		if(flag) {
			sb.append(pivot);
			return;
		}
		
		int nxtsize = cursize/2;
		
		sb.append("(");
		f(sy,sx,ey-nxtsize,ex-nxtsize,nxtsize);
		f(sy,sx+nxtsize,ey-nxtsize,ex,nxtsize);
		f(sy+nxtsize,sx,ey,ex-nxtsize,nxtsize);
		f(sy+nxtsize,sx+nxtsize,ey,ex,nxtsize);
		sb.append(")");
	}
}
