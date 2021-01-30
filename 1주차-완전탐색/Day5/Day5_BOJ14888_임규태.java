import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
	static Scanner sc = new Scanner(System.in);
	static StringTokenizer st;

	static int[] oper = new int[4], arr = new int[11];
	static int n,max,min;
	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<4;i++) {
			oper[i] = Integer.parseInt(st.nextToken());
		}
		
		max = -(int)1e9; // max, min 초기화
		min = (int)1e9;
		f(1,arr[0]); // 처음 수는 arr[0]으로 같고 operation 수와 맞추기 위해 1부터 돌림
		System.out.println(max);
		System.out.println(min);
	}
	
	static void f(int idx, int sum) {
		if(idx == n) { // 끝까지 도달하면 계산하고 return
			max = Math.max(max, sum);
			min = Math.min(min, sum);
			return;
		}
		for(int i=0;i<4;i++) {
			if(oper[i]>0) { // 남은 operation이 있으면
				oper[i]--; 
				int nxtsum = calc(sum,arr[idx],i); // 코드가 길어져서 메소드로 만듦
				f(idx+1,nxtsum);
				oper[i]++; // 줄였다 늘렸다 하면서 모든경우 탐색
			}
		}
	}
	
	static int calc(int sum,int curv,int type) {
		if(type == 0) return sum+curv;
		if(type == 1) return sum-curv;
		if(type == 2) return sum*curv;
		return sum/curv;
	}
}
