import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		int max = 0;
		int start = 0;

		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if (max < arr[i]) {
				max = arr[i];
			}
		}

		int end = max;

		while (start <= end) {
			long total = 0;
			int mid = (start + end) / 2;

			for (int i = 0; i < N; i++) {
				if (arr[i] > mid) {
					total += arr[i] - mid;
				}
			}

			if (total < M) {
				end = mid - 1;
			}
			
			else {
				start = mid + 1;
			}
		}

		System.out.println(end);
	}
}