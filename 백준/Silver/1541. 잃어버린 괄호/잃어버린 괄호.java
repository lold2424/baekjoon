import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split("\\-");
		int ress = plus(s[0]);
		
		for(int i = 1; i < s.length; i++) {
			ress -= plus(s[i]);
		}
		
		System.out.println(ress);
	}
	
	public static int plus(String s) { 
		int res = 0;
		String[] add = s.split("\\+");
		
		for(int l = 0; l < add.length; l++) {
			res += Integer.parseInt(add[l]);
		}
		return res;
	}
}