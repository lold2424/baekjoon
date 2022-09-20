import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			sb.setLength(0);
			
			String num = br.readLine();
			String reverse_num;
			
			if(num.equals("0"))	break;
			
			reverse_num = reverse(num);
			
			if(num.equals(reverse_num))	System.out.println("yes");
			
			else	System.out.println("no");
		}
	}
	public static String reverse(String str) {
		return new StringBuilder(str).reverse().toString();
	}
}