import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		
		int cnt = 0;
		char word = input.charAt(0);
		
		for(int i = 1; i < input.length(); i++) {
			 if(word != input.charAt(i)) {
				 word = input.charAt(i);
				 cnt ++;
			 }
		}
		
		System.out.println((cnt / 2) + cnt % 2);
	}
}