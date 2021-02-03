
import java.util.Scanner;

public class Farm {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = Integer.parseInt(sc.nextLine());
		for(int i=1; i<=TC; i++) {
			int sum = 0;
			int size = Integer.parseInt(sc.nextLine());
			int[][] map = new int[size][size];
			//입력
			for(int j = 0; j<size;j++) {
				String str = sc.nextLine();
				for(int k = 0; k<size;k++) {
					map[j][k] = str.charAt(k)-48;
				} 
			} 
			if(size==1) {
				System.out.println("#" + i + " " + map[0][0]);
				continue;
			}
//			for(int j = 0; j<size;j++) {
//				for(int k = 0; k<size;k++) {
//					System.out.print(map[j][k]);
//				}
//				System.out.println();
//			}
			
			for(int j = 0; j<size/2;j++) {
				for(int k = size/2-j; k<=j+size/2;k++) {
//					System.out.println("1)"+j+" "+k);
					sum += map[j][k];
				} 
			} 
			for(int k = 0; k<size;k++) {
				sum += map[size/2][k];
			} 
			for(int j = size/2+1; j<size;j++) {
				for(int k = j-size/2; k<=3*(size/2)-j ; k++) {//size+2-j
//					System.out.println("2)"+j+" "+k);
					sum += map[j][k];
				}
			} 
			//출력
			System.out.println("#" + i + " " + sum);
		}

	}

}
