import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {
	
	static long[][] board;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		board = new long[N + 1][M + 1];
		
		int r = (K - 1) / M + 1;
		int c = (K - 1) % M + 1;
		
		for(int i = 1; i <= c; i++) {
			board[1][i] = 1;
		}
		
		for(int i = 1; i <= r; i++) {
			board[i][1] = 1;
		}
		
		for(int i = 1; i <= r; i++) {
			for(int j = 1; j <= c; j++) {
				if(board[i][j] == 0) {
					board[i][j] = board[i - 1][j] + board[i][j - 1];
				}
			}
		}
		
		for(int i = r; i <= N; i++) {
			for(int j = c; j <= M; j++) {
				if(board[i][j] > 0) {
					continue;
				}
				
				if (i > 0) {
					board[i][j] += board[i - 1][j];
				}
				
				if (j > 0) {
					board[i][j] += board[i][j - 1];
				}
			}
		}
		
		System.out.println(board[N][M]);
	}
}