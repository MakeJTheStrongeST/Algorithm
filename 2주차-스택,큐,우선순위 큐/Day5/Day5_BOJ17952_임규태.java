import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Deque<hw> arr = new LinkedList();
		
		int ans = 0;
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			if(Integer.parseInt(st.nextToken()) == 1) {
				int A = Integer.parseInt(st.nextToken());
				int T = Integer.parseInt(st.nextToken());
				arr.addLast(new hw(A,T));
			}
			hw lasthw = arr.peekLast();
			if(lasthw != null && lasthw.work()) {
				ans += lasthw.A;
				arr.removeLast();
			}
		}
		System.out.println(ans);
	}
}

class hw{
	int A,T;
	public hw(int A,int T) {
		this.A = A;
		this.T = T;
	}
	
	public boolean work() {
		return --this.T == 0;
	}
}
