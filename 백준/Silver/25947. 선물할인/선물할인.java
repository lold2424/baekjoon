import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int numItems = Integer.parseInt(input[0]);
        int budget = Integer.parseInt(input[1]);
        int maxDiscountedItems = Integer.parseInt(input[2]);

        int[] itemPrices = new int[numItems + 1];

        input = br.readLine().split(" ");
        for (int i = 1; i <= numItems; i++) {
            itemPrices[i] = Integer.parseInt(input[i - 1]);
        }

        Arrays.sort(itemPrices);

        int result = -1;
        int[] dp = new int[100001];
        dp[0] = 0;

        for (int i = 1; i <= maxDiscountedItems; i++) {
            dp[i] = dp[i - 1] + (itemPrices[i] / 2);
            if (dp[i] > budget) {
                result = i - 1;
                break;
            }
        }

        if (result == -1) {
            for (int i = maxDiscountedItems + 1; i < 100000; i++) {
                if (i > numItems) {
                    result = i - 1;
                    break;
                }
                dp[i] = dp[i - 1] + (itemPrices[i] / 2);
                dp[i] += itemPrices[i - maxDiscountedItems] / 2;
                if (dp[i] > budget || i > numItems) {
                    result = i - 1;
                    break;
                }
            }
        }

        System.out.println(result);
    }
}
