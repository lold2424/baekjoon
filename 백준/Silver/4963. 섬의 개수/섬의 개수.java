import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
	static int arr[][];
	static boolean visit[][];
	static int dX[] = {0, 0, -1 ,1, -1, 1, -1, 1};
	static int dY[] = {-1, 1, 0, 0, 1, 1, -1, -1};
	static int w, h, nowX, nowY;

	static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		String str = " ";
		while( !(str = br.readLine()).equals("0 0") ) {
			st = new StringTokenizer(str);

			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			arr = new int[h][w];
			visit = new boolean[h][w];

			for(int i=0; i<h; i++) {
				st = new StringTokenizer(br.readLine());

				for(int j=0; j<w; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());

				}
			}

			int island_count = 0;
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					
					if(!visit[i][j] && arr[i][j] == 1) {
						BFS(i, j);
						island_count++;
					}
				}
			} 

			sb.append(island_count).append('\n');
		}

		System.out.println(sb);
	}
	
	static void BFS(int x, int y) {
		Queue<Node> que = new LinkedList<Node>();
		visit[x][y] = true;
		que.offer(new Node(x, y));
		
		while( !que.isEmpty() ) {
			Node node = que.poll();
		
			for(int i=0; i<8; i++) {
				nowX = dX[i] + node.x;
				nowY = dY[i] + node.y;

				if(range_check() && !visit[nowX][nowY] && arr[nowX][nowY] == 1) {
					visit[nowX][nowY] = true;
					que.offer(new Node(nowX, nowY));
				}
			}
		}
	}

	static boolean range_check() {
		return (nowX >= 0 && nowY >= 0 && nowX < h && nowY < w);
	}
}