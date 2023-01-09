import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int[][] A, B;
	static boolean flag = true;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M= Integer.parseInt(st.nextToken());
		
		A = new int[N][M];
		B = new int[N][M];
		
		for (int i = 0; i < N; i ++) {
			String str = br.readLine();
			
			for (int j = 0; j < M; j ++) {
				A[i][j] = str.charAt(j) - '0';
			}
		}
		for (int i = 0; i < N; i ++) {
			String str = br.readLine();
			
			for (int j = 0; j < M; j ++) {
				B[i][j] = str.charAt(j) - '0';
			}
		}
		
		int count = 0;
		
		for (int i = 0; i <= N - 3; i ++) {
			for (int j = 0; j <= M - 3; j ++) {
				if (A[i][j] != B[i][j]) {
					count ++;
					for (int p = i; p < i + 3; p ++) {
						for (int q = j; q < j + 3; q ++) {
							A[p][q] = (A[p][q] == 0) ? 1 : 0;
						}
					}
				}
			}
		}
		
		for (int i = 0; i < N; i ++) {
			for (int j = 0; j < M; j ++) {
				if (A[i][j] != B[i][j]) {
					flag = false;
					break;
				}
			}
		}
		
		System.out.println((flag) ? count : -1);
	}
}