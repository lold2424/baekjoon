import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Set<String> set = new HashSet<String>();
		ArrayList<String> arr = new ArrayList<String>();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			set.add(br.readLine());
		}
		
		for (int i = 0; i < M; i++) {
			String tmp = br.readLine();
			if(set.contains(tmp)) {
				arr.add(tmp);
			}
		}
		
		Collections.sort(arr);
		System.out.println(arr.size());
		
		for (int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i));
		}
	}
}