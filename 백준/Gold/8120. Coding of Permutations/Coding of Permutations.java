import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] input = new int[30001];
		int[] ans = new int[30001];
		boolean[] check = new boolean[30001];

		for (int i = 1; i <= N; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}

		boolean flag = false;
		for (int i = N; i >= 1; i--) {
			int c = 0, j = N;
			while (!(c == input[i] && !check[j])) {
				if (!check[j])
					c++;
				j--;
			}
			if (j < 1) {
				flag = true;
				break;
			}
			ans[i] = j;
			check[j] = true;
		}

		if (flag)
			System.out.println("NIE");
		else {
			StringBuilder sb = new StringBuilder();
			for (int i = 1; i <= N; i++) {
				sb.append(ans[i]).append("\n");
			}
			System.out.print(sb);
		}
	}
}
