import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		String res = "";
		
		res = dp(str);
		
		System.out.println(res);
	}

	static String dp(String str) {
		String answer = "";
		String A = "AAAA", B = "BB";
		
		str = str.replaceAll("XXXX", A);
		answer = str.replaceAll("XX", B);
		
		if(answer.contains("X")) {
			answer = "-1";
		}
		
		return answer;
	}
}