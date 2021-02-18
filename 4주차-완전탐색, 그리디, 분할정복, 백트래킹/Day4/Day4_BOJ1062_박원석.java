package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Day4_BOJ1062_�ڿ��� {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, K;
	static int cnt = 0; // a, n, t, i, c �� �����ϰ� �� �ʿ��� ���ĺ� ����

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		// a, n, t, i, c �� �ʼ��̹Ƿ� 5�� ������ ���ĺ��� ����ġ�� ��� �ܾ� �� �� ����
		if (K < 5) {
			System.out.println(0);
			return;
		}

		boolean[] ch = new boolean[26]; // �Է¿��� ���õ� ���ĺ��� true
		// a, n, t, i, c �� �ʼ�
		ch['a' - 'a'] = true;
		ch['n' - 'a'] = true;
		ch['t' - 'a'] = true;
		ch['i' - 'a'] = true;
		ch['c' - 'a'] = true;

		// �ܾ� �Է�
		ArrayList<Character> needAlphabet = new ArrayList<>(); // a, n, t, i, c ���� �� �ʿ��� ���ĺ� ���
		ArrayList<String> wordList = new ArrayList<>(); // ���� �ܾ� ��� ('anta', 'tica'�� �ʼ��̹Ƿ� ���ܽ��� ����)
		for (int i = 0; i < N; i++) {
			String word = in.readLine();
			int wordLen = word.length();
			word = word.substring(4, wordLen - 4);
			wordList.add(word);
			for (int j = 0, len = wordLen - 8; j < len; j++) {
				char c = word.charAt(j);
				if (!ch[c - 'a']) { // ���� ��Ͽ� �߰����� ���� ���ĺ�
					ch[c - 'a'] = true;
					needAlphabet.add(c);
					cnt++;
				}
			}
		}

		// �ʿ��� ���ĺ����� �� ���� ���ĺ��� �˷��ָ� ��� �ܾ �� �� ����
		if (K > cnt + 5) {
			System.out.println(N);
			return;
		}
		
		// K�� 5, �ܾ�� antatica�ۿ� ���� ��Ȳ
		if(cnt == 0) {
			System.out.println(1);
			return;
		}

		// �ʿ��� ���ĺ��� �߿����� �������� ����Ž���غ���
		int answer = 0; // ���� �� �ִ� �ܾ� ���� �ִ밪
		int[] P = new int[cnt]; // ������ ���� flag �迭
		for(int i = 0; i < K - 5; i++) P[cnt - 1 - i] = 1;
		do {
			boolean[] ch2 = new boolean[26]; // ���� ��쿡�� ����ģ ���ĺ��� true
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
			
			int cnt = 0; // ���� �� �ִ� �ܾ� ����
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
