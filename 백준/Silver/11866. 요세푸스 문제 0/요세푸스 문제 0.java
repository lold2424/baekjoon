import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Queue<Integer> que = new LinkedList<>();
		StringBuffer sb = new StringBuffer();
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		
		for(int i = 1; i < N + 1; i++) {
			que.add(i);
		}
		
		sb.append('<');
		
		while(que.size() > 1) {
			for(int j = 0; j < K - 1; j++)	que.offer(que.poll());
			
			sb.append(que.poll() + ", ");
		}
		
		sb.append(que.poll() + ">");
		
		System.out.println(sb);
	}
}