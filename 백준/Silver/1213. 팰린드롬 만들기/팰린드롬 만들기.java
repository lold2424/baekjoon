import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringBuilder sb = new StringBuilder();
		
		String name = br.readLine();
		
		int[] a = new int[26];
		
		for(char ch : name.toCharArray()) {
			a[ch - 'A']++;
		}
		
		int n = 0, mid = 0;
		for(int i = 0; i < 26; i++) {
			if(a[i] % 2 == 1) {
				mid = i;
				n ++;
			}
		}
		
		if((name.length() % 2 == 1 && n > 1) || (name.length() % 2 == 0 && n > 0)) {
			sb.append("I'm Sorry Hansoo");
		} else {
			String answer = "";
			for(int i = 0; i < 26; i++) {
				for(int j = 0; j < a[i] / 2; j++) {
					answer += (char)(i + 'A');
				}
			}
			
			String rev = new StringBuilder(answer).reverse().toString();
			if(n == 1) answer += (char)(mid + 'A');
			
			sb.append(answer + rev);
		}
		
		System.out.print(sb);
	}
}