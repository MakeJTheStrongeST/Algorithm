package SsafyStudy.Bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1057_토너먼트 {
    static int n;
    static int jm;
    static int hs;
    //서로 대결하지 않는 경우가 언제인가?
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        jm = Integer.parseInt(st.nextToken());
        hs = Integer.parseInt(st.nextToken());

        if(jm>hs){
            int tmp = hs;
            hs = jm;
            jm = tmp;
        }

        int round = 1;
        while(true){
            if(((hs-jm)==1)&&(jm%2==1)){
                break;
            }
            jm = jm/2 + jm%2;
            hs = hs/2 + hs%2;
            round++;
        }
        System.out.println(round);
    }
}
