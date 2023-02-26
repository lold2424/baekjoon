import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String[] a = new String[N];
		String[][] st = new String[N][N];

		int cnt = 0;
		int cnt2= 0;
		int output = 0;
		int output2 = 0;
		
		for (int i = 0; i < N; i ++) {
			a[i] = br.readLine();
			for (int j = 0; j < N; j ++) {
				st[i][j] = String.valueOf(a[i].charAt(j));
			}
		}
		
		for (int i = 0; i < N; i ++) {
			for (int j = 0; j < N; j ++) {
				if (st[i][j].equals(".")) {
					cnt ++;
					if (j == N - 1) {
						if (cnt >= 2) output ++;
						cnt = 0;
					}
				} else if (st[i][j].equals("X")) {
					if (cnt >= 2) output ++;
					cnt = 0;
				}
			}
		}
		
		for (int i = 0; i < N; i ++) {
			for (int j = 0; j < N; j ++) {
				if (st[j][i].equals(".")) {
					cnt2 ++;
					if (j == N - 1) {
						if (cnt2 >= 2) output2 ++;
						cnt2 = 0;
					}
				} else if (st[j][i].equals("X")) {
					if (cnt2 >= 2) output2 ++;
					cnt2 = 0;
				}
			}
		}
	
		System.out.printf("%d %d", output, output2);
	}
}