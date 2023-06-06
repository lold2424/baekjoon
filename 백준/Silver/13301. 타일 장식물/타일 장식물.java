import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<Long> result = new ArrayList<>();
		ArrayList<Long> fibonacci = new ArrayList<>();

		fibonacci.add((long) 1);
		fibonacci.add((long) 1);

		for (int i = 2; i < N; i++) {
			fibonacci.add(fibonacci.get(i-2) + fibonacci.get(i - 1));
		}

		result.add((long) 4);

		for (int i = 1; i < N; i++) {
			result.add(result.get(i - 1) + 2*fibonacci.get(i));
		}

		sb.append(result.get(N - 1));
		
		System.out.println(sb.toString());
	}
}