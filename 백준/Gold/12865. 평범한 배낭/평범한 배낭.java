import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int kg = Integer.parseInt(st.nextToken());

		int dp[][] = new int[N+1][kg+1];
		int product[][] = new int[N+1][2];
        
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			product[i][0] = Integer.parseInt(st.nextToken());
			product[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= kg; j++) {
				
				if (j - product[i][0] >= 0) {
				  dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-product[i][0]] + product[i][1]);
				} else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		
		System.out.println(dp[N][kg]);
	}
}