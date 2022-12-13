import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int x1, x2, x3, y1, y2, y3;
		
		x1 = Integer.parseInt(st.nextToken());
		y1 = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		x2 = Integer.parseInt(st.nextToken());
		y2 = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		x3 = Integer.parseInt(st.nextToken());
		y3 = Integer.parseInt(st.nextToken());
		
		
		int temp = x1 * y2 + x2 * y3 + x3 * y1 - x2 * y1 - x3 * y2 - x1 * y3;
		
		if(temp > 0) {
			System.out.println("1");
		} else if(temp < 0) {
			System.out.println("-1");
		} else {
			System.out.println("0");
		}
	}
}