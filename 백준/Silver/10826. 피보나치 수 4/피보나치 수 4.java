import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	
	public static int n;
	public static BigInteger fib[] = new BigInteger[10001];
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		fib[0] = BigInteger.ZERO;
		fib[1] = BigInteger.ONE;
		for (int i=2; i<=n; i++) {
			fib[i] = fib[i-1].add(fib[i-2]);
		}
		
		System.out.println(fib[n]);
	}

}