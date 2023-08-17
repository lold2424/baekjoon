import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[] cowHeights = new int[N];
        for (int i = 0; i < N; i++) {
            cowHeights[i] = Integer.parseInt(br.readLine());
        }

        int minHeightDiff = Integer.MAX_VALUE;

        for (int mask = 0; mask < (1 << N); mask++) {
            int totalHeight = 0;
            for (int i = 0; i < N; i++) {
                if ((mask & (1 << i)) != 0) {
                    totalHeight += cowHeights[i];
                }
            }

            if (totalHeight >= B) {
                minHeightDiff = Math.min(minHeightDiff, totalHeight - B);
            }
        }

        System.out.println(minHeightDiff);
    }
}