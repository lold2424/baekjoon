import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		
		int arr[] = new int[str.length()];
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			arr[i] = str.charAt(i) - 48;
			count += arr[i];
		}
		
		Arrays.sort(arr);
		
		if ((count % 3 == 0) && (arr[0] == 0)) {
			for(int i = str.length() - 1; i > -1; i --) {
				System.out.print(arr[i]);
			}
		} else System.out.println(-1);

	}
}