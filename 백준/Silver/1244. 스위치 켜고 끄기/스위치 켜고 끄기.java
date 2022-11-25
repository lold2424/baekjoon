import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int total = Integer.parseInt(br.readLine());
		int[] switches = new int[total];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<total; i++)
			switches[i] = Integer.parseInt(st.nextToken());
		
		int stuCnt = Integer.parseInt(br.readLine());
		for(int i=0; i<stuCnt; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int number = Integer.parseInt(st.nextToken());
			
			if(gender == 1) {
				for(int j=0; j<total; j++)
					if((j+1) % number == 0)
						switches[j] = switches[j] == 0? 1: 0;
			} else {
				switches[number - 1] = switches[number - 1] == 0 ? 1 : 0;
				for(int j=1; j<total/2; j++) {
					if(number - 1 + j >= total || number - 1 - j < 0)
						break;
					if(switches[number - 1 - j] == switches[number - 1 + j]) {
						switches[number - 1 - j] = switches[number - 1 - j] == 0 ? 1 : 0;
						switches[number - 1 + j] = switches[number - 1 + j] == 0 ? 1 : 0;
					} else break;
				}
			}
		}
		
		for(int i=0; i<total; i++) {
			System.out.print(switches[i] + " ");
			if((i+1) % 20 == 0) {
				System.out.println();
			}
		}
	}
}