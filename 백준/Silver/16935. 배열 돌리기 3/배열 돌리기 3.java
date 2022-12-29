import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	public static void main(String args[]) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	StringTokenizer st;
    	
    	st = new StringTokenizer(br.readLine());
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	int R = Integer.parseInt(st.nextToken());
    	
    	int[][] board = new int[N][M];
    	for (int i = 0; i < board.length; i++) {
    		st = new StringTokenizer(br.readLine());
    		for (int j = 0; j < board[i].length; j++)
    			board[i][j] = Integer.parseInt(st.nextToken());
    	}
    	
    	st = new StringTokenizer(br.readLine());
    	int[] commands = new int[R];
    	for (int i = 0; i < commands.length; i++)
    		commands[i] = Integer.parseInt(st.nextToken());
    	
    	for (int command: commands)
    		board = rotate(board, command);
    	
    	for (int i = 0; i < board.length; i++) {
    		for (int j = 0; j < board[i].length; j++)
    			sb.append(board[i][j]).append(" ");
    		sb.append("\n");
    	}
    	
    	System.out.println(sb.toString());
    }
	
	public static int[][] rotate(int[][] board, int command) {
		switch (command) {
		case 1:
			return flip(board, true);
		case 2:
			return flip(board, false);
		case 3:
			return rotate(board, true);
		case 4:
			return rotate(board, false);
		case 5:
			return blockRotate(board, true);
		case 6:
			return blockRotate(board, false);
		default:
			return board;
		}
	}
	
	public static void swap(int[][] board, int x1, int y1, int x2, int y2) {
		int temp = board[x1][y1];
		board[x1][y1] = board[x2][y2];
		board[x2][y2] = temp;
	}
	
	public static int[][] flip(int[][] board, boolean isUpDown) {
		int N = board.length;
		int M = board[0].length;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (isUpDown && i < N / 2) swap(board, i, j, N - 1 - i, j);
				else if (!isUpDown && j < M / 2) swap(board, i, j, i, M - 1 - j);
			}
		}
		return board;
	}
	
	public static int[][] rotate(int[][] board, boolean isRight) {
		int N = board.length;
		int M = board[0].length;
		int[][] newBoard = new int[M][N];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++) {
				if (isRight) newBoard[j][N - 1 - i] = board[i][j];
				else newBoard[M - 1 - j][i] = board[i][j];
			}
		return newBoard;
	}
	
	public static int[][] blockRotate(int[][] board, boolean isRight) {
		int N = board.length;
		int M = board[0].length;
		int[][] newBoard = new int[N][M];
		int[][] leftTop;
		if (isRight)
			leftTop = new int[][] {{0, 0}, {0, M / 2}, {N / 2, M / 2}, {N / 2, 0}, {0, 0}};
		else
			leftTop = new int[][] {{0, 0}, {N / 2, 0}, {N / 2, M / 2}, {0, M / 2}, {0, 0}};
		for (int i = 0; i < leftTop.length - 1; i++) {
			int fromTop = leftTop[i][0];
			int fromLeft = leftTop[i][1];
			int toTop = leftTop[i + 1][0];
			int toLeft = leftTop[i + 1][1];
			for (int j = 0; j < N / 2; j++)
				for (int k = 0; k < M / 2; k++)
					newBoard[toTop + j][toLeft + k] = board[fromTop + j][fromLeft + k];
		}
		return newBoard;
	}
}