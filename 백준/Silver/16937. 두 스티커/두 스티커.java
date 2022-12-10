import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(br.readLine());
		
		int max = 0;
		int[][] sticker = new int[N][2];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			sticker[i][0] = Integer.parseInt(st.nextToken());
			sticker[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int a1, a2, b1, b2;
		for(int i = 0; i < N - 1; i++) {
			a1=sticker[i][0];
			b1=sticker[i][1];
			
			for(int j = i + 1; j < N; j++) {
				a2=sticker[j][0];
				b2=sticker[j][1];
				
				if(stick(a1, b1, H, W)) {
					if(stick(a2, b2, H - a1, W) || stick(a2, b2, H, W - b1)) {
						max = Math.max(max, a1 * b1 + a2 * b2);
                        continue;
					}
					if(stick(b2, a2, H - a1, W) || stick(b2, a2, H, W - b1)) {
						max = Math.max(max, a1 * b1 + a2 * b2);
                        continue;
					}
				}
				
				if(stick(b1, a1, H, W)) {
					if(stick(a2, b2, H - b1, W) || stick(a2, b2, H, W - a1)) {
						max = Math.max(max, a1 * b1 + a2 * b2);
                        continue;
					}
					if(stick(b2, a2, H - b1, W) || stick(b2, a2, H, W - a1)) {
						max = Math.max(max, a1 * b1 + a2 * b2);
                        continue;
					}
				}
			}
		}
		System.out.println(max);
	}
	
	public static boolean stick(int a,int b, int H,int W) {
		if(a <= H && b <= W) {
			return true;
		}
		return false;
	}
}