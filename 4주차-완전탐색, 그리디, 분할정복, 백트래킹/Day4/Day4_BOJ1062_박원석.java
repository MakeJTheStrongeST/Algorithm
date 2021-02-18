package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Day4_BOJ1062_박원석 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, K;
	static int cnt = 0; // a, n, t, i, c 를 제외하고 더 필요한 알파벳 개수

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		// a, n, t, i, c 는 필수이므로 5개 이하의 알파벳만 가르치면 모든 단어 알 수 없음
		if (K < 5) {
			System.out.println(0);
			return;
		}

		boolean[] ch = new boolean[26]; // 입력에서 제시된 알파벳만 true
		// a, n, t, i, c 는 필수
		ch['a' - 'a'] = true;
		ch['n' - 'a'] = true;
		ch['t' - 'a'] = true;
		ch['i' - 'a'] = true;
		ch['c' - 'a'] = true;

		// 단어 입력
		ArrayList<Character> needAlphabet = new ArrayList<>(); // a, n, t, i, c 말고도 더 필요한 알파벳 목록
		ArrayList<String> wordList = new ArrayList<>(); // 남극 단어 목록 ('anta', 'tica'는 필수이므로 제외시켜 저장)
		for (int i = 0; i < N; i++) {
			String word = in.readLine();
			int wordLen = word.length();
			word = word.substring(4, wordLen - 4);
			wordList.add(word);
			for (int j = 0, len = wordLen - 8; j < len; j++) {
				char c = word.charAt(j);
				if (!ch[c - 'a']) { // 아직 목록에 추가하지 않은 알파벳
					ch[c - 'a'] = true;
					needAlphabet.add(c);
					cnt++;
				}
			}
		}

		// 필요한 알파벳보다 더 많은 알파벳을 알려주면 모든 단어를 알 수 있음
		if (K > cnt + 5) {
			System.out.println(N);
			return;
		}
		
		// K는 5, 단어는 antatica밖에 없는 상황
		if(cnt == 0) {
			System.out.println(1);
			return;
		}

		// 필요한 알파벳들 중에서만 조합으로 완전탐색해본다
		int answer = 0; // 읽을 수 있는 단어 개수 최대값
		int[] P = new int[cnt]; // 조합을 위한 flag 배열
		for(int i = 0; i < K - 5; i++) P[cnt - 1 - i] = 1;
		do {
			boolean[] ch2 = new boolean[26]; // 현재 경우에서 가르친 알파벳은 true
			ch2['a' - 'a'] = true;
			ch2['n' - 'a'] = true;
			ch2['t' - 'a'] = true;
			ch2['i' - 'a'] = true;
			ch2['c' - 'a'] = true;
			for (int i = 0; i < cnt; i++) {
				if (P[i] == 1) {
					ch2[needAlphabet.get(i) - 'a'] = true;
				}
			}
			
			int cnt = 0; // 읽을 수 있는 단어 개수
			for(int i = 0; i < N; i++) {
				boolean readable = true;
				for(int j = 0, len = wordList.get(i).length(); j < len; j++) {
					if(!ch2[wordList.get(i).charAt(j) - 'a']) {
						readable = false;
						break;
					}
				}
				if(readable) cnt++;
			}
			
			answer = Math.max(answer, cnt);
		} while(nextPermutation(P));
		
		System.out.println(answer);
	}

	private static boolean nextPermutation(int[] p) {
		int i = cnt - 1;
		while (i > 0 && p[i - 1] >= p[i]) --i;

		if (i == 0) return false;
		
		int j = cnt - 1;
		while(p[i - 1] >= p[j]) --j;
		
		swap(p, i - 1, j);
		
		int k = cnt - 1;
		while(i < k) {
			swap(p, i++, k--);
		}
		return true;
	}
	
	private static void swap(int[] p, int i, int j) {
		int tmp = p[i];
		p[i] = p[j];
		p[j] = tmp;
	}
}
