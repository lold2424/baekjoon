import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int N, M, answer;
	static int[][] maze;
	static int[][][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] dimensions = br.readLine().split(" ");

		N = Integer.parseInt(dimensions[0]);
		M = Integer.parseInt(dimensions[1]);

		answer = Integer.MAX_VALUE;

		maze = new int[N + 1][M + 1];
		visited = new int[N + 1][M + 1][2];

		for (int i = 1; i <= N; i++) {
			String row = br.readLine();
			for (int j = 1; j <= M; j++) {
				maze[i][j] = row.charAt(j - 1) - '0';
			}
		}

		if (N == 1 && M == 1) {
			answer = 1;
		} else {
			bfs();
		}

		if (answer == Integer.MAX_VALUE) {
			answer = -1;
		}

		System.out.println(answer);
	}

	static void bfs() {
		int[] dx = {1, 0, -1, 0};
		int[] dy = {0, 1, 0, -1};
		Queue<int[]> queue = new LinkedList<>();

		queue.offer(new int[]{1, 1, 1, 0});
		visited[1][1][0] = 1;

		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int x = current[0];
			int y = current[1];
			int steps = current[2];
			int mode = current[3];

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx > 0 && nx <= N && ny > 0 && ny <= M) {
					if (x == N && y == M) {
						answer = Math.min(answer, steps);
						return;
					}

					if (mode == 0) {
						if (visited[nx][ny][0] == 0) {
							if (maze[nx][ny] == 0) {
								visited[nx][ny][0] = 1;
								queue.offer(new int[]{nx, ny, steps + 1, 0});
							} else if (maze[nx][ny] == 1) {
								visited[nx][ny][0] = 1;
								queue.offer(new int[]{nx, ny, steps + 1, 1});
							}
						}
					} else if (visited[nx][ny][1] == 0 && maze[nx][ny] == 0) {
						visited[nx][ny][1] = 1;
						queue.offer(new int[]{nx, ny, steps + 1, 1});
					}
				}
			}
		}
	}
}
