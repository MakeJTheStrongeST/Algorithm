import java.util.Stack;

public class Day4_Programmers_크레인인형뽑기게임_박원석 {
	public static void main(String[] args) {
		int[][] board = { { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 3 }, { 0, 2, 5, 0, 1 }, { 4, 2, 4, 4, 2 }, { 3, 5, 1, 3, 1 } };
		int[] moves = { 1, 5, 3, 5, 1, 2, 1, 4 };

		System.out.println(Solution.solution(board, moves));
	}
}

class Solution {
	public static int solution(int[][] board, int[] moves) {
		int answer = 0;
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < moves.length; i++) {
			int column = moves[i] - 1;

			for (int j = 0; j < board.length; j++) {
				if (board[j][column] > 0) {
					if (!stack.isEmpty() && stack.peek() == board[j][column]) {
						answer += 2;
						stack.pop();
					} else {
						stack.push(board[j][column]);
					}
					board[j][column] = 0;
					break;
				}
			}
		}

		return answer;
	}
}
