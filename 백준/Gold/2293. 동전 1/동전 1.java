import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
import java.util.StringTokenizer;

public class Main {
	
	static int n, k;
	static int num[], dp[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		num = new int[n + 1];	// 동전의 가치를 넣어줄 배열
		dp = new int[k + 1];	// 가치별 경우의 수를 저장할 배열
		dp[0] = 1;				// 입력한 동전 중 하나만으로 표현할 때
		
		for (int i = 1; i <= n; i++) {
			num[i] = Integer.parseInt(br.readLine());	// 동전의 가치를 배열에 넣어줌
			for (int j = num[i]; j <= k; j++) {			// 동전의 가치가 목표 가치보다 작으면 동전 가치만큼 더해줌
				dp[j] += dp[j - num[i]];				// 가치별 경우의 수를 dp배열에 추가하며 진행
			}
		}
		
		System.out.println(dp[k]);
	}
}
