import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class dot {
		int y,x;
		
		public dot(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
	static int y, x, ans;
	static int[][] map, copy;
	static int[] dx = {0, 0, -1, 1}, dy = {1, -1, 0, 0};
	static Queue<dot> q;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		y = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		
		map = new int[y][x];
		copy = new int [y][x];
		q = new LinkedList<>();
		
		for(int i = 0; i < y; i ++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < x; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
 
		makeWall(0, 0);
		System.out.println(ans);
	}
    
	public static void makeWall(int start, int depth) {
		if(depth == 3) {
			copy();
			spreadVirus();
			ans = Math.max(ans, countSafe());
			return;
		}
        
		for(int i = start; i < y * x; i++) {
			int dy = i / x;
			int dx = i % x;
			if(map[dy][dx] == 2 || map[dy][dx] == 1) continue;
			
			map[dy][dx] = 1;
			makeWall(i + 1, depth + 1);
			map[dy][dx] = 0;
		}
	}
    
	public static void spreadVirus() {
		while(!q.isEmpty()) {
			dot now = q.poll();
			for(int i = 0; i < 4; i ++) {
				int ny = now.y + dy[i];
				int nx = now.x + dx[i];
				
				if(ny >= 0 && ny < y && nx < x && nx >= 0) {
					if(copy[ny][nx] == 0) {
						copy[ny][nx] = 2;
						q.offer(new dot(ny, nx));
					}
				}
			}
		}
	}
    
	public static int countSafe() {
		int count = 0;
		for(int i = 0; i < y; i ++) {
			for(int j = 0; j < x; j ++) {
				if(copy[i][j] == 0) {
					count ++;
				}
			}
		}
		return count;
	}
    
	public static void copy() {
		for(int i = 0; i < y; i ++) {
			for(int j = 0; j < x; j ++) {
				copy[i][j] = map[i][j];
				if(copy[i][j] == 2) q.offer(new dot(i, j));
			}
		}
	}
}