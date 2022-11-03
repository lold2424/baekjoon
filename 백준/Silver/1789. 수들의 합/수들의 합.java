import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	static int res;
	static long S;
	static long sum;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		S = Long.parseLong(br.readLine());
		res = 0;
		while(true) {
			sum += res;
			if(sum > S) break;
			res++;
		}
		System.out.println(--res);
	}
}