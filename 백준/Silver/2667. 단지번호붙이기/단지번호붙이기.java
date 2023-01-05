import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Arrays;

public class Main {
	
	static int[][] map;
	static int dx[] = {0, 0, 1, -1}, dy[] = {1, -1, 0, 0};
	static int[] apart = new int[25 * 25];
	static int N;
	static int apartNum = 0;
	static boolean[][] visited = new boolean[25][25];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		visited = new boolean[N][N];
		
		for(int i = 0; i < N; i++){
			String input = br.readLine();
			for(int j = 0; j < N; j++){
				map[i][j] = input.charAt(j) - '0';
			}
		}
		
		for(int i = 0; i < N; i++){
			for(int j = 0; j < N; j++){
				if(map[i][j] == 1 && !visited[i][j]){
					apartNum ++;
					dfs(i, j);
				}
			}
		}
		
		Arrays.sort(apart);
		System.out.println(apartNum);
		
		for(int i = 0; i < apart.length; i++){
			if(apart[i] == 0){
			} else{               
				System.out.println(apart[i]);
			}
		}
	}
	
	static void dfs(int x, int y) {
		visited[x][y] = true;
		apart[apartNum]++;
		
		for(int i = 0; i < 4; i++){
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx >= 0 && ny >= 0 && nx < N && ny < N){
				if(map[nx][ny] == 1 && !visited[nx][ny]){
					dfs(nx, ny);
				}
			}
		}
	}
}