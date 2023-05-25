import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i ++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int start = 0, end = 0, count = 0, sum = 0;
		
		while (start < N) {
			if (sum > M || end == N) sum -= arr[start ++];
			else sum += arr[end ++];
                
			if (sum == M) count ++;
		}
		
		System.out.println(count);	
	}
}