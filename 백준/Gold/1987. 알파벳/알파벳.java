import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int r;
	static int c;
	static int map[][] = new int[20][20];
	static int cnt = 1;
	static int ans = 1;
	static int dx[] = {-1, 0, 1, 0};
	static int dy[] = {0, -1, 0, 1};

	static boolean[] visited = new boolean[26];

	public static void dfs(int y, int x) {
		int idx = map[y][x];
		visited[idx] = true;

		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];

			if (-1 < nx && nx < c && -1 < ny && ny < r) {
				int next = map[ny][nx];

				if (!visited[next]) {
					ans = Math.max(++cnt, ans);
					dfs(ny, nx);
				}
			}
		}
		--cnt;
		visited[idx] = false;
	}

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		String line;
		for (int i = 0; i < r; i++) {
			line = br.readLine();
			for (int j = 0; j < c; j++)
				map[i][j] = (int) line.charAt(j);
		}

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				map[i][j] = (char) (map[i][j] - 'A');
			}
		}
		dfs(0, 0);
		System.out.print(ans);
	}
}
