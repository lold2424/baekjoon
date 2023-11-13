import java.util.LinkedList;

class Solution {
    
    static int answer = 0;
    
public static int solution(int[][] board, int[] moves) {
    	LinkedList<Integer> stack = new LinkedList<>();
    	
    	int cnt = 0;
    	
    	while(cnt <= moves.length - 1) {
			for (int i = 0; i < board.length; i++) {
				if (board[i][moves[cnt] - 1] != 0) {
					stack.push(board[i][moves[cnt] - 1]);
					if (stack.size() >= 2) {
						int stack1 = stack.get(0);
						int stack2 = stack.get(1);
						if (stack1 == stack2) {
							stack.pop();
							stack.pop();
							answer += 2;
						}
					}
					
					board[i][moves[cnt] - 1] = 0;
					break;
				}
			}
			cnt ++;
		}
    	return answer;
    }
}