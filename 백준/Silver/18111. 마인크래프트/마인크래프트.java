import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main {
	
	static int arr[][];
	static int N, M, B;
	static int min_time = Integer.MAX_VALUE;
	static int floor = 0, depth = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(floor < arr[i][j]) floor = arr[i][j];
			}
		}
		
		dig(floor);
		
		System.out.printf("%d %d", min_time, depth);
		
	}
	
	static void dig(int floor) {
		int block = B;
		int time = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(arr[i][j] >= floor) {
					block += arr[i][j] - floor;
					time += (arr[i][j] - floor) * 2;
				}
				
				else {
					block += arr[i][j] - floor;
					time += floor - arr[i][j];
				}
			}
		}
		
		if(block >= 0) {
			if(min_time > time) {
				min_time = time;
				depth = floor;
			}
		}
		if(floor > 0)	dig(floor - 1); 
	}
}