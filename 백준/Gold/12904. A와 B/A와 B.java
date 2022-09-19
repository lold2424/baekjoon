import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

public class Main {
	static String S, T;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Character> ListT = new ArrayList<Character>();
		S = br.readLine();
		T = br.readLine();

		for(int i = 0; i < T.length(); i++) {
			ListT.add(T.charAt(i));
		}

		int index = ListT.size() - 1;
		while(ListT.size() > S.length()) {
			if(ListT.get(index) == 'A') {
				ListT.remove(index);
			}
			
			else{
				ListT.remove(index);
				ListT = reverse(ListT);
			}
			index--;
		}

		for(int i = 0; i < S.length(); i++) {
			if(S.charAt(i) != ListT.get(i).charValue()) {
				System.out.println(0);
				System.exit(0);
			}
		}
		System.out.println(1);
	}

	static List<Character> reverse(List<Character> list) {
		List<Character> result = new ArrayList<Character>();
		int index = list.size() - 1;
		while(index >= 0) {
			result.add(list.get(index--));
		}
		return result;
	}
}