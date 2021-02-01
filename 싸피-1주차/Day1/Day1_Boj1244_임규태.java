import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
	static Scanner sc = new Scanner(System.in);
	static StringTokenizer st;

	static int[] s = new int[101];
	public static void main(String[] args) throws IOException {
		int n= Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=n;i++) {
			s[i] = Integer.parseInt(st.nextToken());
		}
		
		int k = Integer.parseInt(br.readLine());
		int a,b;
		for(int i=0;i<k;i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			if(a == 1) {
				for(int j=1;j<=n;j++) {
					if(j%b == 0) s[j] ^= 1;
				}
			}
			else {
				int tmpl = b;
				int tmpr = b;
				
				for(int j=0;tmpl>0 && tmpr<=n;j++) {
					if((s[tmpl]^s[tmpr]) == 1) break;
					tmpl--;
					tmpr++;
				}
				for(int j=tmpl+1;j<tmpr;j++) {
					s[j] ^= 1;
				}
				
			}
		}
		
		for(int i=1;i<=n;i++) {
			System.out.print(s[i] + " ");
			if(i%20 == 0) System.out.println();
		}
	}
}
