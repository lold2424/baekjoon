import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, answer;
	static boolean visited[];
	static int[][] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			answer = 0;
			arr = new int[N + 1][N + 1];
			visited = new boolean[N + 1];
			
			for(int j = 0; j < M; j++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				arr[a][b] = 1;
				arr[b][a] = 1;
			}
			
			bfs();
			sb.append(answer - 1 + "\n");
		}
		
		System.out.println(sb);
	}

	private static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		visited[1] = true;
		
		while(!q.isEmpty()) {
			answer ++;
			int tmp = q.poll();
			for (int i = 1; i <= N; i++) {
				if(arr[tmp][i] != 0 && !visited[i]) {
					visited[i] = true;
					q.add(i);
				}
			}
		}
	}
}