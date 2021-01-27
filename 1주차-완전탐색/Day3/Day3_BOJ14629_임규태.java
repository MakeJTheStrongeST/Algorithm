import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
	static Scanner sc = new Scanner(System.in);

	static int len;
	static long n,ansdif,ansv;
	public static void main(String[] args) throws IOException {
		n = Long.parseLong(br.readLine());
		
		long tmp = n; // 길이 계산
		while(tmp > 0) {
			tmp /= 10;
			len++;
		}
		
		if(len > 10) { // 길이가 10보다 크면 or 9876543210보다 크면 9876543210이 가장 가까움
			System.out.println(9876543210L); // 10자리까지는 9876543210을 커버 가능하니까 len으로 체크
			return;
		}
		
		ansdif = (long)1e17; // INF값으로 초기화
		f(0,0,0);
		System.out.println(ansv);
	}
	
	static void f(int mask, long curv, int used) {
		if(used == len) { // 사용한 숫자 개수가 앞서 계산한 len과 같으면
			long curdif = Math.abs(curv-n); // dif값 계산
			if(curdif < ansdif) { // dif가 작으면 답이 됨
				ansdif = curdif;
				ansv = curv;
			}
			else if(curdif == ansdif) ansv = Math.min(ansv, curv); //dif가 같으면 더 작은게 답
			return;
		}
		
		for(int i=0;i<10;i++) { // 사용하지 않은 숫자카드 확인
			if((mask&1<<i) == 0) {
				f(mask|1<<i,curv*10+i,used+1);
			}
		}
	}
}
