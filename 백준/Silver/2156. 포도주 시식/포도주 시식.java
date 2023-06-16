import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());
        int[] grapes = new int[N + 1];
        int[][] dp = new int[N + 1][3];

        for (int i = 1; i <= N; i++) {
            grapes[i] = Integer.parseInt(reader.readLine());
        }

        int maxSum = grapes[1];
        dp[1][0] = 0;
        dp[1][1] = grapes[1];
        dp[1][2] = 0;

        if (N >= 2) {
            dp[2][0] = dp[1][1];
            dp[2][1] = grapes[2];
            dp[2][2] = dp[1][1] + grapes[2];
            maxSum = dp[2][2];
        }

        for (int i = 3; i <= N; i++) {
            dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = Math.max(Math.max(dp[i - 2][1], dp[i - 2][2]), dp[i - 2][0]) + grapes[i];
            dp[i][2] = dp[i - 1][1] + grapes[i];

            if (maxSum < dp[i][0])
                maxSum = dp[i][0];
            if (maxSum < dp[i][1])
                maxSum = dp[i][1];
            if (maxSum < dp[i][2])
                maxSum = dp[i][2];
        }

        System.out.print(maxSum);
    }
}
