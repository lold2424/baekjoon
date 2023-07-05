import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		int[] dist = new int[N - 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		for (int i = 0; i < N - 1; i++) {
			dist[i] = arr[i + 1] - arr[i];
		}
		
		Arrays.sort(dist);
		int rst = 0;
		
		for (int i = 0; i < N - K; i++) {
			rst += dist[i];
		}

		System.out.println(rst);
	}
}