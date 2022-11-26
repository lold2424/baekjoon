import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main{
	
	static int map[][] = new int[5][5];
	static boolean find = false;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 5; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		int check[] = new int[25];
		int idx = 0;
		for(int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 5; j++)
				check[idx++] = Integer.parseInt(st.nextToken());
		}
		
		for(int z = 0; z < 25; z++) {	
			for(int i = 0; i < 5; i++) {
				for(int j = 0; j < 5; j++) {
					if(map[i][j] == check[z]) {
						map[i][j] = 0;
						break;
					}
				}
			}
			
			findBingo();
			if(find) {
				System.out.println(z+1);
				break;
			}
		}
	}
	
	static void findBingo() {
		int cnt = 0;
		int sum = 0;
		
		for(int i = 0; i < 5; i++) {
			sum = 0;
			for(int j = 0; j < 5; j++)
				sum += map[i][j];
			if(sum == 0) cnt++;
		}
		
		for(int i = 0; i < 5; i++) {
			sum = 0;
			for(int j = 0; j < 5; j++)
				sum += map[j][i];
			if(sum == 0) cnt++;
		}
		
		sum = 0;
		for(int i = 0; i < 3; i++) {
			sum += map[2 - i][2 + i];
			sum += map[2 + i][2 - i];
		}
		if(sum == 0) cnt++;
		
		sum = 0;
		for(int i = 0; i < 3; i++) {
			sum += map[2 + i][2 + i];
			sum += map[2 - i][2 - i];
		}
		if(sum == 0) cnt++;
		
		if(cnt >= 3)
			find = true;
	}
}