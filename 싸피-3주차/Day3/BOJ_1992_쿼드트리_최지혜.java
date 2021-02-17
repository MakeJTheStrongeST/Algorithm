import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int[][] map;
	static StringBuilder sb;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<N;j++) {
				map[i][j] = str.charAt(j)-'0'; 
			}
		}
		System.out.println(divide(N,0,0));
	}
	private static String divide(int n, int r, int c) {
		StringBuilder sb = new StringBuilder();
		if(n==1) {
			return map[r][c]+"";
		}
		
		sb.append("(")
		.append(divide(n/2,r,c))
		.append(divide(n/2,r,c+n/2))
		.append(divide(n/2,r+n/2,c))
		.append(divide(n/2,r+n/2,c+n/2))
		.append(")");
		
		String str = sb.toString();

		//숫자 4개가 똑같으면 괄호 없애고 하나만 보냄
		if(str.charAt(1)!='(' &&str.charAt(1)==str.charAt(2)&&str.charAt(2)==str.charAt(3)&&str.charAt(3)==str.charAt(4))
			str = str.charAt(1)-'0'+"";
		return str;
	}
}
