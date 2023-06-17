import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] numArray;
	static int[] operators = new int[4];
	static boolean[] visited;
	static int maximum = Integer.MIN_VALUE;
	static int minimum = Integer.MAX_VALUE;

	static void dfs(int depth, int total) {
		if (depth == N) {
			maximum = Math.max(maximum, total);
			minimum = Math.min(minimum, total);
		}

		for (int i = 0; i < 4; i++) {
			if (operators[i] > 0) {
				operators[i]--;
				switch (i) {
				case 0:
					dfs(depth + 1, total + numArray[depth]);
					break;
				case 1:
					dfs(depth + 1, total - numArray[depth]);
					break;
				case 2:
					dfs(depth + 1, total * numArray[depth]);
					break;
				case 3:
					dfs(depth + 1, total / numArray[depth]);
					break;
				}
				operators[i]++;
			}

		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = stoi(br.readLine());
		numArray = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numArray[i] = stoi(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			operators[i] = stoi(st.nextToken());
		}
		dfs(1, numArray[0]);
		System.out.println(maximum);
		System.out.println(minimum);
	}

	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}