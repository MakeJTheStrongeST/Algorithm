package algoweek4.ssafy.day2;

import java.io.*;
import java.util.*;

public class 냉장고 {
	static BufferedReader br;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		p[] arr = new p[n];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr[i] = new p(a,b);
		}
		Arrays.sort(arr);
		
		int end = -100000;
		int ans = 0;
		for(int i=0;i<n;i++) {
			if(arr[i].s <= end) {
				end = Math.min(end, arr[i].e);
			}
			else {
				ans++;
				end = arr[i].e;
			}
		}
		System.out.println(ans);
	}
	
	static class p implements Comparable<p>{
		int s,e;
		public p(int s,int e) {
			this.s = s;
			this.e = e;
		}
		@Override
		public int compareTo(p o) {
			return this.s == o.s ? o.e - this.e : this.s - o.s;
		}
	}
}
