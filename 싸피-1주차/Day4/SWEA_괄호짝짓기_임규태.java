import java.io.*;
import java.util.*;
 
public class Solution {
    static BufferedReader br;
 
    static Map<Character,Integer> mp = new HashMap<Character,Integer>();
    public static void main(String[] args) throws IOException {
        mp.put('[', 1);
        mp.put(']', -1);
        mp.put('(', 2);
        mp.put(')', -2);
        mp.put('<', 3);
        mp.put('>', -3);
        mp.put('{', 4);
        mp.put('}', -4);
        br  = new BufferedReader(new InputStreamReader(System.in));
         
        for(int i=1;i<=10;i++) {
            System.out.print("#"+i+" ");
            System.out.println(solve(i)==true?1:0);
        }
    }
     
    static boolean solve(int tc) throws NumberFormatException, IOException {
        int n = Integer.parseInt(br.readLine());
        char[] in = br.readLine().toCharArray();
        Stack<Character> st = new Stack();
 
        boolean ans = true;
        for(char c : in) {
            int top = 0;
            if(!st.isEmpty()) top = mp.get(st.peek().charValue());
            int cur = mp.get(c);
            switch(Math.abs(cur)) {
            case 1:
                if(cur == 1) st.add(c);
                else {
                    if(st.isEmpty() || top != 1) {ans = false; break;}
                    st.pop();
                }
                break;
            case 2:
                if(cur == 2) st.add(c);
                else {
                    if(st.isEmpty() || top != 2) {ans = false; break;}
                    st.pop();
                }
                break;
            case 3:
                if(cur == 3) st.add(c);
                else {
                    if(st.isEmpty() || top != 3) {ans = false; break;}
                    st.pop();
                }
                break;
            case 4:
                if(cur == 4) st.add(c);
                else {
                    if(st.isEmpty() || top != 4) {ans = false; break;}
                    st.pop();
                }
                break;
            }
             
            if(!ans) break;
        }
         
        if(!st.isEmpty()) ans = false;
         
        return ans;
    }
}
