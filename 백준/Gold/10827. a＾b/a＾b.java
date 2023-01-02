import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

import java.math.BigDecimal;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		BigDecimal A = new BigDecimal(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		BigDecimal C = A.pow(B);
		System.out.println(C.toPlainString());
	}
}