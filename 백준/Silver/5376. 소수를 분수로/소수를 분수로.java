import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test_case = Integer.parseInt(br.readLine());
		
		while(test_case -- > 0) {
			String str = br.readLine();
			
			String sub = "";
			int len = 0;
			int idx = 0;
			
			for(int j = 2; j < str.length(); ++j) {
				if(str.charAt(j) == '(') {
					idx = j;
					break;
				}
				len ++;
			}
			
			long gcd, a, b;
			int l = str.length();
			
			if(len == l - 2) {
				a = (long)Math.pow(10, l - 2);
				b = Long.parseLong(str.substring(2));
				gcd = gcd(a, b);
				if(gcd == 1) {
					System.out.println(b + "/" + a);
				} else {
					System.out.println(b/gcd + "/" + a/gcd);
				}
				continue;
			}
			
			String s1 = "", s2 = "";
			boolean flag = false;
			
			for(int j = 2; j < l; ++j) {
				char c = str.charAt(j);
				
				if(flag && j < l - 1) sub += 9;
				if(c == '(') flag = true;
				if(c != '(' && c != ')') s1 += c;
			}
			
			for(int j = 2; j < l; ++j) {
				char c = str.charAt(j);
				
				if(c == '(') break;
				
				sub += 0;
			}
			
			s2 = str.substring(2, idx);
			a = Long.parseLong(sub);
			
			if(s2.equals("")) b = Long.parseLong(s1);
			else b = Long.parseLong(s1) - Long.parseLong(s2);
			
			gcd = gcd(a, b);
			
			if(gcd == a) System.out.println(b + "/" + a);
			else System.out.println(b/gcd + "/" + a/gcd);
		}		
	}
	
	public static long gcd(long a, long b) {
		while(b != 0) {
			long tmp = a % b;
			a = b;
			b = tmp;
		}
		return a;
	}
}