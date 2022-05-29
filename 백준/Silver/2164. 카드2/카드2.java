import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Queue<Integer> que = new LinkedList<>();
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= N; i++) {
			que.offer(i);
		}
		
		while(que.size() > 1) {
			que.poll();	// 맨 앞의 원소 제거
			que.offer(que.poll());	// 맨 앞 원소 제거하면서 제거한 원소 맨 뒤에 삽입
		}
		
		System.out.println(que.poll());		// 마지막 원소 출력
		
	}

}
