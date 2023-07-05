import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
	
public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		
		if (K >= N) {
			bw.write("0\n");
			bw.close();
			br.close();
			return;
		}
		
		int[] censor = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(st.nextToken());
			censor[i] = temp;
		}
		Arrays.sort(censor);
		
		int[] dif = new int[N - 1];
		for (int i = 0; i < N - 1; i++) {
			dif[i] = censor[i + 1] - censor[i];
		}
		Arrays.sort(dif);
		
		int ans = 0;
		for (int i = 0; i < N - K; i++) {
			ans += dif[i];
		}
		
		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}