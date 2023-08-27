import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] numbers = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0, right = 0, minLength = N + 1, currentSum = numbers[0];
        while (right < N && left <= right) {
            if (currentSum >= S) {
                minLength = Math.min(minLength, right - left + 1);
                currentSum -= numbers[left++];
            } else {
                right++;
                if (right < N) {
                    currentSum += numbers[right];
                }
            }
        }

        if (minLength > N) {
            minLength = 0;
        }

        bw.write(String.valueOf(minLength));
        bw.newLine();
        bw.flush();

        br.close();
        bw.close();
    }
}
