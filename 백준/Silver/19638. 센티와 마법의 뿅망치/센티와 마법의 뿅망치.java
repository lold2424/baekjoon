import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int iterationCount = 0;
		boolean belowThreshold = false;

		PriorityQueue<Integer> elements = new PriorityQueue<>(Collections.reverseOrder());

		for (int i = 0; i < N; i++)
			elements.add(Integer.parseInt(br.readLine()));

		while (T > 0) {
			if (elements.peek() <= 1 || elements.peek() < H) {
				break;
			} else if (elements.peek() != 1) {
				elements.add(elements.poll() / 2);
				T--;
				iterationCount++;
			}
		}
		if (elements.peek() < H)
			belowThreshold = true;

		System.out.println(belowThreshold ? "YES" : "NO");
		System.out.println(belowThreshold ? iterationCount : elements.peek());
	}
}
