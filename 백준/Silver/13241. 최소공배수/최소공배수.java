import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());
        
        long gcd = getGCD(A, B);
        long lcm = A / gcd * B;
        
        System.out.println(lcm);
    }

    private static long getGCD(long a, long b) {
        while (b > 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        
        return a;
    }
}