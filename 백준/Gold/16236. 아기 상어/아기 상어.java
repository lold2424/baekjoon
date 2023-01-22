import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static int[][] map;
	static int N, cur_x, cur_y, answer = 0, cur_size = 2, cur_eaten = 0, left;
	static int[] dx = {-1,0,0,1}, dy = {0,-1,1,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		left = 0;
		
		for(int i = 0; i < N; i ++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j ++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					cur_x = i;
					cur_y = j;
					map[cur_x][cur_y] = 0;
				} else if(map[i][j] > 0)left ++;
			}
		}
		int temp;
		
		while(left != 0) {
			temp = left;
			bfs();
			if(temp == left) break;
		}
		
		System.out.println(answer);
	}
	
	static void bfs() {
		int x, y, nx, ny, depth;
		
		boolean[][] visited = new boolean[N][N];
		Queue<int[]> que = new LinkedList<int[]>();
		
		que.offer(new int[]{cur_x, cur_y, 1});
		visited[cur_x][cur_y] = true;
		
		int next_x = -1, next_y = -1;
		int next_depth = Integer.MAX_VALUE;
		
		while(!que.isEmpty()) {
			int[]temp = que.poll();
			x = temp[0];
			y = temp[1];
			depth = temp[2];
			
			if(next_depth < depth) {
				break;
			}
			
			for(int i = 0; i < 4; i ++) {
				nx = x + dx[i];
				ny = y + dy[i];
				
				if(nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && map[nx][ny] <= cur_size) {
					if(map[nx][ny] > 0 && cur_size > map[nx][ny]) {
						if(next_x == -1) {
							next_x = nx;
							next_y = ny;
							next_depth = depth;
						} else {
							if(next_x > nx) {
								next_x = nx;
								next_y = ny;
							} else if(next_x == nx) {
								if(next_y > ny) {
									next_x = nx;
									next_y = ny;
								}							
							}
						}
					}
					
					visited[nx][ny] = true;
					que.offer(new int[] {nx, ny, depth + 1});
				}
			}
		}
		
		if(next_x != -1) {
			map[next_x][next_y] = 0;
			answer += next_depth;
			left --;
			cur_x = next_x;
			cur_y = next_y;
			cur_eaten ++;
			
			if(cur_eaten == cur_size) {
				cur_eaten = 0;
				cur_size ++;
			}
		}
	}
}