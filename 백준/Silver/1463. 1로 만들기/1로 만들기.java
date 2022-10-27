import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
 
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		System.out.println(dp(N, 0));
	}

	static int dp(int N, int count){
		if (N < 2)	return count;
		
		return Math.min(dp(N / 2, count + 1 + (N % 2)), dp(N / 3, count + 1 + (N % 3)));
	}
}