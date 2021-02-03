import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class SehoonsGiftShop {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int vSangmin = Integer.parseInt(st.nextToken());
		int vJisoo = Integer.parseInt(st.nextToken());
		int customerNum = Integer.parseInt(st.nextToken());
		List<Integer> wrapSangmin = new ArrayList<>();
		List<Integer> wrapJisoo = new ArrayList<>();
		Queue<Integer> q = new LinkedList<>();
		int num=1;
		for(int i = 0;i<customerNum;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int time = Integer.parseInt(st.nextToken());
			int color = st.nextToken().charAt(0);
			int giftNum = Integer.parseInt(st.nextToken());
			for(int j=0;j<giftNum;j++) {
				q.add(num++);
			}
			if(color=='B') {
				for(int j=0;j<giftNum;j++) {
					wrapSangmin.add(q.poll());
				}
				
			}else {
				for(int j=0;j<giftNum;j++) {
					wrapJisoo.add(q.poll());
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(wrapSangmin.size()).append("\n");
		Iterator<Integer> it = wrapSangmin.iterator();
		while(it.hasNext()) sb.append(it.next()).append(" ");
		sb.append("\n").append(wrapJisoo.size()).append("\n");;
		it = wrapJisoo.iterator();
		while(it.hasNext()) sb.append(it.next()).append(" ");
		
		System.out.println(sb);
	}

}
