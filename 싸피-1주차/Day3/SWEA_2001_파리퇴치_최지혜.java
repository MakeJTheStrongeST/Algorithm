
import java.util.Scanner;

public class FlyKiller {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		int[][] map;
		for(int i = 1; i<=TC; i++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int max = 0;
			int sum = 0;
			map = new int[n][n];
			for(int j = 0; j<n; j++) {
				for(int k = 0; k<n; k++) {
					map[j][k] = sc.nextInt();
				}
			}
			
			for(int j = 0; j<=n-m; j++) {
				for(int k = 0; k<=n-m; k++) {
					
					sum = 0;
					for(int a = 0; a<m; a++) {
						for(int b = 0; b<m; b++) {
							sum += map[j+a][k+b];
						}
					}
//					System.out.println(max+ " " + sum);
					max = (max>=sum)?max:sum;
					
//					System.out.println("j: "+j+", k: "+k+", sum: "+sum +", max = "+max);
				}
			}
			System.out.println("#"+i+" "+max);
		}

	}

}
