import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String w = br.readLine().trim();
		int result = checkPalindrome(w, 0);

		bw.write((result < 4) ? String.valueOf(result) : "-1");
		bw.newLine();
		bw.flush();
		bw.close();
	}

	public static int checkPalindrome(String w, int k) {
		if (k > 3) {
			return k;
		}

		int left = 0;
		int right = w.length() - 1;
		while (left < right) {
			if (w.charAt(left) == w.charAt(right)) {
				left++;
				right--;
			} else {
				int option1 = checkPalindrome(w.substring(left + 1, right + 1), k + 1);
				int option2 = checkPalindrome(w.substring(left, right), k + 1);
				return Math.min(option1, option2);
			}
		}

		return k;
	}
}
