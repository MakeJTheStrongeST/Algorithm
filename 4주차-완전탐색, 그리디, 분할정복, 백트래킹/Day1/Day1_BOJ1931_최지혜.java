/*회의실 배정*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_1931 {
	static int N, cnt, ans;
	static int max = Integer.MIN_VALUE;
	static int[][] input, result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		input = new int[N][];
		result = new int[N][];

		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			input[i] = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
		}
		Arrays.sort(input,(a1,a2)->a1[0]-a2[0]);
//		for(int[] arr : input) {
//			System.out.println(Arrays.toString(arr));
//		}
		for(int i=0;i<N;i++) {
			select(0,i);
		}
		System.out.println(max);
	}
	private static void select(int cnt, int start) {
		
		if(start == N) {
			for(int i=0;i<cnt;i++) {
				System.out.print(result[i][0]+" "+result[i][1]);
				System.out.println();
			}
			max = Math.max(max, cnt);
			return;
		}
		if(start!=0 && cnt!=0 && input[start][0]<result[cnt-1][1]) {
			select(cnt, start+1);
		}else {
			result[cnt] = input[start];
			select(cnt+1, start+1);
		}
	}
}
