package com.ssafy.hw;

import java.util.Scanner;

public class BOJ_17478 {
	static Scanner sc = new Scanner(System.in);
	static int N;
	static StringBuilder sb = new StringBuilder("��� �� ��ǻ�Ͱ��а� �л��� ������ �������� ã�ư� ������.\n");
	
	public static void main(String[] args) {
		N = sc.nextInt();
		
		recursive(0);
		
		System.out.println(sb.toString());
	}
	
	static void recursive(int cnt) {
		sbAppend(cnt, "\"����Լ��� ������?\"\n");
		
		if(cnt == N) {
			sbAppend(cnt, "\"����Լ��� �ڱ� �ڽ��� ȣ���ϴ� �Լ����\"\n");
		} else {
			sbAppend(cnt, "\"�� ����. �������� �� �� ����⿡ �̼��� ��� ������ ����� ������ �־���.\n");
			sbAppend(cnt, "���� ������� ��� �� ���ο��� ������ ������ �߰�, ��� �����Ӱ� ����� �־���.\n");
			sbAppend(cnt, "���� ���� ��κ� �ǾҴٰ� �ϳ�. �׷��� ��� ��, �� ���ο��� �� ���� ã�ƿͼ� ������.\"\n");
			recursive(cnt + 1);
		}
		
		sbAppend(cnt, "��� �亯�Ͽ���.\n");
	}
	
	static void sbAppend(int cnt, String str) {
		for(int i = 0; i < 4 * cnt; i++) sb.append("_");
		sb.append(str);
	}
}
