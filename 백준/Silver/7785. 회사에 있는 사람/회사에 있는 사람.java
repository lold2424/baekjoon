import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		HashSet<String> set = new HashSet<>();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			String state = st.nextToken();
			
			if (state.equals("enter")) {
				set.add(name);
			}
			
			else if (state.equals("leave")) {
				set.remove(name);
			}
		}
		
		ArrayList<String> list = new ArrayList<>(set);
		Collections.sort(list);
		
		for (int i = list.size() - 1; i >= 0; i--) {
			sb.append(list.get(i) + "\n");
		}
		
		System.out.println(sb);
	}
}