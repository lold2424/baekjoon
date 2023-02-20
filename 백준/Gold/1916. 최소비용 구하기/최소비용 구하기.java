import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		int[][] arr = new int[N+1][N+1];
		for (int i = 1; i < N + 1; i++) {
			Arrays.fill(arr[i], -1);
		}
		
		for(int i = 0; i < M; i++) {
			
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
 
			if(arr[a][d] == -1) 
				arr[a][d] = c;
			else if(arr[a][d] > c) 
				arr[a][d] = c;
		}
		
		st = new StringTokenizer(br.readLine());
		
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		boolean[] check = new boolean[N+1]; 

		int[] distance = new int[N+1]; 
		Arrays.fill(distance, Integer.MAX_VALUE-1); 

		distance[start] = 0;

		for(int i = 0; i < N-1; i++) { 
			int min = Integer.MAX_VALUE;
			int index = -1;
 
			for(int j = 1; j < N+1; j++) { 
				if(!check[j] && distance[j] < min) {
					min = distance[j]; 
					index = j;
				}
			}

			check[index] = true;

			for (int j = 1; j < N+1; j++) { 
				if (!check[j] && arr[index][j] != -1 && distance[index] + arr[index][j] < distance[j]) { // 간선이 연결되지 않은 -1의 경우 역시 제외해야함 
					distance[j] = distance[index] + arr[index][j];
				}
			}
		}

		System.out.println(distance[end]);
	}
}