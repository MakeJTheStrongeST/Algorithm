import java.util.Scanner;

public class Day3_BOJ14629_박원석 {
	static Long n, answer, minDif = 1000000000000L;
	static int len;
	static boolean[] ch = new boolean[10]; // 0 ~ 9 숫자 사용 여부
	static int[] res = new int[10]; // 순열로 나오는 수 저장

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextLong();

		// n 길이 (순열로 같은 길이의 수 뽑기 위해)
		for (Long tmp = n; tmp > 0; len++)
			tmp /= 10;

		// 9876543210 이상 값은 9876543210과 최소 차이가 날 수 밖에...
		if (n >= 9876543210L) {
			System.out.println("9876543210");
			sc.close();
			return;
		}

		// 순열로 완전 탐색
		DFS(0);

		// 결과
		System.out.println(answer);

		sc.close();
	}

	static void DFS(int level) {
		if (level == len) {
			Long resNum = 0L;
			for (int i = 0; i < len; i++) {
				resNum *= 10;
				resNum += res[i];
			}

			Long curDif = Math.abs(resNum - n);
			if (minDif > curDif) { 
				minDif = curDif;
				answer = resNum;
			}
		}

		for (int i = 0; i < 10; i++) {
			if (!ch[i]) {
				ch[i] = true;
				res[level] = i;
				DFS(level + 1);
				ch[i] = false;
			}
		}
	}
}
