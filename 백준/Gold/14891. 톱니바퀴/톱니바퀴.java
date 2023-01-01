import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {
	
	static int[][] gears;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		gears = new int[4][8];
		
		for(int i = 0; i < 4; i++) {
			String s = br.readLine();
			for(int j = 0; j < 8; j++) {
				gears[i][j] = s.charAt(j) - '0';
			}
		}
		
		int K = Integer.parseInt(br.readLine());
		while(K-- > 0) {
			st = new StringTokenizer(br.readLine());
			int G = Integer.parseInt(st.nextToken()) - 1;
			int D = Integer.parseInt(st.nextToken());
			int[] rotate = new int[4];
			rotate[G] = D;
			int gearLeft = G - 1;
			int gearRight = G + 1;
			
			while(gearLeft >= 0 && gears[gearLeft][2] != gears[gearLeft + 1][6]) {
				rotate[gearLeft] = -1 * rotate[gearLeft + 1];
				gearLeft--;
				}
			
			while(gearRight < 4 && gears[gearRight][6] != gears[gearRight - 1][2]) {
				rotate[gearRight] = -1 * rotate[gearRight - 1];
				gearRight++;
				}
			
			for(int i = 0; i < 4; i++) {
				if(rotate[i] == 1) {
					int temp = gears[i][7];
					for(int j = 7; j > 0; j--) {
						gears[i][j] = gears[i][j - 1];
					}
					gears[i][0] = temp;
				} else if(rotate[i] == -1) {
					int temp = gears[i][0];
					for(int j = 0; j < 7; j++) {
						gears[i][j] = gears[i][j + 1];
					}
					gears[i][7] = temp;
				}
			}
		}
		
		int sum = 0;
		if(gears[0][0] == 1) {
			sum += 1;
		}
		if(gears[1][0] == 1) {
			sum += 2;
		}
		if(gears[2][0] == 1) {
			sum += 4;
		}
		if(gears[3][0] == 1) {
			sum += 8;
		}
		
		System.out.println(sum);
	}
}