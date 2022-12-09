import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main {
	
	static int[][] arr;
	static int[] list = new int[3];
	static int s, N;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		s = 0;
		dfs(0, 0);
		System.out.println((double) s / 2.0);
	}
	
	private static void dfs(int t, int k) {
		if (k == 3) {
			int tmp = 0;
			int a = list[0];
			int b = list[1];
			int c = list[2];
			tmp += arr[a][0] * arr[b][1] + arr[b][0] * arr[c][1] + arr[c][0] * arr[a][1];
			tmp -= arr[b][0] * arr[a][1] + arr[c][0] * arr[b][1] + arr[a][0] * arr[c][1];
			tmp = Math.abs(tmp);
			s = Math.max(s, tmp);
			return;
		}
		
		for (int i = t; i < N; i++) {
			list[k] = i;
			dfs(i + 1, k + 1);
		}
	}
}