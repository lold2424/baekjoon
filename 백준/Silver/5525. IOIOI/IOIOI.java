import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(reader.readLine());
		int m = Integer.parseInt(reader.readLine());
		char[] s = reader.readLine().toCharArray();

		int result = 0;
		int pattern = 0;
		for (int i = 0; i < s.length - 2; i++) {
			if (s[i] == 'I' && s[i + 1] == 'O' && s[i + 2] == 'I') {
				pattern++;
				if (pattern == n) {
					pattern--;
					result++;
				}
				i++;
			} else
				pattern = 0;
		}
		System.out.println(result);
	}
}