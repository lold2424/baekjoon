import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<String> list = new ArrayList<>();
		
		String str = st.nextToken();
		int N = str.length();
		
		for(int i=1; i<N-1; i++) {
			for(int j=i+1; j<N; j++) {
				String res=new String();
				res+= reverse(0, i, str);
				res+= reverse(i, j, str);
				res+= reverse(j, N, str);
				list.add(res);
			}
		}
		
		Collections.sort(list);
		System.out.println(list.get(0));
		
	}

	static String reverse(int st, int end, String ss) {
		
		String s = new String();
		
		for(int i=end-1; i>=st; i--) {
			s += ss.charAt(i); 
		}
		
		return s;
	}
	
	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}