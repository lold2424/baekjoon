import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();

		long n = Long.parseLong(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		while (n != 0) {
			long remainder = n % b;

			if (remainder > 9) {
				char convertedChar = (char) (remainder + 55);
				sb.append(convertedChar);
			} else {
				sb.append(remainder);
			}

			n = n / b;
		}

		System.out.println(sb.reverse());
	}
}
