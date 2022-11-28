import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main {
	
	static int k;
	static int s[];
	static boolean cheak[];
	
	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			StringTokenizer st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			if(k == 0) break;
			s = new int[k];
			cheak = new boolean[k];
			for(int i = 0; i < k; i++){
				s[i] = Integer.parseInt(st.nextToken());
			}
			
			dfs(0,0);
			System.out.println();
		}
	}

	public static void dfs(int depth, int start){
		if(depth == 6){
			for(int i = 0; i < k; i++){
				if(cheak[i]){
					System.out.printf("%d ", s[i]);
				}
			}
			System.out.println();
		}
		for(int i = start;i<k;i++){
			cheak[i] = true;
			dfs(depth + 1, i + 1);
			cheak[i] = false;
		}
	}
}