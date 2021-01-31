package SsafyStudy.Bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1107_리모콘 {
    static int start = 100;
    static String sdist;
    static int dist;
    static int length;
    static int answer;
    static boolean[] remote = new boolean[10]; //0 1 2 3 4 5 6 7 8 9
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sdist= st.nextToken();
        dist= Integer.parseInt(sdist);
        length = sdist.length();

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            remote[Integer.parseInt(st.nextToken())] = true;
        }

        answer = Math.abs(dist-start);
        if(answer==0){
            System.out.println(0);
            return;
        }

        for(int i=0; i<10; i++){
            if(!remote[i]) solve(i,1);
        }

        System.out.println(answer);
    }

    static void solve(int num, int len){
        if(length+1<len) { //예외케이스 목적지 길이보다 입력길이가 더 적고 +로 올라가는게 빠를 수 있다. (9999 1 9)
            return;
        }
        answer = Math.min(answer, Math.abs(dist-num)+len);
        for(int i=0; i<10; i++){
            if(!remote[i]) solve(num*10+i, len+1);
        }
    }
}
