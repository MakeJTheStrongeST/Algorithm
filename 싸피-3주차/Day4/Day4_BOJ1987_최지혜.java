import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int R,C;
    static char[][] map;
    static boolean[][] isVisited;
    static boolean[] isUsed;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][];
        isVisited = new boolean[R][C];
        isUsed = new boolean[26];
        for(int i=0;i<R;i++) {
            map[i] = br.readLine().toCharArray();
        }
        System.out.println(dfs(0,0));
    }
    static int dr[] = {-1,1,0,0};
    static int dc[] = {0,0,-1,1};
    private static int dfs(int r, int c) {
        isVisited[r][c] = true;
        isUsed[map[r][c]-65] = true;
        int nr,nc,res=0;
        for(int d=0; d<4; d++) {
            nr = r + dr[d];nc = c + dc[d];
            if(nr>=0 && nr<R && nc>=0 && nc<C && !isVisited[nr][nc] && !isUsed[map[nr][nc]-65]) {
                res = Math.max(res, dfs(nr,nc));
            }
        } 
        isVisited[r][c] = false;
        isUsed[map[r][c]-65] = false;
        return res+1;
    }
}
