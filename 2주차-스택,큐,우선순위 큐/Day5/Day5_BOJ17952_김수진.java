package SsafyStudy.Stack_Queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj_17952_과제는 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int minutes = Integer.parseInt(br.readLine());
        Stack<Pair> stack = new Stack<>();
        int sum = 0;
        for(int i=1; i<=minutes; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            if(st.nextToken().charAt(0)=='1'){
                int grade = Integer.parseInt(st.nextToken());
                int time = Integer.parseInt(st.nextToken());
                time--;
                if(time<=0) sum+= grade;
                else stack.push(new Pair(time, grade));
            }else{
                if(stack.isEmpty()) continue;
                Pair p = stack.pop();
                p.time--;
                if(p.time<=0){
                    sum += p.grade;
                }else{
                    stack.push(p);
                }
            }

        }
        System.out.println(sum);
    }

    static class Pair {
        int time;
        int grade;
        Pair(int time, int grade){
            this.time = time;
            this.grade = grade;
        }
    }
}
