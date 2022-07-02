import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static char ascii[] = {33, 35, 36, 37, 38, 40, 41, 42, 43, 44, 46, 47, 59, 64, 94, 95, 123, 125};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int Test = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < Test; i++) {
			int N = Integer.parseInt(br.readLine());
			String str = br.readLine();
			int characters = 0, large = 0, small = 0, num = 0;
			
			if(N < 12) {
				System.out.println("invalid");
				continue;
			}
			
			for(int j = 0; j < N; j++) {
				for(int k = 0; k < 18; k++) {
					if(ascii[k] == str.charAt(j)) {
						characters++;
						break;
					}
				}
				for(int k = 0; k < N; k++) {
					if(Character.isUpperCase(str.charAt(k)) == true) {
						large++;
					}
					
					if(Character.isLowerCase(str.charAt(k)) == true) {
						small++;
					}
					
					if(Character.isDigit(str.charAt(k)) == true) {
						num++;
					}
				}
			}
			if(characters > 0 && large > 0 && small > 0 && num > 0) {
				System.out.println("valid");
			}
			else	System.out.println("invalid");
		}
	}
}