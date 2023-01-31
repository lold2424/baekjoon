import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int n, m, p1, p2;
	static int[][] map;
	static boolean[] visited;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		map = new int[n + 1][n + 1];
		visited = new boolean[n + 1];
		st = new StringTokenizer(br.readLine());
		p1 = Integer.parseInt(st.nextToken());
		p2 = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < m; i ++) {
			st = new StringTokenizer(br.readLine());
			int parent = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());
			map[parent][child] = 1;
			map[child][parent] = 1;
		}
		
		System.out.println(String.valueOf(bfs(p1, p2)));
	}
	
	static int bfs(int p1, int p2) {
		int result = 0;
		Queue<Integer> q = new LinkedList<>();
		q.add(p1);
		
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i = 0; i < size; i ++) {
				int cur = q.poll();
				visited[cur] = true;
				if(cur == p2) return result;
				for(int child = 1; child <= n; child ++) {
					if(map[cur][child] == 1) {
						if(!visited[child])
							q.add(child);
					}
				}
			}
			
			result ++;
		}
		
		return -1;
	}
}