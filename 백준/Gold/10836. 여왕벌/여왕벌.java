import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {
	
	static int arrSize;
	static int dateCount;
	static int[] values;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		String[] input = str.split(" ");
		
		int calVal = Integer.parseInt(input[0]);
		arrSize = (2 * calVal) - 1;
		values = new int[arrSize];
		dateCount = Integer.parseInt(input[1]);
		long time = System.currentTimeMillis();
		
		for(int i = 0; i < dateCount; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int startPoint =Integer.parseInt(st.nextToken());
			int onePoint = Integer.parseInt(st.nextToken());
			
			for(int j = startPoint; j < startPoint + onePoint; j++){
				values[j] = values[j] + 1;
			}
			
			for(int j = startPoint + onePoint; j < arrSize; j++){
				values[j] = values[j] + 2;
			}
			
		}
		
		String temp = String.valueOf(values[calVal] + 1);
		
		for (int i = calVal + 1; i < arrSize; i++){
			temp += (" " + (values[i] + 1));
		}
		
		for(int i = calVal - 1; i >= 0; i--){
			System.out.print((values[i] + 1) + " " + temp);
			System.out.println();
		}
	}
}