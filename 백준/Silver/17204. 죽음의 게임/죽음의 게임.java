import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] graph = new int[N];
		for (int i = 0; i < N; i++) {
			graph[i] = Integer.parseInt(br.readLine());
		}

		boolean[] visited = new boolean[N];
		int count = 0;
		int currentIndex = 0;

		while (!visited[currentIndex]) {
			visited[currentIndex] = true;
			currentIndex = graph[currentIndex];
			count++;

			if (currentIndex == K) {
				System.out.print(count);
				return;
			}
		}

		System.out.print(-1);
	}
}