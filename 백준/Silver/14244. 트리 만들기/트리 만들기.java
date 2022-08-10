import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < m - 1; ++i) {
			System.out.println(i + " " + (m - 1));
		}
		for(int i = m - 1; i < n - 1; ++i) {
			System.out.println(i + " " + (i + 1));
		}
	}
}