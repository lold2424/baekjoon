import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main {
	
	static int[][] map;
	static int N, M;
	static int[] rectValue;
	static int[] dx = {1,0,-1,0}, dy = {0,1,0,-1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i = 0; i < N; i++){
			st = new StringTokenizer(br.readLine());
			int j = 0;
			while(st.hasMoreTokens()){
				map[i][j] = Integer.parseInt(st.nextToken());
				j++;
			}
		}
		rectValue = new int[101];
		rectValue[1] = 6;
		for(int i = 2, j = 1; i < 101; i++, j++){
			rectValue[i] = i*6 - (j*2);
		}
		int sum = 0;
		for(int i = 0; i < N; i++){
			for(int j = 0; j < M; j++){
				sum += rectValue[map[i][j]];
				sum -= implement(i,j);
			}
		}

		System.out.println(sum);
		
	}

	public static int implement(int x, int y){
		int sum = 0;
		for(int i = 0; i < 4; i++){
			int nextX = x + dx[i];
			int nextY = y + dy[i];

			if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) continue;
			if(map[x][y] > map[nextX][nextY]) sum += map[nextX][nextY];
			else sum += map[x][y];
		}
		return sum;
	}
}