package SsafyStudy.Stack_Queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_17225_세훈이 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        PriorityQueue<Pair> pq = new PriorityQueue<Pair>();

        int sTime = 1;
        int jTime = 1;
        int sangmin =0;
        int jisoo = 0;

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            char color = st.nextToken().charAt(0);
            int num = Integer.parseInt(st.nextToken());

            if(color=='B'){
                sangmin += num;
                if(time>sTime) sTime = time;
                while(num>0){
                    pq.offer(new Pair(sTime,'B'));
                    sTime += A;
                    num--;
                }
            }else{
                jisoo += num;
                if(time>jTime) jTime = time;
                while(num>0){
                    pq.offer(new Pair(jTime,'R'));
                    jTime += B;
                    num--;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        int num = 1;
        while(!pq.isEmpty()){
            Pair p =pq.poll();
            if(p.color=='B') sb.append(num+" ");
            else sb2.append(num+" ");
            num++;
        }

        System.out.println(sangmin);
        System.out.println(sb.toString());
        System.out.println(jisoo);
        System.out.println(sb2.toString());
    }


    static class Pair implements Comparable<Pair>{
        int time;
        char color;
        Pair(int time, char color){
            this.time = time;
            this.color = color;
        }

        public int compareTo(Pair p){
            if(this.time==p.time){
                return this.color - p.color;
            }
            return this.time-p.time;
        }
    }
}
