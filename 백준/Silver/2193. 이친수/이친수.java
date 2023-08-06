import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());

		long[] fibonaci = new long[count + 1];
		fibonaci[0] = 0;
		fibonaci[1] = 1;

		for (int i = 2; i <= count; i++) {
			fibonaci[i] = fibonaci[i - 1] + fibonaci[i - 2];
		}

		System.out.println(fibonaci[count]);
	}
}
