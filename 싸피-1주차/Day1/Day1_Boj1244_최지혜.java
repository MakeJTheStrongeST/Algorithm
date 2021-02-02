
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*1244*/
public class Main {
	static int[] switches;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int switchNum = Integer.parseInt(br.readLine())+1;
		switches = new int[switchNum];
//		String status = br.readLine();
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=1; i<switchNum;i++) {
			switches[i] = Integer.parseInt(st.nextToken());
		}

		int studentNum = Integer.parseInt(br.readLine());
		
		for(int i=0;i<studentNum;i++) {
			st = new StringTokenizer(br.readLine()," ");
			String str = st.nextToken();
			if(str.equals("1")) {
				//str.charAt(2)배수 번째인 스위치 상태  toggle
				int idx = Integer.parseInt(st.nextToken());
				for(int j= idx;j<switchNum;j+=idx) {
					switches[j] = switches[j]^1;
				}

			}else {
				//str.charAt(3) 중심으로 스위치상태 대칭이면서 가장 넓은 범위의 스위치 상태  toggle
				int idx = Integer.parseInt(st.nextToken());
				switches[idx] = switches[idx]^1;
				int j=1;
				while(true) {
					if(idx+j ==switchNum || idx-j <0 || (switches[idx-j] != switches[idx+j])) break;
					else {
						switches[idx-j] = switches[idx-j]^1;
						switches[idx+j] = switches[idx+j]^1;
					}
					j++;
					
				}
			}
		}
		//출력
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<switchNum;i++) {
			if((i%21) == 0)sb.append("\n");
			sb.append(switches[i]).append(" ");
//			if((i%20) == 19)sb.append("\n");
		}
		System.out.print(sb);
	}
}
