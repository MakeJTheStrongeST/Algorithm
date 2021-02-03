package SsafyStudy.Bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj_9012_괄호 {
    static char[] input;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++){
            input = br.readLine().toCharArray();
            System.out.println(solve() ? "YES" : "NO");
        }
    }
    static boolean solve(){
        Stack<Character> stack = new Stack<>();
        for(char c : input){
            if(c=='(') stack.push(c);
            if(c==')'){
                if(stack.size()!=0 && stack.peek()=='('){
                    stack.pop();
                }else return false;
            }
        }
        if(stack.size()!=0) return false;
        return true;
    }
}
