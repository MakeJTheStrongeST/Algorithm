import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
	static Scanner sc = new Scanner(System.in);

	static int n,m,ans;
	static int LIMIT = 1000000;
	static boolean[] chk = new boolean[10];
	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		if(m > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0;i<m;i++) {
				int tmp = Integer.parseInt(st.nextToken());
				chk[tmp] = true;
			}
		}
		
		ans = Math.abs(n-100);
		if(!chk[0]) ans = Math.min(ans, 1+n);
		
		f(1);
		System.out.println(ans);
	}
	
	static void f(int curv) {
		if(curv > LIMIT) return;
		
		int tmp = curv;
		int len = 0;
		boolean flag = true;
		while(tmp > 0) {
			if(chk[tmp%10]) flag = false;
			tmp /= 10;
			len++;
		}
		
		if(flag) {
			ans = Math.min(ans,len+Math.abs(curv-n));
		}
		f(curv+1);
	}
}
