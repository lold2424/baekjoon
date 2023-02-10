import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		
		int max = 1;
		int incCnt = 1;
		int decCnt = 1;
		
		int sequence = Integer.parseInt(st.nextToken());
		
		while (N -- > 1) {
			int cur = Integer.parseInt(st.nextToken());
			
			if (cur == sequence) {
				incCnt ++;
				decCnt ++;
				continue;
			}
			
			if (cur < sequence) {
				max = Math.max(max, incCnt);
				incCnt = 1;
			} else {
				incCnt++;
			}
			
			if (cur > sequence) {
				max = Math.max(max, decCnt);
				decCnt = 1;
			} else {
				decCnt ++;
			}
			
			sequence = cur;
		}
		
		max = Math.max(max, Math.max(incCnt, decCnt));
		System.out.println(max);
	}
}