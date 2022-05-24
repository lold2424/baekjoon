import java.io.*;
import java.util.Queue;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> que = new LinkedList<>();
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= N; i ++) {
			que.offer(i);
		}
		
		StringBuilder sb = new StringBuilder();
		
		while(!que.isEmpty()){
			sb.append(que.poll()).append(" ");
			if(que.isEmpty()) {
				break;
			}
			que.offer(que.poll());
		}
		System.out.println(sb.toString());	
	}
}