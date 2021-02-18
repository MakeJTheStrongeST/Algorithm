/*가르침*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_1062 {
	static int N,K,ans,num,max=Integer.MIN_VALUE;
	static String[] words;
	static boolean[] dontknow;
	static List<Character> dontknow2;
	static char[] learn;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		words = new String[N];
		dontknow = new boolean[26];
		dontknow2 = new ArrayList<>();
		learn = new char[K];
		for(int i=0;i<N;i++) {
			words[i] = br.readLine();
		}
		//
		if(K<5) max=0;
		else go();
		//출력
		System.out.println(max);
	}

	private static void go() {	
		for(String w : words) {
			char[] cw = w.toCharArray();
			for(int i=4;i<cw.length-4;i++) {
				if(cw[i]!='a'&&cw[i]!='c'&&cw[i]!='i'&&cw[i]!='n'&&cw[i]!='t')
					dontknow[cw[i]-97]=true; 
			}
		}
		//true인것만
		for(int i=0;i<26;i++) {
			if(dontknow[i]) dontknow2.add((char)(i+97));
		} 
//		Iterator<Character> it = dontknow2.iterator();
//		while(it.hasNext()) System.out.print(it.next());
//		System.out.println();
		learn[0]='a';learn[1]='c';learn[2]='i';learn[3]='n';learn[4]='t';
		combi(5,0);
	}
	private static void combi(int cnt, int start) {
//		System.out.println("cnt: "+cnt);
		if(cnt==Math.min(K,5+dontknow2.size())) { //배울 알파벳 조합 생성 완료
//			System.out.println("조합생성완료: "+Arrays.toString(learn));
			read();
			max = Math.max(ans, max);
			return;
		}
		for(int i=start;i<dontknow2.size();i++) {
			learn[cnt] = dontknow2.get(i);
			combi(cnt+1,i+1);
		}
	}
	private static void read() {
//		System.out.println("Read");
		ans = N;
		for(String w : words) {
			char[] cw = w.toCharArray();
			Loop:for(int i=0;i<cw.length;i++) {
				for(int j=0;j<K;j++) {
					if(cw[i]==learn[j]) continue Loop; 		
				}
				System.out.println("cannot read "+cw[i]);
				ans--;	
				break Loop;
			}
		}
	}
}
