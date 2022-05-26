import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static int arr[];
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		int i;
		int cnt = 0;
		
		for(i = 1; i <= N ; i++) {
			int sum = 0;
			int count = i;
			
			while(count != 0) {
				sum += count % 10;
				count /= 10;
			}
			if(i + sum == N) {
				arr[cnt] = i;
				cnt++;
			}
		}
		int solution = N;
		
		for(i = 0; i < N; i ++) {
			if(solution > arr[i]) {
				if(arr[i] == 0) {
					break;
				}
				solution = arr[i];
			}
		}
		if(solution == N)	solution = 0;
		System.out.println(solution);
	}
}