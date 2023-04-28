import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Set<Integer> set = new HashSet<>();
		
		for (int i = 0 ; i < n ; i++){
			set.add(Integer.parseInt(st.nextToken()));
		}
		
		ArrayList<Integer> arry = new ArrayList<>(set);
		Collections.sort(arry);
		
		StringBuilder sb = new StringBuilder();
		for (int i : arry) {
			sb.append(i).append(" ");
		}
		System.out.println(sb.toString());
	}
}