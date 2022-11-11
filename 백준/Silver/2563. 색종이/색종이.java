import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {
	
	static int map[][];
	static int cnt = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int N = Integer.parseInt(br.readLine());
		
		map = new int[101][101];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			for(int j = a; j < a + 10; j++) {
				for(int  k = b; k < b + 10; k++) {
					if(map[j][k] == 0) {
						map[j][k] = 1;
						cnt ++;
					}
				}
			}
		}
		
		sb.append(cnt);
		System.out.println(sb);
	}
}