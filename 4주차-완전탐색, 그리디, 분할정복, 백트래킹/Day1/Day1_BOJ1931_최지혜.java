/*회의실 배정*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Boj_1931 {
	static int N, cnt=1;
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
		Arrays.sort(input,new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				int num = o1[1]-o2[1];
				return (num!=0)?num:o1[0]-o2[0];
			}
		});
		for(int[] arr: input) {
			System.out.print(arr[0] + " "+arr[1]);
			System.out.println();
		}
		select();
		System.out.println(cnt);
	}
	private static void select() {
		result[0] = input[0];
		for(int i=1;i<N;i++) {
			if(input[i][0]>=result[cnt-1][1]) {
				result[cnt] = input[i];
				cnt++;
			}
		}
	}
}
