import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M, K, D;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		while(T-- > 0) {
			 st = new StringTokenizer(br.readLine());
			 N = Integer.parseInt(st.nextToken());
			 M = Integer.parseInt(st.nextToken());
			 K = Integer.parseInt(st.nextToken());
			 D = Integer.parseInt(st.nextToken());
			 int sum = 0;
			 for(int B = 1; sum(K * B, B) <= D; B++) {
				 sum = sum(K * B, B);
			 }
			 sb.append(sum != 0 ? sum : -1).append("\n");
		}
		System.out.print(sb);
	}
	static int sum(int A, int B) {
		int all = N * M;
		return A * all * (M - 1) / 2 + B * all * (N - 1) * M / 2;
	}
}