package SsafyStudy.Bruteforce;

import java.io.*;
import java.util.*;

public class Boj_14697_방배정하기 {

    static int n1,n2,n3,students;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n1 = Integer.parseInt(st.nextToken());
        n2 = Integer.parseInt(st.nextToken());
        n3 = Integer.parseInt(st.nextToken());
        students = Integer.parseInt(st.nextToken());

        System.out.println(solve());
    }
    static int solve(){
        int max = students/n1;
        for(int i=0; i<=100; i++){
            for(int j=0; j<=100; j++){
                for(int k=0; k<=100; k++){
                    if((k*n3+j*n2+i*n1)==students) return 1;
                }
            }
        }
        return 0;
    }
}
