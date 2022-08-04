import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		while(T-- > 0) {
			 st = new StringTokenizer(br.readLine());
			 int N = Integer.parseInt(st.nextToken());
			 int M = Integer.parseInt(st.nextToken());
			 int K = Integer.parseInt(st.nextToken());
			 int D = Integer.parseInt(st.nextToken());
			 int all = N * M;
			 int sum = K * all * (M - 1) / 2 + all * (N - 1) * M / 2;
			 int B = D / sum;
			 sb.append(B != 0 ? sum * B : -1).append("\n");
		}
		System.out.print(sb);
	}
}
