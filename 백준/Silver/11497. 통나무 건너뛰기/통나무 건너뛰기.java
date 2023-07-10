import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			int size = Integer.parseInt(br.readLine());
			int[] numbers = new int[size];
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < size; j++) {
				numbers[j] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(numbers);
			
			int[] temp = new int[size];
			for (int j = 0; j < size; j = j + 2) {
				if (size % 2 == 1) {
					if (j == size - 1) {
						temp[size / 2] = numbers[j];
					} else {
						temp[j / 2] = numbers[j];
						temp[size - 1 - j / 2] = numbers[j + 1];
					}
				} else {
					temp[j / 2] = numbers[j];
					temp[size - 1 - j / 2] = numbers[j + 1];
				}
			}
			
			int maxDifference = Math.abs(temp[0] - temp[size - 1]);
			for (int j = 0; j < size - 1; j++) {
				int difference = Math.abs(temp[j] - temp[j + 1]);
				if (difference > maxDifference) {
					maxDifference = difference;
				}
			}
			
			sb.append(maxDifference).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
