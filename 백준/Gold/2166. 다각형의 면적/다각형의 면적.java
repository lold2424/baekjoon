import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {
	
	static int N; 
	static long x[] = new long[100001];
	static long y[] = new long [100001];
	static long ans; // 100000 * 100000이면 Integer값 넘을 수 있음
	static long sum1, sum2; 
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			x[i] = Integer.parseInt(st.nextToken());
			y[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1; i<= N; i++) {
        //신발끈 공식
			
			if (i == N) 
			{
				sum1 = sum1 + x[N] * y[1];
				sum2 = sum2 + y[N] * x[1];
			} else {
			// i가 N일 경우에는 x[N]y[1]이어야 하고
			sum1 = sum1 + x[i] * y[i + 1] ;
			//i가 N일 경우에는 y[N]x[1]이어야 하는데
			sum2 = sum2 + y[i] * x[i + 1] ;
			}
		}
		ans = (sum1 - sum2) ;
		
        System.out.print(Math.abs(ans) / 2);
        if(ans % 2 == 0) {
            System.out.println(".0");
        } else {
            System.out.println(".5");
        }
	}
}