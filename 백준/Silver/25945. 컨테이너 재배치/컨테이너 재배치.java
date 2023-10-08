import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] container = new int[n];
		int cnt1 = 0, cnt2 = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			container[i] = Integer.parseInt(st.nextToken());
		}
		
		int sum = 0;
		for (int i : container) {
			sum += i;
		}
		
		int avg = sum / n;
		
		for (int i : container) {
			if (i > avg + 1) {
				cnt1 += (i - avg - 1);
				} else if (i < avg) {
				cnt2 += (avg - i);
			}
		}
		
		System.out.println(Math.max(cnt1, cnt2));
	}
}