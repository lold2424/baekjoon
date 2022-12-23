import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int [][] map= new int[N][M];
		int [][] answer = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}						
		}
		Queue<Integer> value_queue = new LinkedList<>();
		Queue<Integer[]> idx_queue = new LinkedList<>();
		int start_i = 0;
		int end_i = N;
		int start_j = 0;
		int end_j = M;
		
		int size = Math.min(N, M) / 2;
		for(int T = 0;  T<size; T++) {
		
			int i_i = start_i;
			int j_j = start_j;
			while(true) {
				value_queue.add(map[i_i][j_j]);
				idx_queue.add(new Integer[] {i_i, j_j});
				if(j_j + 1 < end_j) {
					j_j = j_j + 1;
					continue;
				}
				if(i_i + 1 < end_i) { 
					i_i = i_i + 1;
					continue;
				}
				break;
			}
			while(true) {
				
				if(start_j <= j_j - 1) {
					j_j = j_j - 1;
					value_queue.add(map[i_i][j_j]);
					idx_queue.add(new Integer[] {i_i, j_j});
					continue;
					
				}
				if(i_i - 1 > start_i) {
					i_i = i_i - 1;
					value_queue.add(map[i_i][j_j]);
					idx_queue.add(new Integer[] {i_i, j_j});
					continue;
					
				}
				break;
			
			}
			start_i ++;
			end_i --;
			start_j ++;
			end_j --;
			
			int rotate = R % value_queue.size();
			
			for(int i = 0; i<rotate ;i++) {
				value_queue.add(value_queue.poll());
			}
			int len = value_queue.size();
			for(int i = 0 ; i < len; i++) {
				Integer [] answer_idx  = idx_queue.poll();
				answer[answer_idx[0]][answer_idx[1]] = value_queue.poll();
			}
		}
		
		for(int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(j != M - 1) {
					sb.append(answer[i][j] + " ");
				}
				else {
					sb.append(answer[i][j]);
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}