import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.HashMap;
import java.util.StringTokenizer;
 
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int Test_case = Integer.parseInt(br.readLine());
		for(int i = 0; i < Test_case; i++) {
			
			HashMap<String, Integer> hashing = new HashMap<>();
			
			int N = Integer.parseInt(br.readLine());
			
			while(N -- > 0) {
				st = new StringTokenizer(br.readLine(), " ");
				
				st.nextToken();
				
				String kind = st.nextToken();
				
				if(hashing.containsKey(kind)) {
					hashing.put(kind, hashing.get(kind) + 1);
				} else{
					hashing.put(kind, 1);
				}
			}
			
			int result = 1;
			for (int val : hashing.values()) {
				result *= (val + 1);
			}
			sb.append(result - 1).append('\n');
			
		}
		System.out.println(sb);
	}
}