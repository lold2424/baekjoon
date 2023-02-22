import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] w = new int[N];
		
		for (int i = 0; i < N; i ++) {
			w[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(w);
		int res = 0;
		
		for (int i = N - 1; i >= 0; i --) {
			w[i] = w[i] * (N - i);
			if (res < w[i]) res = w[i];
		}
		
		System.out.println(res);
	}
}