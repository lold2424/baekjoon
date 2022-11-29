import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
	
	static int L, C;
	static char alphabet[];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		alphabet = new char[C];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < C; i++) {
			alphabet[i] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(alphabet);
		
		back(0, 0, "");
		
		System.out.print(sb);
	}
	
	private static void back(int start, int cnt, String s) {
		if(cnt == L) {
			if(possible(s)){
				sb.append(s).append("\n");
				return;
			}
		}
		
		for(int i = start; i < C; i++) {
			String new_s = s + alphabet[i];
			back(i + 1, cnt + 1, new_s);
		}
	}
	
	static boolean possible(String s) {
		int vo = 0, nonvo = 0;
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == 'a' || s.charAt(i) == 'e' ||
					s.charAt(i) == 'i' || s.charAt(i) == 'o' ||
					s.charAt(i) == 'u') vo++;
			else nonvo++;
		}
		
		return vo >= 1 && nonvo >= 2;
	}
}