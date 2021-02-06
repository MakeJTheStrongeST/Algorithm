import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Tournament {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int J = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int cnt=1;
		while(N>2) {			
//			System.out.println("N, J, H : "+N+", "+J+", "+H);
			if(J%2==1&&H==J+1||H%2==1&&J==H+1) break;
			N = (N%2==0) ? N/2 : (N+1)/2;
			J = (J%2==0)?J/2:(J+1)/2;
			H = (H%2==0)?H/2:(H+1)/2;
			cnt++;
		}
		System.out.println(cnt);
		//안대결한느경우 - 없음
	}
}
