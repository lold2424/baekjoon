import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		int chk = -1, cnt = 0;
		long ans = 0;
		
		for (int idx = 0; idx < str.length(); ++idx) {
			char c = str.charAt(idx);
			if (c == '(') {
				chk = idx;
				cnt++;
			} else {
				cnt--;
				if (chk == (idx - 1)) {
					ans += cnt;
				}
			}
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(Long.toString(ans));
		bw.flush();
	}
}