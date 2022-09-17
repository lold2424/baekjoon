import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		while(T-- > 0) {
			String op = br.readLine();
			int n = Integer.parseInt(br.readLine());
			String[] arr = br.readLine().replace("[", "").replace("]", "").split(",");
			sb.append(acFunction(op,n,arr));
			if(T != 0) sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	static String acFunction(String op, int n, String[] arr) {
		Deque<Integer> q = new ArrayDeque<>();
		
		for(int i = 0; i < n; i++) {
			q.offer(Integer.parseInt(arr[i]));
		}
		
		boolean dir = true;
		
		for(int i = 0; i < op.length(); i++) {
			char type = op.charAt(i);
			
			if(type == 'R') {
				dir = !dir;
			}
			
			else {
				if(q.isEmpty()) {
					return "error";
				}
				
				if(dir) {
					q.pollFirst();
				}
				
				else {
					q.pollLast();
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		
		while(!q.isEmpty()) {
			if(dir) {
				sb.append(q.poll());
				
			}
			
			else {
				sb.append(q.pollLast());
			}
			
			if(!q.isEmpty()) sb.append(",");
		}
		
		sb.append("]");
		return sb.toString();
	}
}