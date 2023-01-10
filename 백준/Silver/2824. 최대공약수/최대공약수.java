import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

import java.math.BigInteger;

public class Main{

	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		BigInteger A = new BigInteger("1");
		BigInteger B = new BigInteger("1");
		BigInteger zero = new BigInteger("0");
		BigInteger temp = new BigInteger("1");
		
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			BigInteger mul = new BigInteger(st.nextToken());
			A = A.multiply(mul);
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < M; i++) {
			B = B.multiply(new BigInteger(st.nextToken()));
		}
		
		while (true) {
			if (A.compareTo(zero) <= 0) {
				sb.append(B.toString());
				break;
			} else if (B.compareTo(zero) <= 0) {
				sb.append(A.toString());
				break;
			}
			
			boolean compare = A.compareTo(B) == 1 ? true : false;
			
			if (compare) {
				temp = B;
				B = A.remainder(B);
				A = temp;
				
			} else {
				temp = A;
				A = B.remainder(A);
				B = temp;
			}
		}
		
		if(sb.length() > 9) {
		System.out.println(sb.substring(sb.length() - 9, sb.length()));
		} else {
			System.out.println(sb);
		}
	}
}