import java.util.Scanner;

public class Day2_BOJ1057_박원석 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 참가자 수
		int kjm = sc.nextInt(); // 김지민 번호
		int ihs = sc.nextInt(); // 임한수 번호
		int round = 0; // 라운드 번호
		
		// 서로 대결을 한 후 번호가 같아진다고 볼 수 있다
		while(kjm != ihs) {
			kjm = nextNum(kjm);
			ihs = nextNum(ihs);
			round++;
		}
		
		// 결과 출력
		System.out.println(round);
		
		sc.close();
	}
	
	static int nextNum(int num) {
		if(num % 2 == 1) 
			num = num / 2 + 1;
		else 
			num = num / 2;
		return num;
	}
}
