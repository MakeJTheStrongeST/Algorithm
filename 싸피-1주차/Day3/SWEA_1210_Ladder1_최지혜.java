

import java.util.Scanner;

public class Ladder {

	static int[][] ladders = new int[100][100];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int i=1;i<=10;i++) {
			int tc= sc.nextInt();
			for(int j=0;j<100;j++) {
				for(int k=0;k<100;k++) {
					ladders[j][k] = sc.nextInt();
				}
			}
			System.out.println("#" + i + " " + play());
		}
	}
	
	private static int play() {
		int start = 0; //출발해야할  위치
		//2찾기
		for(int j=0;j<100;j++) {
			if(ladders[99][j] == 2) {
				start = j;
				break;
			}
		}
//		System.out.println("init start : " + start);
		//좌우 살피며 위로 올라가며 start 바꾸기
		//좌나 우에 1이면 거기로감
		//좌 우 둘다 1 없으면 위로 감
		char flag='U';
		int j=98;
		while(j>=0) {
//		for(int j=98;j>=0;j--) {//2위는 무조건 1이고, 2좌우는 무조건 0이라고 생각하여 99번째는 생략함
//			System.out.println("hey..?");
			if(start-1>=0 && ladders[j][start-1]==1 && flag!='R'){//좌측에 사다리 연결되어있을 때
				flag='L';
				start--;
			}else if(start+1<100 && ladders[j][start+1]==1 && flag!='L'){//우측에 사다리 연결되어있을 때
				flag='R';
				start++;
			}else {
				flag='U';
				j--;
			}
//			System.out.println(99-j+"'s start : " + start+", flag :" +flag);
		}
		//...
		
		return start;
	}

}
