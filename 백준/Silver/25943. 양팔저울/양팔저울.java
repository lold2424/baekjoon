import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] Weight = {100, 50, 20, 10, 5, 2, 1};
		int N = Integer.parseInt(br.readLine());
		StringTokenizer tokenizer = new StringTokenizer(br.readLine());

		int left = 0, right = 0;
		for (int i = 0; i < N; i++) {
			int P = Integer.parseInt(tokenizer.nextToken());
			if (left <= right) {
				left += P;
			} else {
				right += P;
			}
		}

		int diff = Math.abs(left - right);
		int cnt = 0;
		for (int i : Weight) {
			cnt += diff / i;
			diff %= i;
		}

		System.out.println(cnt);
		br.close();
	}
}
