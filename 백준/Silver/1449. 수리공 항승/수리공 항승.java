import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.valueOf(st.nextToken());
		int L = Integer.valueOf(st.nextToken());
		
		int[] pipe = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			pipe[i] = Integer.valueOf(st.nextToken());
		}
		
		Arrays.sort(pipe);
		
		int count = 0;
		for (int i = 0; i < N; i++) {
			if (i == N - 1) {
				count ++;
				continue;
			}
			
			int hole = pipe[i ++];
			while (N > i) {
				if (pipe[i] - hole <= L - 1) {
					i ++;
				}
				else {
					break;
				}
			}
			count ++;
			i--;
		}
		
		System.out.println(count);
	}
}