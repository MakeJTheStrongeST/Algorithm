import java.util.*;
import java.io.*;

class Day4_Programmers크레인인형뽑기_임규태 {
    static Queue<Integer>[] qlist = new LinkedList[31];
    static Stack<Integer> bucket = new Stack();
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(!(qlist[j+1] instanceof LinkedList)) qlist[j+1] = new LinkedList();
                if(board[i][j] > 0) qlist[j+1].add(board[i][j]);
            }
        }
        
        for(int move : moves){
            int selected = 0;
            if(!qlist[move].isEmpty()) selected = qlist[move].poll();
            if(!bucket.isEmpty() && bucket.peek() == selected){
                answer += 2;
                bucket.pop();
                selected = 0;
            }
            if(selected > 0) bucket.add(selected);
        }
        
        return answer;
    }
}
