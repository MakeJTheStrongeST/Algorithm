package SsafyStudy.Stack_Queue;

import java.util.*;

public class pro_크레인인형뽑기 {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> st = new Stack<>();
        
        for(int i=0; i<moves.length ; i++){
            int col = moves[i]-1;
            int doll=0;
            for(int row=0;row<board.length; row++){
                doll = board[row][col];
                if(doll!=0) {
                    board[row][col] = 0;
                    break;
                }
            }
            if(doll!=0){
                if(!st.isEmpty()&&doll==st.peek()){
                    st.pop();
                    answer += 2;
                }else{
                    st.push(doll);
                }
            }
        }
        return answer;
    }
}
