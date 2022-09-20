import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.HashMap;;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			int key = Integer.parseInt(st.nextToken());
			map.put(key, map.getOrDefault(key, 0) + 1);
		}
		
		int M = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < M; i++) {
			int key = Integer.parseInt(st.nextToken());
			
			sb.append(map.getOrDefault(key, 0)).append(" ");
		}
		System.out.println(sb);
	}
}