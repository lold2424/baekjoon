import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		boolean[] powered = new boolean[K + 1];
		int[] order = new int[K];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			order[i] = Integer.parseInt(st.nextToken());
		}
		
		int ans = 0;
		int using = 0;
		for (int i = 0; i < K; i ++) {
			if (powered[order[i]]) continue;
			else {
				if (using < N) {
					powered[order[i]] = true;
					using ++;
				} else {
					int[] visited = new int[K + 1];
					for (int x = 1; x <= K; x ++) {
						if (powered[x]) visited[x] = Integer.MAX_VALUE;
					}
					for (int j = i + 1; j < K; j ++) {
						if (visited[order[j]] == Integer.MAX_VALUE) {
							visited[order[j]] = j;
						}
					}
					int unplug = 0;
					for (int j = 1; j <= K; j ++) {
						if (visited[j] > visited[unplug]) {
							unplug = j;
						}
					}
					powered[unplug] = false;
					ans ++;
					powered[order[i]] = true;
				}
			}
		}
		
		System.out.println(ans);
	}
}