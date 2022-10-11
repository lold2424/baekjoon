import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		
		long num = divisor(A, B);
		
		for(int i = 0; i < (int) num; i++) {
			sb.append("1");
		}
		
		System.out.println(sb);
		
	}
	
	public static long divisor(long a, long b) {
		
		if(b == 0) {
			return a;
		}
		
		else {
			long c = a % b;
			return divisor(b, c);
		}
	}
}