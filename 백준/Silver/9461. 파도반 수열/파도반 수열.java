import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());
        long[] arr = new long[101];
        arr[1] = arr[2] = arr[3] = 1;
        arr[4] = arr[5] = 2;
        arr[6] = 3;
        arr[7] = 4;
        arr[8] = 5;

        for (int i = 0; i < count; i++) {
            int N = Integer.parseInt(br.readLine());

            if (N <= 8) {
                System.out.println(arr[N]);
            } else {
                for (int j = 9; j <= N; j++) {
                    arr[j] = arr[j - 5] + arr[j - 1];
                }
                System.out.println(arr[N]);
            }
        }
    }
}