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
//		List<Character> ordersSangmin = new ArrayList<>();
//		List<Character> ordersJisoo = new ArrayList<>();
		int[] orderSangmin = new int[86400];
		int[] orderJisoo = new int[86400];
		int giftNum = 0;
		boolean sameTime = false;
//		System.out.print(vSangmin+" "+vJisoo+" "+customerNum);
		if(vSangmin==0 && vJisoo==0) {
			int num=1;
			for(int i = 0;i<customerNum;i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int time = Integer.parseInt(st.nextToken());
				int color = st.nextToken().charAt(0);
				int giftNum1 = Integer.parseInt(st.nextToken());
				for(int j=0;j<giftNum1;j++) {
					q.add(num++);
				}
				if(color=='B') {
					for(int j=0;j<giftNum1;j++) {
						wrapSangmin.add(q.poll());
					}
					
				}else {
					for(int j=0;j<giftNum1;j++) {
						wrapJisoo.add(q.poll());
					}
				}
			}
			
			
		}else {
			for(int i = 0;i<customerNum;i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int time = Integer.parseInt(st.nextToken());
				char color = st.nextToken().charAt(0);
				int num = Integer.parseInt(st.nextToken());
				giftNum += num;
				if(color == 'B') 	orderSangmin[time] = num;
				else 				orderJisoo[time] = num;
			}
			
			for(int j=1;j<=giftNum;j++) {
				q.add(j);
			}
			
			while(!q.isEmpty()) {//선물을 모두 포장할 동안
				//배열순회
				for(int k=0,size=orderSangmin.length-vJisoo;k<size;k++) {
					if((orderSangmin[k]+orderJisoo[k]) != 0) {
						if(orderSangmin[k]!=0&&orderJisoo[k]!=0) {//동시인경우
							orderSangmin[k+vSangmin] += (orderSangmin[k]-1);
							orderSangmin[k] = 0;
							wrapSangmin.add(q.poll());
							orderJisoo[k+vJisoo] += (orderJisoo[k]-1);
							orderJisoo[k] = 0;
							wrapJisoo.add(q.poll());
						}else if(orderJisoo[k]==0) {//상민
							orderSangmin[k+vSangmin] += (orderSangmin[k]-1);
							orderSangmin[k] = 0;
							wrapSangmin.add(q.poll());
						}else {//지수
							orderJisoo[k+vJisoo] += (orderJisoo[k]-1);
							orderJisoo[k] = 0;
							wrapJisoo.add(q.poll());
						}
					}
				}
				
			}
		}
		//출력
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
