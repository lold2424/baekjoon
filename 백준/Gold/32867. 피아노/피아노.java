import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] notes = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++){
			notes[i] = Integer.parseInt(st.nextToken());
		}
		
		int segments = 0;
		int left = 0, right = 0;
		
		Deque<Integer> dqMax = new ArrayDeque<>();
		Deque<Integer> dqMin = new ArrayDeque<>();
		
		while (left < N) {
			while (right < N) {
				while (!dqMax.isEmpty() && notes[dqMax.peekLast()] <= notes[right]){
					dqMax.pollLast();
				}
				dqMax.offerLast(right);
				
				while (!dqMin.isEmpty() && notes[dqMin.peekLast()] >= notes[right]){
					dqMin.pollLast();
				}
				dqMin.offerLast(right);
				
				if (notes[dqMax.peekFirst()] - notes[dqMin.peekFirst()] <= K - 1) {
					right++;
				} else {
					if (!dqMax.isEmpty() && dqMax.peekLast() == right) dqMax.pollLast();
					if (!dqMin.isEmpty() && dqMin.peekLast() == right) dqMin.pollLast();
					break;
				}
			}
			segments++;
			left = right;
			dqMax.clear();
			dqMin.clear();
		}
		
		System.out.println(segments - 1);
	}
}
