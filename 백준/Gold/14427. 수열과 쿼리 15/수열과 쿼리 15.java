import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	static int[] tree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[n + 1];
		tree = new int[n * 4];
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		init(1, n, 1);
		int m = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			if (a == 1) {
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				arr[b] = c;
				update(1, n, 1, b);
			} else {
				sb.append(tree[1]).append("\n");
			}
		}
		System.out.println(sb);
	}

	private static int init(int start, int end, int node) {
		if (start == end) {
			return tree[node] = start;
		}
		int mid = (start + end) / 2;
		return tree[node] = minIndex(init(start, mid, node * 2), init(mid + 1, end, node * 2 + 1));
	}

	private static int minIndex(int x, int y) {
		if (arr[x] == arr[y]) {
			return Math.min(x, y);
		} else {
			return arr[x] < arr[y] ? x : y;
		}
	}

	private static int update(int start, int end, int node, int index) {
		if (start > index || end < index) {
			return tree[node];
		}
		if (start == end) {
			return tree[node] = index;
		}
		int mid = (start + end) / 2;
		return tree[node] = minIndex(update(start, mid, node * 2, index), update(mid + 1, end, node * 2 + 1, index));
	}
}
