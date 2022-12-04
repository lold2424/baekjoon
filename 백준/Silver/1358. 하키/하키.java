import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		int x_end = X + W;
		int y_end = Y + H;
		int r = H / 2;
		int Y_half = Y + r;
		int x, y, cnt = 0;
		
		for(int i = 0; i < P; ++ i) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			
			if((X <= x && x <= x_end && Y <= y && y <= y_end) || getDistance(x, y, X, Y_half) <= r || getDistance(x, y, x_end, Y_half) <= r) {
				cnt ++;
			}
		}
		
		System.out.println(cnt);
	}
	public static double getDistance(int x1, int y1, int x2, int y2) {
		return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
	}
}