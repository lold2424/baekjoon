import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, T, P, sizeCnt = 6;
	static int[] size = new int[sizeCnt];
	
	public static void main(String[] args) throws IOException {
		input();
		shirt();
		pen();
	}
	
	public static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < sizeCnt; i ++) {
			size[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		
		T = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
	}
	
	public static void shirt() {
		int shirtCnt = 0;
		
		for (int i = 0; i < sizeCnt; i ++) {
			if (size[i] % T == 0) {
				shirtCnt += size[i] / T;
			}
			else {
				shirtCnt += ((size[i] / T) + 1);
			}
		}
		
		System.out.println(shirtCnt);
	}
	
	public static void pen() {
		int share = 0, remainder = 0;
		
		share = N / P;
		remainder = N % P;
		System.out.printf("%d %d", share, remainder);
	}
}
