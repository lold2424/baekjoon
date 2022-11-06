import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
        int X = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int answer = 0, price, count;
        
        for(int i = 0; i < N; i++){
        	StringTokenizer st = new StringTokenizer(br.readLine());
            price = Integer.parseInt(st.nextToken());
            count = Integer.parseInt(st.nextToken());
            answer += count * price;
        }
        System.out.println((answer == X) ? "Yes" : "No");
    }
}