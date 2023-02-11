import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String[] pattern = br.readLine().split("\\*");
		
		int length1 = pattern[0].length();
		int length2 = pattern[1].length();
		
		for(int i = 0; i < N; i ++) {
			String input = br.readLine();
			
			if(input.length() >= length1 + length2) {
				String temp1 = input.substring(0,pattern[0].length());
				String temp2 = input.substring(input.length() - pattern[1].length());
				if(temp1.equals(pattern[0]) && temp2.equals(pattern[1])) {
					System.out.println("DA");
				} else {
					System.out.println("NE");
				}
			} else {
				System.out.println("NE");
			}
		}
	}
}