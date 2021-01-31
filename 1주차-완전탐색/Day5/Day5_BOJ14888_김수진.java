package SsafyStudy.Bruteforce;

import java.io.*;
import java.util.*;

public class Boj_14888_연산자끼워넣기 {
    static int n;
    static int[] operand;
    static int[] operator;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        operand = new int[n];

        // input operand
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            operand[i] = Integer.parseInt(st.nextToken());
        }

        // input operator
        operator = new int[n-1];
        st = new StringTokenizer(br.readLine());
        int num = 0;
        for(int i=0; i<4; i++){
            int op = Integer.parseInt(st.nextToken());
            while(op>0){
                operator[num++] = i;
                op--;
            }
        }

        permutation(operator, 0);

        System.out.println(max);
        System.out.println(min);
    }

    //순열 공부하기
    static void permutation(int[] arr, int depth){
        if(depth==n-1){
            solve();
        }
        for(int i=depth; i<n-1; i++){
            swap(arr, depth,i);
            permutation(arr, depth+1);
            swap(arr,depth,i);
        }
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void solve(){
        int res = operand[0];
        for(int i=1; i<n; i++){
                int op = operator[i-1];
                if(op==0) res += operand[i];
                else if(op==1) res -=operand[i];
                else if(op==2) res *=operand[i];
                else res/=operand[i];
        }
        if(res>max) max = res;
        if(res<min) min = res;
    }

}
