import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    static BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
 
    static int[] dy = {0,1,0,-1}, dx = {1,0,-1,0};
    static int n,cnt,LIMIT,dir,cury,curx;
    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        for(int i=1;i<=t;i++) solve(i);
    }
     
    static boolean isValid(int y, int x) {
        return y>=0 && y<n && x>=0 && x<n;
    }
     
    static void solve(int tc) throws NumberFormatException, IOException {
        n = Integer.parseInt(br.readLine());
        cnt = 1;
        LIMIT = n*n;
        dir = 0;
        cury = 0; curx = -1;
        int[][] ans = new int[n][n];
        while(cnt <= LIMIT) {
            int nxty = cury+dy[dir];
            int nxtx = curx+dx[dir];
            if(isValid(nxty,nxtx) && ans[nxty][nxtx] == 0) {
                ans[nxty][nxtx] = cnt++;
                cury = nxty;
                curx = nxtx;
            }
            else {
                dir++;
                dir &= 3;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("#").append(tc).append("\n");
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                sb.append(ans[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}
