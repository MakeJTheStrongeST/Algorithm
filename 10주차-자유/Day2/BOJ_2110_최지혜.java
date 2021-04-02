import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int[] pos = new int[N];
		
		for (int i = 0; i < N; i++) pos[i] = Integer.parseInt(br.readLine());
		
		Arrays.sort(pos); //집의 위치 오름차순 정렬
		
		//이분탐색
		int left = 1;
	    int right = pos[N-1] - pos[0]; 
	    int d = 0;
	    int ans = 0;
	 
	    while (left <= right) {
	        int mid = (left + right) / 2; // 기준
	        int start = pos[0];
	        int cnt = 1;
	 
	        // d 를 기준으로 공유기 설치
	        for (int i = 1; i < N; i++) {
	            d = pos[i] - start;
	            if (mid <= d) {
	                ++cnt;
	                start = pos[i];
	            }
	        }
	 
	        if (cnt >= C) { // 공유기 부족함        
	            ans = mid;
	            left = mid + 1;
	        } else { // 공유기 덜 설치됨
	            right = mid - 1;
	        }
	    }
	    
	    //출력
	    System.out.println(ans);
	}

}
