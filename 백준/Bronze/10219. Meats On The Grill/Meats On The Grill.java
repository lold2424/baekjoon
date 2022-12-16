import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(reader.readLine());
		for (int i = 0; i < T; i++) {
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			int H = Integer.parseInt(tokenizer.nextToken());
			int W = Integer.parseInt(tokenizer.nextToken());

			StringBuilder builder = new StringBuilder();
			for (int j = 0; j < H; j++) {
				builder.append(new StringBuilder(reader.readLine()).reverse());
				builder.append("\n");
			}
			System.out.println(builder.toString());
		}
	}
}