import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {
	
	static int blocks[][][] = {
			{{0}, {0, 0, 0, 0}},
			{{0, 0}},
			{{0, 0, 1}, {1, 0}},
			{{1, 0, 0}, {0, 1}},
			{{0, 0, 0}, {0, 1}, {1, 0, 1}, {1, 0}},
			{{0, 0, 0}, {0, 0}, {0, 1, 1}, {2, 0}},
			{{0, 0, 0}, {0, 0}, {1, 1, 0}, {0, 2}}
			};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int C = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken()) - 1;
		
		int[] heights = new int[C];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < C; i++) {
			heights[i] = Integer.parseInt(st.nextToken());
		}
		int ret = 0;
		for (int i = 0; i < blocks[P].length; i++) {
			for (int j = 0; j < C - blocks[P][i].length + 1; j++) {
				int diff = heights[j] - blocks[P][i][0];
				boolean ok = true;
				for (int k = 1; k < blocks[P][i].length; k++) {
					if(diff != heights[j + k] - blocks[P][i][k]){
						ok = false;
						break;
					}
				}
				
				if(ok) {
					ret++;
				}
			}
		}
		
		System.out.println(ret);
	}
}