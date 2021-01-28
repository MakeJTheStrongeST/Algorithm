import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
	static Scanner sc = new Scanner(System.in);

	static int n,m,ans;
	static int LIMIT = 1000000; // 100만까지
	static boolean[] chk = new boolean[10]; // 못누르는거 chk
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
		
		ans = Math.abs(n-100); // 현재(100)에서 +-로만 접근
		if(!chk[0]) ans = Math.min(ans, 1+n); // 밑에 함수가 0은 체크를 못해서 따로 체크
		
		f(1); // 1번채널부터 눌러봄
		System.out.println(ans);
	}
	
	static void f(int curv) {
		if(curv > LIMIT) return; // 대충 100만 넘어가면 그냥 100에서 +-로만 가는게 제일 빠름
		
		int tmp = curv;
		int len = 0;
		boolean flag = true;
		while(tmp > 0) { // 길이 계산 + 못누르는거 chk
			if(chk[tmp%10]) flag = false;
			tmp /= 10;
			len++;
		}
		
		if(flag) { // 누를 수 있으면
			ans = Math.min(ans,len+Math.abs(curv-n));
		}
		f(curv+1); // 다음 채널 체크
	}
}
