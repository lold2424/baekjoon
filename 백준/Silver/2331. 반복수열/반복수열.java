import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		HashMap<Integer, Integer> map = new HashMap<>();
		
		int count = 0;
		int nextNumber = A;
		
		while (!map.containsKey(nextNumber)) {
			map.put(nextNumber, count++);
			nextNumber = getNextNumber(nextNumber, P);
		}
		
		System.out.println(map.get(nextNumber));
	}
	
	static int getNextNumber(int number, int power) {
		int sum = 0;
		
		while (number != 0) {
			int digit = number % 10;
			int tmp = digit;
			
			for (int i = 0; i < power - 1; i++) {
				tmp *= digit;
			}
			
			sum += tmp;
			number /= 10;
		}
		
		return sum;
	}
}
