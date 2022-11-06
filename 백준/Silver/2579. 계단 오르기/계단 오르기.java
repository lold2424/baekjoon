import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		int score[] = new int[N + 1];
		int arr[] = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			score[i] = Integer.parseInt(br.readLine());
		}

		arr[1] = score[1];

		if (N >= 2) {
			arr[2] = score[1] + score[2];
		}

		for (int i = 3; i <= N; i++) {
			arr[i] = Math.max(arr[i - 2], arr[i - 3] + score[i - 1]) + score[i];
		}

		System.out.println(arr[N]);
	}
}