import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] arr = new int[3];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		for(int i=0;i<3;i++) arr[i] = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		boolean ans = false;
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				for(int k=0;k<100;k++) {
					if(arr[0]*i+arr[1]*j+arr[2]*k == n) ans = true;
				}
			}
		}
		
		if(ans) System.out.println(1);
		else System.out.println(0);
	}
}
