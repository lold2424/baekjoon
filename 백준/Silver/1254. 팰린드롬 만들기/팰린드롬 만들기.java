import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		System.out.println(calculate(str));
	}
	
	static int calculate(String str) {
		
		int len = str.length();
		
		for(int i = 0; i < len; i ++) {
			if(palindrome(str.substring(i))) return len + i;
		}
		
		return len * 2;
	}
	
	static boolean palindrome(String str) {
		int len = str.length();
		
		for(int i = 0; i < len; i ++) {
			if(str.charAt(i) != str.charAt(len - i - 1))  return false;
		}
		
		return true;
	}
}