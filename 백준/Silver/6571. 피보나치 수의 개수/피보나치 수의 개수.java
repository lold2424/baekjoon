import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.math.BigInteger;

public class Main {
	public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		int fibonacciBound = 480;
		BigInteger[] f = new BigInteger[fibonacciBound];
		f[0] = BigInteger.ONE;
		f[1] = BigInteger.ONE;
        
		for (int i = 2; i < f.length; i++) {
			f[i] = f[i - 1].add(f[i - 2]);
		}
        
		while (true) {
			String[] str = br.readLine().split(" ");
			BigInteger bigNumber1 = new BigInteger(str[0]);
			BigInteger bigNumber2 = new BigInteger(str[1]);

			if (bigNumber1.equals(BigInteger.ZERO) && bigNumber2.equals(BigInteger.ZERO)) {
				break;
			}

			int count = 0;

			for (int i = 1; i < fibonacciBound; i++) {
				if (bigNumber1.compareTo(f[i]) <= 0 && bigNumber2.compareTo(f[i]) >= 0) {
					count++;
				}
			}
			sb.append(count).append('\n');
            
		}
		System.out.println(sb);

	}
}