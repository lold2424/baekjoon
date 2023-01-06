import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {
	
	static int A, B, ans;
	static boolean possible;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		dfs(A, 1);
		
		System.out.println((possible) ? ans : -1);
	}
	
	public static void dfs(long num, int cnt) {
		if(num > B) {
			return;
		}
		if(num == B) {
			ans = cnt;
			possible = true;
			return;
		}
		
		dfs(num * 2, cnt + 1);
		dfs(num * 10 + 1, cnt + 1);
	}
}