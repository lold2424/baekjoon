import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int K = Integer.parseInt(br.readLine());
		
		int[] a_arr = new int[45];
		int[] b_arr = new int[45];
		
		a_arr[0] = 0;
		a_arr[1] = 1;
		b_arr[0] = 1;
		b_arr[1] = 1;
		
		for (int i = 2; i < 45; i ++) {
			a_arr[i] = a_arr[i - 2] + a_arr[i - 1];
			b_arr[i] = b_arr[i - 2] + b_arr[i - 1];
		}
		
		System.out.println(a_arr[K - 1] + " " + b_arr[K - 1]);
	}
}