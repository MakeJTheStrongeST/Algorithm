package SsafyStudy.Bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_14629_숫자조각 {

    static int length;
    static long num;
    static long diff = Long.MAX_VALUE;
    static long answer = 0;
    static boolean[] number = new boolean[10]; //0 1 2 3 4 5 6 7 8 9

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String n = st.nextToken();
        length = n.length();

        if(length>10) {
            System.out.println("9876543210");
            return;
        }
        num = Long.parseLong(n);

        for(int i=1; i<10; i++){
            number[i] = true;
            solve(i,1);
            number[i] = false;
        }
        System.out.println(answer);
    }

    static void solve(long n, int len){
        if(length+1<len) {
           return;
       }

        if(diff>=Math.abs(num-n)){
            if(diff==Math.abs(num-n)){
                if(answer>n){
                    answer = n;
                }
            }else{
                answer = n;
                diff = Math.abs(num-n);
            }
        }

        for(int i=0; i<10; i++){
            if(!number[i]) {
                number[i] = true;
                solve(n*10+i, len+1);
                number[i] = false;
            }
        }
    }

}
