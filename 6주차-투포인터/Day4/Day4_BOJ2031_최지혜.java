import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Day4_BOJ2031_최지혜 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken()); // 접시 수 
		int d = Integer.parseInt(st.nextToken()); // 초밥의 가짓수(=>번호 최댓값?)
		int k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시수
		int c = Integer.parseInt(st.nextToken()); // 쿠폰번호
		
		int[] dish = new int[N+k];
		for (int i = 0; i < N; i++) dish[i] = Integer.parseInt(br.readLine());
		for (int i = 0; i < k; i++) dish[N+i] = dish[i];
		int[] count = new int[d+1]; // 초밥을 선택한 개수를 저장
		int max = 0, ans = 0;
	
		for (int i = 0; i < k; i++) {
			if(++count[dish[i]]==1) max++;
		}

		ans = max;

		for(int i=0;i<N;i++) {
			
			if(--count[dish[i]]==0) ans--;
			if(++count[dish[i+k]]==1) ans++;

			max = Math.max(max, count[c]==0 ? ans+1 : ans); //선택한 초밥 중 쿠폰 초밥이 없는 경우 쿠폰초밥까지 더한 값으로 max 값 갱신
			
		}
		
		System.out.println(max);
	}

}
