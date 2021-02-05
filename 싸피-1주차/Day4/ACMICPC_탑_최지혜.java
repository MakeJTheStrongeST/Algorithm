import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Tower2494_2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		Stack<int[]> stk = new Stack<>();
		
		int[][] towers = new int[N+1][];
		for(int i = 1;i<=N;i++) {
			towers[i] = new int[]{i, Integer.parseInt(st.nextToken())};
		}
		//탑마다 반복
		StringBuilder sb = new StringBuilder();
		sb.append(0).append(" ");
		Loop:for(int i = 2; i<=N;i++) {
			int[] currTower = towers[i];
			int[] leftTower = towers[i-1];
			if(leftTower[1]>currTower[1]) {
				stk.push(leftTower);
			}
			while(!stk.isEmpty()) {
				int[] newTower = stk.pop();
				if(currTower[1]<newTower[1]) {
					sb.append(newTower[0]).append(" ");
					stk.push(newTower);
					continue Loop;
				}
			}
			sb.append(0).append(" ");
		}
		System.out.println(sb.toString());
	}
}
