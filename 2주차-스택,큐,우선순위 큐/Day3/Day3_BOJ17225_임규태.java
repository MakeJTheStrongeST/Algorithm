import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Day3_BOJ17225_임규태 {
	static BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static List<Integer> blist = new ArrayList() ,rlist = new ArrayList(), bans = new ArrayList(), rans = new ArrayList();
	static int b,r,n;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		b = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			
			int t = Integer.parseInt(st.nextToken());
			char c = st.nextToken().charAt(0);
			int k = Integer.parseInt(st.nextToken());
			
			if(c == 'B' && !blist.isEmpty()) t = Math.max(t, blist.get(blist.size()-1)+b);
			if(c == 'R' && !rlist.isEmpty()) t = Math.max(t, rlist.get(rlist.size()-1)+r);
			
			for(int j=0;j<k;j++) {
				if(c == 'B') blist.add(t+b*j);
				else rlist.add(t+r*j);
			}
		}
		
		int cnt = 1;
		int bidx = 0,ridx = 0;
		while(bidx < blist.size() || ridx < rlist.size()){
			if(bidx == blist.size()) {
				rans.add(cnt++);
				ridx++;
			}
			else if(ridx == rlist.size()) {
				bans.add(cnt++);
				bidx++;
			}
			else {
				int bval = blist.get(bidx);
				int rval = rlist.get(ridx);
				if(bval <= rval) {
					bans.add(cnt++);
					bidx++;
				}
				else {
					rans.add(cnt++);
					ridx++;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(bans.size()).append("\n");
		for(int i=0;i<bans.size();i++) sb.append(bans.get(i)).append(" ");
		sb.append("\n").append(rans.size()).append("\n");
		for(int i=0;i<rans.size();i++) sb.append(rans.get(i)).append(" ");
		System.out.println(sb.toString());
	}
}
