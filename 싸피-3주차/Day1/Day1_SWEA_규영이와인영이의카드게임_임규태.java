import java.io.*;
import java.util.*;
 
public class Solution {
    static BufferedReader br;
    static StringTokenizer st;
 
    static boolean[] kyu;
    static int ans1,ans2,sum1,sum2;
    static int[] kyuList,inList;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i=1;i<=t;i++) solve(i);
    }
     
    static void solve(int tc) throws IOException {
        kyu = new boolean[19];
        kyuList = new int[9];
        inList = new int[9];
        ans1 = ans2 = sum1 = sum2 = 0;
         
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<9;i++) {
            int cur = Integer.parseInt(st.nextToken());
            kyu[cur] = true;
            kyuList[i] = cur;
        }
        int idx = 0;
        for(int i=1;i<=18;i++) if(!kyu[i]) inList[idx++] = i;
         
        f(0,0);
        System.out.println("#"+tc+" "+ans1 + " " +ans2);
    }
     
    static void f(int cnt, int mask) {
        if(cnt == 9) {
            if(sum1 > sum2) {
                ans1++;
            }
            else if(sum1 < sum2) {
                ans2++;
            }
            return;
        }
         
        int subsum = 0;
        for(int i=0;i<9;i++) {
            if((mask&(1<<i)) == 0) {
                subsum = kyuList[cnt] + inList[i];
                if(kyuList[cnt] > inList[i]) {
                    sum1 += subsum;
                }
                else {
                    sum2 += subsum;
                }
                f(cnt+1,mask|1<<i);
                if(kyuList[cnt] > inList[i]) {
                    sum1 -= subsum;
                }
                else {
                    sum2 -= subsum;
                }
            }
        }
    }
}
