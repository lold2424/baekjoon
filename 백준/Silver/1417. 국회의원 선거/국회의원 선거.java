import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Arrays;

public class Main {

	static int sup[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		sup = new int[N - 1];
		
		int dasom = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N - 1; i++) {
			int num = Integer.parseInt(br.readLine()); 
			sup[i] = num;
		}
		
		int count = 0;
		
		if(N == 1) {
			System.out.println("0");
			return;
		}
		
		while(true) {
			Arrays.sort(sup);
			boolean flag = true;
			int last = sup.length - 1;
			
			if(dasom <= sup[last]) {
				dasom ++;
				sup[last] --; 
				count ++;
				flag = false;
			}
			
			if(flag) {
				break;
			}
		}
		
		System.out.println(count);
	}
}