import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());

			int[] arrSelect = new int[n + 1];
			boolean[] visited = new boolean[n + 1];

			for (int i = 1; i <= n; ++i) {
				arrSelect[i] = Integer.parseInt(br.readLine());
			}

			int number = arrSelect[1];
			int count = 1;
			visited[1] = true;

			while (true) {
				if (number == n) {
					break;
				}
				if (visited[arrSelect[number]]) {
					break;
				}
				++count;
				number = arrSelect[number];
				visited[number] = true;
			}

			if (number == n) {
				sb.append(count).append("\n");
			} else {
				sb.append("0\n");
			}
		}

		System.out.print(sb);
	}
}