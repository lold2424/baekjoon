import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		while (T-- > 0) {
			int N = Integer.parseInt(st.nextToken());
			max = Math.max(N, max);
			min = Math.min(N, min);
		}
		System.out.println(max * min);
	}
}