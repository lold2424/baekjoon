import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
public class Main {
	
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int answer = 0;
        
        if(N == 1) {
        	answer = 1;
		} else if(N == 2) {
			answer = Math.min((M + 1) / 2, 4);
		} else if(N >= 3){
			if(M < 7) {
				answer = Math.min(M, 4);
			} else {
				answer = M-2;
			}
		}
		
		System.out.println(answer);
	}
}