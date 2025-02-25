import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) throws IOException{
		int[] level;
		level = input();
		int n = level.length;
		System.out.println(trimmedMean(n, level));
	}
	
	public static int[] input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] level = new int[n];
		
		for (int i = 0; i < n; i ++) {
			level[i] = Integer.parseInt(br.readLine());
		}
		return level;
	}
	
	public static int trimmedMean(int n, int[] level) {
		if (n == 0) {
			return 0;
		}
		
		Arrays.sort(level);
		int rounding = (int) Math.round(n * 0.15);
		int sum = 0;
		int count = n - (rounding * 2);
		
		for (int i = rounding; i < n - rounding; i ++) {
			sum += level[i];
		}
		return (int) Math.round((double) sum / count);
	}
}
