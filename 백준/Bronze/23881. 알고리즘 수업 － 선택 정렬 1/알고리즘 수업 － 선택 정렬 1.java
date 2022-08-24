import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;

import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int cnt = 0;
		boolean isFind = false;
		
		for(int i = N - 1; i > 0; --i) {
			int target = i;
			int max = arr[i];
			for(int j = i - 1; j >= 0; --j) {
				if(max < arr[j]) {
					max = arr[j];
					target = j;
				}
			}
			if(target != i) {
				int tmp = arr[i];
				arr[i] = arr[target];
				arr[target] = tmp;
				++cnt;
				if(cnt == K) {
					System.out.println(tmp + " " + arr[i]);
					isFind = true;
					break;
				}
			}
		}
		if(!isFind) {
			System.out.println(-1);
		}
	}
}