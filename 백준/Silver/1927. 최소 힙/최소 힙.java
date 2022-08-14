import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
		int N = Integer.parseInt(in.readLine());
		PriorityQueue<Integer> queue = new PriorityQueue<>();
        
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(in.readLine());
            
			if(num == 0) {
				if(!queue.isEmpty())
					System.out.println(queue.poll());
				else
					System.out.println(0);
				continue;
			}
            
			queue.add(num);
		}
	}
}