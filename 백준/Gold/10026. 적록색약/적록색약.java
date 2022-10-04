import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {
	static char arr[][];
	static boolean visit[][];
	static int dx[] = {-1, 1, 0, 0};
	static int dy[] = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		arr = new char[N][N];
		visit = new boolean[N][N];
		
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			for(int j = 0; j < N; j++) {
				arr[i][j] = s.charAt(j);
			}
		}
		
		int cnt = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visit[i][j]) {
					dfs(i, j);
					cnt ++;
				}
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(arr[i][j] == 'G') {
					arr[i][j] = 'R';
				}
			}
		}
		
		int nonBlindness = cnt;
		cnt = 0;
		visit = new boolean[N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visit[i][j]) {
					dfs(i, j);
					cnt ++;
				}
			}
		}
		
		System.out.printf("%d %d", nonBlindness, cnt);
	}
	
	public static void dfs(int x, int y) {
		visit[x][y] = true;
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx < 0 || ny < 0 || nx > visit.length -1 || ny > visit.length - 1) {
				continue;
			}
			
			if(!visit[nx][ny] && arr[nx][ny] == arr[x][y]) {
				dfs(nx, ny);
			}
		}
	}
}