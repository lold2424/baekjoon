import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String S1 = br.readLine();
		String S2 = br.readLine();
		
		int[][] memo = new int[S2.length() + 1][S1.length() + 1];
		
		int answer = 0;
		
		for (int i = 0; i < S2.length(); ++i) {
			for (int j = 0; j < S1.length(); ++j) {				
				if (S2.charAt(i) == S1.charAt(j)) {
					memo[i + 1][j + 1] = memo[i][j] + 1;
					answer = (answer < memo[i + 1][j + 1]) ? memo[i + 1][j + 1] : answer;
				}
			}
		}
		
		System.out.println(answer);
	}
}