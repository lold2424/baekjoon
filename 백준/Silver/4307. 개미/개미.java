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

		int testCnt = Integer.parseInt(st.nextToken());

		for (int i = 0; i < testCnt; i++) {
			st = new StringTokenizer(br.readLine());
			int stickLength = Integer.parseInt(st.nextToken());
			int antCnt = Integer.parseInt(st.nextToken());

			int[] antPositions = new int[antCnt];

			int minTimeToFall = Integer.MIN_VALUE;
			int maxTimeToFall = Integer.MIN_VALUE;

			for (int j = 0; j < antCnt; j++) {
				st = new StringTokenizer(br.readLine());
				int antPosition = Integer.parseInt(st.nextToken());

				int timeToReachMin = Math.min(antPosition, stickLength - antPosition);
				int timeToReachMax = Math.max(antPosition, stickLength - antPosition);

				minTimeToFall = Math.max(minTimeToFall, timeToReachMin);
				maxTimeToFall = Math.max(maxTimeToFall, timeToReachMax);
			}
			bw.write(minTimeToFall + " " + maxTimeToFall + "\n");
		}

		bw.flush();
		bw.close();
	}
}
