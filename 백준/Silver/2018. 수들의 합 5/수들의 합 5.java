import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int start = 0, end = 0;
		int sum = 0, cnt = 0;
		while (start <= N) {
			while (++end <= N) {
				sum += end;
				if (sum >= N) {
					if (sum == N) cnt++;
					break;
				}
			}
			while (++start <= N) {
				sum -= start;
				if (sum <= N) {
					if (sum == N) cnt++;
					break;
				}
			}
		}
		System.out.println(cnt);
	}
}
