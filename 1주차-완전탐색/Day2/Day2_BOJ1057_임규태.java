import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
	static Scanner sc = new Scanner(System.in);

	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int round = 1; // 만나는 Round
		
		while(true) {
			int minv = Math.min(a, b);
			int maxv = Math.max(a, b);
			if((minv&1) == 1 && minv+1 == maxv) {
				System.out.println(round);
				return;
			}
			
			a = a/2 + a&1;
			b = b/2 + b&1;
			round++;
		}
	}
}
