import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {
    
	static int N = 19;
	static int[][] omock;
	static int lMax;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		omock = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				omock[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		fo: for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (omock[i][j] == 1)
					if (winnerCheck(i, j, 1)) {
						if (lMax == 2) {
							System.out.println((i + 5) + " " + (j - 3));
							return;
						}
						System.out.println((i + 1) + " " + (j + 1));
						return;
					}
				if (omock[i][j] == 2)
					if (winnerCheck(i, j, 2)) {
						if (lMax == 2) {
							System.out.println((i + 5) + " " + (j - 3));
							return;
						}
						System.out.println((i + 1) + " " + (j + 1));
						return;
					}
			}
		}
		System.out.println("0");
	}

	static int[] dx = { 0, 1, 1, 1 };
	static int[] dy = { 1, 0, -1, 1 };
    
	static int[] _dx = { 0, -1, -1, -1 };
	static int[] _dy = { -1, 0, 1, -1 };
	static boolean winnerCheck(int i, int j, int num) {
		for (int k = 0; k < 4; k++) {
			int _nx = i + _dx[k];
			int _ny = j + _dy[k];
			if (_nx < 0 || _ny < 0 || _nx >= N || _ny >= N || omock[_nx][_ny] != num) {// 진행
				int cnt = 1;
				for (int l = 1; l < 5; l++) {
					int nx = i + dx[k] * l;
					int ny = j + dy[k] * l;
					if (nx < 0 || ny < 0 || nx >= N || ny >= N)
						break;
					if (omock[nx][ny] == num)
						cnt++;
				}
				if (cnt == 5) {
					int nx = i + dx[k] * 5;
					int ny = j + dy[k] * 5;
					if (nx < 0 || ny < 0 || nx >= N || ny >= N || omock[nx][ny] != num) {
						System.out.println(num);
						lMax = k;
						return true;
					}
				}
			}
		}
		return false;
	}
}