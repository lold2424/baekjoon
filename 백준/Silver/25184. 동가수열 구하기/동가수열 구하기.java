import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		int difference = N / 2;
		int leftValue = difference;
		int rightValue = (N % 2 == 1) ? N - 1 : N;
		
		for (int i = 0; i < difference; i++) {
			sb.append(leftValue--).append(' ').append(rightValue--).append(' ');
		}
		
		if (N % 2 == 1) {
			sb.append(N).append('\n');
		} else {
			sb.append('\n');
		}
		
		System.out.println(sb);
		
		br.close();
	}
}
