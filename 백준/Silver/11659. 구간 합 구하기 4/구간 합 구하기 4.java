import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] firstLine = readFirstLine(br);
		int N = firstLine[0], M = firstLine[1];
		
		int[] num = readNumbers(br, N);
		int[] prefixSum = computePrefixSum(num, N);
		
		processQueries(br, M, prefixSum);
	}
	
	private static int[] readFirstLine(BufferedReader br) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		return new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
	}
	
	private static int[] readNumbers(BufferedReader br, int N) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] num = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		return num;
	}
	
	private static int[] computePrefixSum(int[] num, int N) {
		int[] prefixSum = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			prefixSum[i] = prefixSum[i - 1] + num[i];
		}
		return prefixSum;
	}
	
	private static void processQueries(BufferedReader br, int M, int[] prefixSum) throws IOException {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			sb.append(prefixSum[y] - prefixSum[x - 1]).append("\n");
		}
		System.out.print(sb.toString());
	}
}
