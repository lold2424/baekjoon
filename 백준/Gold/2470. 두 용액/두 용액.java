import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int i = 0;
		int j = N - 1;
		
		int min_answer = Integer.MAX_VALUE;
		int ans1 = 0;
		int ans2 = 0;
		
		int temp, sum;
		Arrays.sort(arr);
		
		while (i < j) {
			sum = arr[i] + arr[j];
			temp = Math.abs(sum);
			if (temp < min_answer) {
				min_answer = temp;
				ans1 = arr[i];
				ans2 = arr[j];
			}
			if (sum > 0)
				j--;
			else
				i++;
		}
		
		System.out.println(ans1 + " " + ans2);
	}
}