package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day4_BOJ1107_박원석 {
	static boolean[] broken = new boolean[10];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine()); // 보고 싶은 채널
		int m = Integer.parseInt(in.readLine()); // 고장난 버튼 개수
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		while(st.hasMoreTokens()) 
			broken[Integer.parseInt(st.nextToken())] = true; // n번 고장 -> broken[n] = true;
		
		// 방법1. 100 채널에서 +, - 하는 경우
		int answer = Math.abs(n - 100);
		
		// 방법2. 입력 가능한 채널을 모두 탐색한다 -> 입력 가능한 채널에서 +, - 하는 경우
		// 채널 입력은 0 ~ 1000000까지 해보면 된다 (채널이 6자리까지니까 7자리까지 입력해보면 된다)
		for(int i=0; i<=1000000; i++) {
			int cnt = isPossible(i); // 입력 가능하면 버튼 누르는 개수 반환, 불가능하면 0 반환
			
			if(cnt != 0) 
				answer = Math.min(answer, Math.abs(n - i) + cnt); // 방법1, 2 중 최소값 도출
		}
		
		// 결과
		System.out.println(answer);
	}
	
	static int isPossible(int channel) {
		// 0이라면 1번 클릭해야함 (이걸 잘 생각 못했음...)
		if(channel == 0) {
			if(broken[channel]) return 0;
			else return 1;
		}
		
		// 입력 가능하면 자리수 반환, 입력 불가능하면 0 반환
		int cnt = 0;	
		while(channel != 0) {
			if(broken[channel % 10]) return 0;	
			channel /= 10;
			cnt++;
		}
		return cnt;
	}
}
