import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		PriorityQueue<Meeting> pq = new PriorityQueue(new Comparator<Meeting>(){
			@Override
			public int compare(Meeting o1, Meeting o2) {
				return o1.e == o2.e ? o1.s - o2.s : o1.e - o2.e;
			}
		});
		int n = Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			pq.add(new Meeting(a,b));
		}
		
		int prevend = 0;
		int ans = 0;
		while(!pq.isEmpty()) {
			Meeting cur = pq.poll();
			if(cur.s >= prevend) {
				prevend = cur.e;
				ans++;
			}
		}
		System.out.println(ans);
	}
}

class Meeting{
	int s,e;
	public Meeting(int s,int e) {
		this.s = s;
		this.e = e;
	}
	
}
