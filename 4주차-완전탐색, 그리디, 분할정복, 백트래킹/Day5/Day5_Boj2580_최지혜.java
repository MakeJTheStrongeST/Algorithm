
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Day5_Boj2580_최지혜 {
	static List<int[]> blank;
	static int cnt, map[][];
	static boolean rows[][],cols[][],sqrs[][][];
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[9][9];
		blank = new ArrayList<>();
		rows = new boolean[9][10]; // 행에 숫자가 사용되었는지 여부 저장
		cols = new boolean[9][10];
		sqrs = new boolean[3][3][10];
		StringTokenizer st = null;
		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < 9; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());	
				if(map[i][j] == 0) blank.add(new int[] {i,j});
					
				rows[i][map[i][j]] = true;
				cols[j][map[i][j]] = true;
				sqrs[i/3][j/3][map[i][j]] = true;
			}
		}
		
		cnt = blank.size();

		fill(0);
		print();

	}
	private static boolean fill(int i) {
		
		if(i==cnt) return true;
		
		int[] pos = blank.get(i);
			int r = pos[0];
			int c = pos[1];
			
		for (int num = 1; num <= 9; num++) {
			if(!rows[r][num] && !cols[c][num] && !sqrs[r/3][c/3][num]) {
//				System.out.println("fill "+num+" at "+r+","+c);
				map[r][c] = num;
				rows[r][num] = true;
				cols[c][num] = true;
				sqrs[r/3][c/3][num] = true;
				
				if(fill(i+1)) return true;
			
				rows[r][num] = false;
				cols[c][num] = false;
				sqrs[r/3][c/3][num] = false;
				
			}
		}
		return false;		
	}
	private static void print() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
}
