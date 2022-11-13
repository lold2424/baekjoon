import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	
	static int map[];
	static int N;
	static int answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N];
		
		backtrack(0);
		System.out.println(answer);
	}
	
	static void backtrack(int low) {
		if(low == N) {
			answer ++;
			return;
		}
		for(int j = 0; j < N; j++) {
			map[low] = j;
			if(unique(low)) {
				backtrack(low + 1);
			}
		}
	}
	
	static  boolean unique(int col) {
		for(int i = 0; i < col; i++) {
			if(map[col] == map[i]) 
				return false;
			if(Math.abs(col - i) == Math.abs(map[i] - map[col])) {
				return false;
			}
		}
		return true;
	}
}