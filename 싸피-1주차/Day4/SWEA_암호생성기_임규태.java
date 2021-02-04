import java.io.*;
import java.util.*;
 
public class Solution {
    static BufferedReader br;
    static StringTokenizer st;
 
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=1;i<=10;i++) {
            br.readLine();
            solve(i);
        }
    }
     
    static void solve(int tc) throws IOException {
        int[] ans = new int[8];
        st = new StringTokenizer(br.readLine());
         
        for(int i=0;i<8;i++) {
            ans[i] = Integer.parseInt(st.nextToken());
        }
         
        int cnt = 1;
        int idx = 0;
        while(true) {
            ans[idx] -= cnt;
            ans[idx] = Math.max(0, ans[idx]);
             
            cnt++;
            cnt = cnt > 5 ? 1 : cnt;
             
            if(ans[idx] == 0) {idx++; break;}
             
            idx++;
            idx &= 7;
        }
         
        StringBuilder sb = new StringBuilder();
        sb.append("#").append(tc).append(" ");
        for(int i=0;i<8;i++) {
            sb.append(ans[((idx+i)&7)]).append(" ");
        }
        System.out.println(sb.toString());
    }
}
