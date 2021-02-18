import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br;
	static StringTokenizer st;

	static int n,k,ans,subans,plus,size,pos;
	static String[] arr = new String[50];
	static boolean[] chk = new boolean[26];
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<n;i++) {
			arr[i] = br.readLine();
			arr[i] = arr[i].substring(4,arr[i].length()-4);
		}

		
		k -= 5;
		for(int i=0;i<26;i++) {
			char c = (char)(i+'a');
			if(c == 'a' || c == 'n' || c == 't' || c == 'i' || c == 'c') {
				chk[i] = true;
			}
		}
		
		if(k >= 0) {
			f(0,0);
		}
		System.out.println(ans);
	}
	
	static void f(int idx,int cnt) {
		if(cnt == k) {
            subans = 0;
    		for(int i=0;i<n;i++) {
	    		plus = 1;
	    		for(int j=0;j<arr[i].length();j++) {
			    	if(!chk[arr[i].charAt(j)-'a']) {
				    	plus = 0;
				    	break;
				    }
			    }
			    subans += plus;
		    }
            ans = ans < subans ? subans : ans;
			return;
		}
		
		for(int i=idx;i<26;i++) {
			if(chk[i]) continue;
			chk[i] = true;
			f(i+1,cnt+1);
			chk[i] = false;
		}
	}
}
