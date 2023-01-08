import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import java.util.ArrayDeque;
import java.util.Deque;
 
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		String input = br.readLine();
		
		char[] arr = input.toCharArray();
		Deque<Character> dq = new ArrayDeque<>();
		for (int i = 0; i < arr.length; i++) {
			while (K > 0 && !dq.isEmpty() && dq.getLast() < arr[i]) {
				dq.removeLast();
				K--;
			}
			dq.addLast(arr[i]);
		}
		StringBuilder sb = new StringBuilder();
		
		while (dq.size() > K) {
			sb.append(dq.removeFirst());
		}
		
		System.out.println(sb.toString());
	}
}