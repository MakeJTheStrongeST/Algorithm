package com.algorithm.d0201;

import java.util.Arrays;
import java.util.Scanner;

public class BattleField {
	static char[][] map;
	static int w,h;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = Integer.parseInt(sc.nextLine());
		
		for(int i =1; i<=TC;i++) {
			String[] str = sc.nextLine().split(" ");
			h = Integer.parseInt(str[0]);
			w = Integer.parseInt(str[1]);

			map = new char[h][w];
			for(int j =0; j<h;j++) {
				String str2 = sc.nextLine();
				for(int k =0; k<w;k++) {
					map[j][k] = str2.charAt(k);
				}
			}
//			for(int j =0; j<h;j++) {
//				for(int k =0; k<w;k++) {
//					System.out.print(map[j][k]+" ");
//				}
//				System.out.println();
//			}
			int cmdNum = Integer.parseInt(sc.nextLine());
			char[] commands = new char[cmdNum];
			String str3 = sc.nextLine();
			for(int j =0; j<cmdNum;j++) {
				commands[j] = str3.charAt(j);
			}
//			System.out.println(Arrays.toString(commands));
			//do something
			for(int j =0; j<cmdNum;j++) {
				play(commands[j]);
			}
			
			//출력
			System.out.print("#"+i+" ");
			for(int j =0; j<h;j++) {
				for(int k =0; k<w;k++) {
					System.out.print(map[j][k]);
				}
				System.out.println();
			}
		}
	}
	private static void play(char cmd) {
		//전차 위치찾는다
		int x=0,y=0;
		
		char dir=' ';
		for(int j =0; j<h;j++) {
			for(int k =0; k<w;k++) {
				if(map[j][k]=='<') {
					x=k;
					y=j;
					dir = 'L';
					break;
				}else if(map[j][k]=='>') { 
					x=k;
					y=j;
					dir = 'R';
					break;
				}else if(map[j][k]=='v') {
					x=k;
					y=j;
					dir = 'D';
					break;
				}else if(map[j][k]=='^') {
					x=k;
					y=j;
					dir = 'U';
					break;
				}
			}
		}
//		System.out.println("x: "+x+", y: "+y);
		//커맨드에 따라 명령 수행
		switch(cmd) {
		case 'U':
			//이동방향 평지 아니면 nothing
			if(y-1>=0 && map[y-1][x] == '.'  ) {
				map[y-1][x] = '^';
				map[y][x] = '.';
			}else {
				map[y][x] = '^';
			}
			break;
		case 'D':
			if(y+1<h && map[y+1][x] == '.' ) {
				map[y+1][x] = 'v';
				map[y][x] = '.';
			}else {
				map[y][x] = 'v';
			}
			break;
		case 'L':
			if( x-1>=0 && map[y][x-1] == '.'  ) {
				map[y][x-1] = '<';
				map[y][x] = '.';
			}else {
				map[y][x] = '<';
			}
			break;
		case 'R':
			if(x+1<w && map[y][x+1] == '.'  ) {
				map[y][x+1] = '>';
				map[y][x] = '.';
			}else {
				map[y][x] = '>';
			}
			break;
		case 'S':
			//기존 방향이 필요함
			//만일 발사 방향에 벽 있으면 평지로바뀜, 포탄 소멸됨(유의)
			if(dir=='R') {
				for(int i =x+1;i<w;i++) {
					if(map[y][i] == '#') { //강철벽에 부딪쳐도 소멸되는 걸 놓침
						break;
					}else if(map[y][i] == '*') {
						map[y][i] = '.';
						break;
					}
				}
			}else if(dir=='L') {
				for(int i =x-1;i>=0;i--) {
					if(map[y][i] == '#') {
						break;
					}if(map[y][i] == '*') {
						map[y][i] = '.';
						break;
					}
				}
				
			}else if(dir=='U') {
				for(int i =y-1;i>=0;i--) {
					if(map[i][x] == '#') {
						break;
					}if(map[i][x] == '*') {
						map[i][x] = '.';
						break;
					}
				}
				
			}else if(dir=='D') {
				for(int i =y+1;i<h;i++) {
					if(map[i][x] == '#') {
						break;
					}if(map[i][x] == '*') {
						map[i][x] = '.';
						break;
					}
				}
				
			}
			break;
		default:
			break;
		}
//		System.out.println("after "+cmd);
//		for(int j =0; j<h;j++) {
//			for(int k =0; k<w;k++) {
//				System.out.print(map[j][k]);
//			}
//			System.out.println();
//		}
	}

}
