import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] arr = new int[3];
	static boolean ans = false;
	static int n;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		for(int i=0;i<3;i++) arr[i] = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		f(0,0);
		
		if(ans) System.out.println(1);
		else System.out.println(0);
	}
	
	static void f(int mask, int sum) {
		if(sum == n) {
			ans = true;
			return;
		}
		for(int i=0;i<3;i++) {
			if((mask&1<<i) == 0) {
				for(int j=0;sum+arr[i]*j<=n;j++) {
					f(mask|1<<i,sum+arr[i]*j);
				}
			}
		}
	}
}
