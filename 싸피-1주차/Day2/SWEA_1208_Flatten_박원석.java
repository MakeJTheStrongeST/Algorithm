import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1208_Flatten {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 1; i <= 10; i++) {
			int dump = Integer.parseInt(in.readLine());
            int[] hCnt = new int[101];
            int max = 0, min = 101;
            StringTokenizer st = new StringTokenizer(in.readLine(), " ");
            for (int j = 0; j < 100; j++) {
            	int h = Integer.parseInt(st.nextToken());
            	hCnt[h]++;
            	max = Math.max(max, h);
            	min = Math.min(min, h);
            }
            
            for (int j = 0; j < dump; j++) {
                hCnt[max]--; hCnt[max - 1]++;
                hCnt[min]--; hCnt[min + 1]++;
                
                if(hCnt[max] == 0)	
                	max--;
                
                if(hCnt[min] == 0)
                	min++;
                
                if(max == min)
                	break;
            }
            
            System.out.println("#" + i + " " + (max - min));
		}
	}
}
