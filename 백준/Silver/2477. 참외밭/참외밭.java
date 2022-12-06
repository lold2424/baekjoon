import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] input = new int[6];
		int maxRow = 0, maxCol = 0;
		int indexRow = 0, indexCol = 0;

		for(int i = 0; i < 6; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int direction = Integer.parseInt(st.nextToken());
			int length = Integer.parseInt(st.nextToken());
			if(direction == 3 || direction == 4) {
				maxRow = (maxRow < length) ? length : maxRow;
				if(maxRow == length) indexRow = i;
			} else {
				maxCol = (maxCol < length) ? length : maxCol;
				if(maxCol == length) indexCol = i;
			}
			
			input[i] = length;
			
		}
		int nextR1 = input[5], nextC1 = input[5];
		int nextR2 = input[0], nextC2 = input[0];
		if(indexCol - 1 > -1) nextR1 = input[indexCol - 1];
		if(indexCol + 1 < 6) nextR2 = input[indexCol + 1];
		if(indexRow - 1 > -1) nextC1 = input[indexRow - 1];
		if(indexRow + 1 < 6) nextC2 = input[indexRow + 1];
		
		int area = maxCol * Math.min(nextR1, nextR2) + Math.min(nextC1, nextC2) * (maxRow - (Math.min(nextR1, nextR2)));
		
		System.out.println(area * N);

	}
}