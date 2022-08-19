import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int answer, R, C, N;
	static int dx[] = { 1, 0, -1, 0 };
	static int dy[] = { 0, 1, 0, -1 };
	static char map[][], cmap[][];

	static class Point {
		int y, x;

		public Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		int time = 1;
		map = new char[R][C];
		Queue<Point> q[] = new LinkedList[2];
		for (int i = 0; i < 2; i++) {
			q[i] = new LinkedList<>();
		}
        
		int idx = 0;
		for (int r = 0; r < R; r++) {
			char[] temp = br.readLine().toCharArray();
			for (int c = 0; c < C; c++) {
				map[r][c] = temp[c];
				if (map[r][c] == 'O') {
					q[idx].add(new Point(r, c));
				}
			}
		}

		idx++;
		cmap = make(map);
		while (N != 1 && true) {
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					if (map[r][c] == '.') {
						map[r][c] = 'O';
						q[idx].add(new Point(r, c));
					}
				}
			}
			if (++time == N)
				break;
			idx = idx == 1 ? 0 : 1;

			while (!q[idx].isEmpty()) {
				Point p = q[idx].poll();
				if (cmap[p.y][p.x] == '.')
					continue;
				map[p.y][p.x] = '.';
				for (int i = 0; i < dx.length; i++) {
					int ny = p.y + dy[i];
					int nx = p.x + dx[i];

					if (bound(ny, nx)) {
						map[ny][nx] = '.';
					}
				}
			} // while
			cmap = make(map);
			if (++time == N)
				break;
		}
		StringBuilder sb = new StringBuilder();
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				sb.append(map[r][c]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static char[][] make(char[][] map) {
		char cmap[][] = new char[R][C];
		for (int r = 0; r < R; r++) {
			cmap[r] = map[r].clone();
		}
		return cmap;
	}

	private static boolean bound(int ny, int nx) {
		if (ny >= R || nx >= C || ny < 0 || nx < 0)
			return false;
		return true;
	}
}