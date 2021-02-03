import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    static BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
 
    static int[][] map = new int[15][15];
    static int n,m;
    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        for(int i=1;i<=t;i++) solve(i);
    }
     
    static void solve(int tc) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
         
        for(int i=0;i<n;i++) {
             
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
         
        int ans = 0;
        for(int i=0;i<=n-m;i++) {
            for(int j=0;j<=n-m;j++) {
                ans = Math.max(ans, calc(i,j));
            }
        }
        System.out.println("#"+tc+" "+ans);
    }
     
    static int calc(int cury,int curx) {
        int ret = 0;
        for(int i=0;i<m;i++) {
            for(int j=0;j<m;j++) {
                ret += map[cury+i][curx+j];
            }
        }
         
        return ret;
    }
}
