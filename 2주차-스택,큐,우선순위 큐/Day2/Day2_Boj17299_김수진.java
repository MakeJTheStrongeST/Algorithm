package SsafyStudy.Bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj_17299_오등큰수 {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Stack<Integer> stack = new Stack<>();
        int[] cnt = new int[1000001];
        int[] arr = new int[n];
        int[] answer = new int[n];

        for(int i=0; i<n; i++){
            int tmp = Integer.parseInt(st.nextToken());
            arr[i] = tmp;
            cnt[tmp]++;
        }

        StringBuilder sb = new StringBuilder();

        for(int i=n-1; i>=0; i--){
            while(!stack.empty() && cnt[stack.peek()]<=cnt[arr[i]]){
                //어차피 나보다 작으면 그 앞에서 선택될 일 없으니 삭제한다
                stack.pop();
            }


            if(stack.empty()) answer[i]=-1; //sb.insert(0," "+ -1);
            else answer[i] = stack.peek(); //sb.insert(0," "+ stack.peek());

            stack.push(arr[i]);
        }
        //sb.deleteCharAt(0);
        for(int i=0; i<n; i++){
            sb.append(answer[i] + " ");
        }
        System.out.println(sb.toString());

    }
}
