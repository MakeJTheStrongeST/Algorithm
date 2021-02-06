import java.io.*;
import java.util.*;

public class 퍼펙트셔플 {
	static BufferedReader br;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int i=1;i<=t;i++) solve(i);
	}
	
	static void solve(int tc) throws NumberFormatException, IOException{
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		String[] in = new String[n];
		for(int i=0;i<n;i++) {
			in[i] = new String(st.nextToken());
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("#").append(tc).append(" ");
		int oidx = 0, eidx = n/2+n%2;
		for(int i=0;i<n;i++) {
			if((i&1) == 0) sb.append(in[oidx++]).append(" ");
			else sb.append(in[eidx++]).append(" ");
		}
		
		System.out.println(sb.toString());
	}
	
}
