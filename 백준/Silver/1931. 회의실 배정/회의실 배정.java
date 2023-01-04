import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

	static long ans = Integer.MIN_VALUE;
	static int N;
	static int[][] arr;
	static int[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = new int[N][2];
		dp = new int[N];
		
		for(int i = 0 ; i < N ;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}
				
				return o1[1] - o2[1];
			}
		});
		
		int time = 0;
		int finish = 0;
		
		for(int i = 0 ; i < N ;i++) {
			if(finish <= arr[i][0]) {
				time++;
				finish = arr[i][1];
			}
		}

		System.out.println(time);
		}
}