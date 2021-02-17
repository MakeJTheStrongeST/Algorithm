import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;

	static int n,r,c;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		f(0,0,(int)Math.pow(2, n),0);
	}
	
	static boolean isValid(int y,int x) {
		return y<=r && x<=c;
	}
	
	static void f(int sy,int sx,int size,int cnt) {
		if(size == 1) {
			System.out.println(cnt);
			return;
		}

		int jump = size/2;
		if(isValid(sy+jump,sx+jump)) {
			f(sy+jump,sx+jump,size/2,cnt+(size/2)*(size/2)*3);
		}
		else if(isValid(sy+jump,sx)){
			f(sy+jump,sx,size/2,cnt+(size/2)*(size/2)*2);
		}
		else if(isValid(sy,sx+jump)) {
			f(sy,sx+jump,size/2,cnt+(size/2)*(size/2));
		}
		else if(isValid(sy,sx)){
			f(sy,sx,size/2,cnt);
		}
	}

}
