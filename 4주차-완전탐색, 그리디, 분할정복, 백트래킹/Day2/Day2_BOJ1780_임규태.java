import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;

	static int n;
	static int[][] map = new int[2187][2187];
	static int[] ans = new int[3];
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				map[i][j] = Integer.parseInt(st.nextToken())+1;
			}
		}
		f(0,0,n);
		for(int i=0;i<3;i++) System.out.println(ans[i]);
	}
	
	static void f(int sy,int sx,int size) {
		int pivot = map[sy][sx];
		
		if(isValid(sy,sx,size)) {
			ans[pivot]++;
			return;
		}
		
		int nxtsize = size/3;
		
		for(int i=0;i<3;i++) for(int j=0;j<3;j++) {
			f(sy+nxtsize*i,sx+nxtsize*j,nxtsize);
		}
	}
	
	static boolean isValid(int sy,int sx,int size) {
		int pivot = map[sy][sx];
		
		for(int i=0;i<size;i++) for(int j=0;j<size;j++) {
			if(pivot != map[i+sy][j+sx]) return false;
		}
		
		return true;
	}
}
