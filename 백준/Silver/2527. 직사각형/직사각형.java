import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int f_dx = 0; int f_dy = 0; int f_ux = 0; int f_uy = 0;
		int s_dx = 0; int s_dy = 0; int s_ux = 0; int s_uy = 0;
		
		for(int tc = 1; tc <= 4; tc++) {
			st = new StringTokenizer(br.readLine());
			f_dx = Integer.parseInt(st.nextToken());
			f_dy = Integer.parseInt(st.nextToken());
			f_ux = Integer.parseInt(st.nextToken());
			f_uy = Integer.parseInt(st.nextToken());
			
			s_dx = Integer.parseInt(st.nextToken());
			s_dy = Integer.parseInt(st.nextToken());
			s_ux = Integer.parseInt(st.nextToken());
			s_uy = Integer.parseInt(st.nextToken());
			
			if((f_ux == s_dx && f_uy == s_dy) || (f_dx == s_ux && f_uy == s_dy) || (f_dx == s_ux && f_dy == s_uy) || (f_ux == s_dx && f_dy == s_uy)){		// 점 -> 4가지 경우
				System.out.println("c");
			} else if(f_uy<s_dy || f_ux<s_dx || s_uy<f_dy || s_ux<f_dx) {													// 안겹치는 경우 -> 4개로 가능
				System.out.println("d");							
			} else if(f_ux == s_dx || f_uy == s_dy || f_dx == s_ux || f_dy == s_uy) {												// 선 -> 4가지 경우
				System.out.println("b");
			} else {
				System.out.println("a");
			}																												// 겹치는 경우 -> 따져야되는 상황 복잡																													// 안겹치는 경우 -> 4개로 가능 
		}
	}
}