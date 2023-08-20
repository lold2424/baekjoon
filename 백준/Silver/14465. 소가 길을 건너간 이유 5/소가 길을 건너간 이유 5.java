import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		int[] railStatus = new int[100001];

		for (int i = 0; i < b; i++) {
			int blockedIndex = Integer.parseInt(br.readLine());
			railStatus[blockedIndex] = 1;
		}

		int minBlockedCount = Integer.MAX_VALUE;
		int currentWindowBlockedCount = 0;

		for (int i = 1; i <= n; i++) {
			if (i > k) {
				currentWindowBlockedCount -= railStatus[i - k];
			}
			currentWindowBlockedCount += railStatus[i];
			if (i >= k) {
				minBlockedCount = Math.min(currentWindowBlockedCount, minBlockedCount);
			}
		}

		System.out.println(minBlockedCount);
	}
}