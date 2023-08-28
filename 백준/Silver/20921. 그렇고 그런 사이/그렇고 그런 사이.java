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
		int K = Integer.parseInt(st.nextToken());

		int currentSum = 0;
		int currentIndex = N - 1;
		boolean[] selectedNumbers = new boolean[N];

		while (currentIndex > 0) {
			if (currentSum + currentIndex <= K) {
				currentSum += currentIndex;
				selectedNumbers[currentIndex] = true;
			}
			currentIndex--;
		}

		for (int i = N - 1; i >= 0; i--) {
			if (selectedNumbers[i]) {
				bw.write(Integer.toString(i + 1) + " ");
			}
		}
		for (int i = 0; i < N; i++) {
			if (!selectedNumbers[i]) {
				bw.write(Integer.toString(i + 1) + " ");
			}
		}

		bw.flush();
		bw.close();
	}
}
