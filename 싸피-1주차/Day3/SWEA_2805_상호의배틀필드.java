import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2805_상호의배틀필드 {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int T, H, W, N, nx, ny;
	static char[][] map;
	static String command;
	static Tank tank;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(in.readLine());

		for (int i = 1; i <= T; i++) {
			// 입력
			st = new StringTokenizer(in.readLine(), " ");
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new char[H][W];
			for (int j = 0; j < H; j++) {
				String tmp = in.readLine();
				for (int k = 0; k < W; k++) {
					map[j][k] = tmp.charAt(k);
					if (map[j][k] == '^') {
						tank = new Tank(k, j, 0);
					} else if (map[j][k] == '>') {
						tank = new Tank(k, j, 1);
					} else if (map[j][k] == 'v') {
						tank = new Tank(k, j, 2);
					} else if (map[j][k] == '<'){
						tank = new Tank(k, j, 3);
					}
				}
			}
			N = Integer.parseInt(in.readLine());
			command = in.readLine();

			// 명령 실행
			for (int j = 0; j < N; j++) {
				char cm = command.charAt(j);

				if (cm == 'U' || cm == 'R' || cm == 'D' || cm == 'L') {
					if (cm == 'U') {
						tank.dir = 0;
						map[tank.y][tank.x] = '^';
					} else if (cm == 'R') {
						tank.dir = 1;
						map[tank.y][tank.x] = '>';
					} else if (cm == 'D') {
						tank.dir = 2;
						map[tank.y][tank.x] = 'v';
					} else if (cm == 'L') {
						tank.dir = 3;
						map[tank.y][tank.x] = '<';
					}
					
					nx = tank.x + dx[tank.dir];
					ny = tank.y + dy[tank.dir];
					
					if(nx >= 0 && ny >= 0 && nx < W && ny < H) {
						if(map[ny][nx] == '.') {
							char tmp = map[tank.y][tank.x];
							map[tank.y][tank.x] = map[ny][nx];
							map[ny][nx] = tmp;
							tank.x = nx;
							tank.y = ny;
						}
					}
				} else {
					nx = tank.x + dx[tank.dir];
					ny = tank.y + dy[tank.dir];
					
					while(nx >= 0 && ny >= 0 && nx < W && ny < H) {
						if(map[ny][nx] == '*') {
							map[ny][nx] = '.';
							break;
						} else if(map[ny][nx] == '#') {
							break;
						}
						nx += dx[tank.dir];
						ny += dy[tank.dir];
					}
				}
			}

			// 결과 출력
			sb.append("#").append(i).append(" ");
			for (int j = 0; j < H; j++) {
				for (int k = 0; k < W; k++) {
					sb.append(map[j][k]);
				}
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());
	}
}

class Tank {
	int x, y, dir;

	Tank(int x, int y, int dir) {
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
}
