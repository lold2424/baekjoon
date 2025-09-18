import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		PriorityQueue<Double> que = new PriorityQueue<Double>();
		
		int N = Integer.parseInt(br.readLine().trim());
		
		for (int i = 0; i < N; i ++) {
			que.add(Double.parseDouble(br.readLine().trim()));
		}
		
		for (int i = 0; i < N - 1; i ++) {
			double A = que.poll();
			double B = que.poll();
			
			que.add((A + B) / 2);
		}
				
		System.out.printf("%.6f\n", que.poll());
	}
}
