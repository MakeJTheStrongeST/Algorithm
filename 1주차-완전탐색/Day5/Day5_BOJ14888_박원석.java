import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day5_BOJ14888_박원석 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static int n, maxRes = -1000000000, minRes = 1000000000;
	static int[] num, op;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		input();
		
		DFS(1, num[0]);
		
		output();
	}
	
	static void input() throws NumberFormatException, IOException {
		n = Integer.parseInt(in.readLine());
		num = new int[n];
		op = new int[4];
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int i = 0;
		while(st.hasMoreTokens()) num[i++] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(in.readLine(), " ");
		i = 0;
		while(st.hasMoreTokens()) op[i++] = Integer.parseInt(st.nextToken());
	}
	
	static void DFS(int level, int result) {
		if(level == n){
	        if(result > maxRes) maxRes = result;
	        if(result < minRes) minRes = result;
	    }
	    else{
	        if(op[0] > 0){
	            op[0]--;
	            DFS(level + 1, result + num[level]);
	            op[0]++;
	        }
	        if(op[1] > 0){
	            op[1]--;
	            DFS(level + 1, result - num[level]);
	            op[1]++;
	        }
	        if(op[2] > 0){
	            op[2]--;
	            DFS(level + 1, result * num[level]);
	            op[2]++;
	        }
	        if(op[3] > 0){
	            op[3]--;
	            DFS(level + 1, result / num[level]);
	            op[3]++;
	        }
	    }
	}
	
	static void output() {
		StringBuilder sb = new StringBuilder();
		sb.append(maxRes).append("\n").append(minRes);
		System.out.println(sb.toString());
	}
}
