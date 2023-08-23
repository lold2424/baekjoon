import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] originalArray;
	static int[] segmentTree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		originalArray = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			originalArray[i] = Integer.parseInt(st.nextToken());
		}

		segmentTree = new int[n * 4];
		initSegmentTree(1, n, 1);

		int m = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int queryType = Integer.parseInt(st.nextToken());

			if (queryType == 1) {
				int index = Integer.parseInt(st.nextToken());
				int value = Integer.parseInt(st.nextToken());
				originalArray[index] = value;
				updateSegmentTree(1, n, 1, index);
			} else {
				sb.append(segmentTree[1]).append("\n");
			}
		}

		System.out.println(sb);
	}

	private static int initSegmentTree(int start, int end, int node) {
		if (start == end) {
			return segmentTree[node] = start;
		}
		int mid = (start + end) / 2;
		return segmentTree[node] = getMinIndex(initSegmentTree(start, mid, node * 2), initSegmentTree(mid + 1, end, node * 2 + 1));
	}

	private static int getMinIndex(int x, int y) {
		if (originalArray[x] == originalArray[y]) {
			return Math.min(x, y);
		} else {
			return originalArray[x] < originalArray[y] ? x : y;
		}
	}

	private static int updateSegmentTree(int start, int end, int node, int index) {
		if (start > index || end < index) {
			return segmentTree[node];
		}
		if (start == end) {
			return segmentTree[node] = index;
		}
		int mid = (start + end) / 2;
		return segmentTree[node] = getMinIndex(updateSegmentTree(start, mid, node * 2, index), updateSegmentTree(mid + 1, end, node * 2 + 1, index));
	}
}
