import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(reader.readLine());
		
		while(T-- > 0) {
			int n = Integer.parseInt(reader.readLine());
			int [] New_recruits = new int[n + 1];
			
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(reader.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				New_recruits[x] = y;
			}
			
			int cnt = 1;
			int standard = New_recruits[1];
			for(int i = 2; i <= n; i++) {
				if(standard > New_recruits[i]) { 
	                cnt ++;
	                standard = New_recruits[i];
	            }
	        }
	        System.out.println(cnt);
	    }
	}
}