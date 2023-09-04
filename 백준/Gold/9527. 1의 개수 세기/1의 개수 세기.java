import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long[] dp = new long[55];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long startRange = Long.parseLong(st.nextToken());
		long endRange = Long.parseLong(st.nextToken());

		calculateDP();
		long result = countOnesInRange(endRange) - countOnesInRange(startRange - 1);
		System.out.print(result);
	}

	static long countOnesInRange(long n) {
		long count = n & 1;
		int size = (int) (Math.log(n) / Math.log(2));
		for (int i = size; i > 0; i--) {
			if ((n & (1L << i)) != 0L) {
				count += dp[i - 1] + (n - (1L << i) + 1);
				n -= (1L << i);
			}
		}
		return count;
	}

	static void calculateDP() {
		dp[0] = 1;
		for (int i = 1; i < 55; i++)
			dp[i] = (dp[i - 1] << 1) + (1L << i);
	}
}
