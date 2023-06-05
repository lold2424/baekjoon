import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int arr[] = new int[2000001];

    int N = Integer.parseInt(br.readLine());
    for (int i = 0; i < N; i++) {
      int M = Integer.parseInt(br.readLine());

      arr[M + 1000000]++;
    }
    for (int i = 2000000; i >= 0; i--) {
      for (int j = 0; j < arr[i]; j++) {
        sb.append((i - 1000000)).append("\n");
      }
    }
    System.out.print(sb);
  }
}