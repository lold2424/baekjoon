import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int TT = 0 ; TT < T ; TT++) {
			int[][] point = new int[4][2];
			
			for(int i = 0 ; i < 4 ; i++) {
				st = new StringTokenizer(br.readLine());
				point[i][0] = Integer.parseInt(st.nextToken());
				point[i][1] = Integer.parseInt(st.nextToken());
			}
			
			long[][] len = new long[4][4];
			long[][] save = new long[4][3];
			for(int i = 0 ; i < 4 ; i++) {
				long[] tmp = new long[3];
				for(int j = 0 ; j < 4 ; j++) {
					if(i == j)
						continue;
					long x = (long)Math.pow(point[i][0] - point[j][0], 2);
					long y = (long)Math.pow(point[i][1] - point[j][1], 2);
					len[i][j] = x + y;
				}
				boolean check = false;
				boolean fail = false;
				int index = 0;
				for(int j = 0 ; j < 4 ; j++) {
					if(len[i][j] == 0) {
						if(check) {
							fail = true;
							break;
						}
						check = true;
						continue;
					}
					tmp[index++] = len[i][j];
				}
				
				if(fail) {
					System.out.println(0);
					break;
				}
				
				save[i][0] = tmp[0];
				save[i][1] = tmp[1];
				save[i][2] = tmp[2];
			}
			
			long l = 0;
			if(save[0][0] == save[0][1] || save[0][0] == save[0][2])
				l = save[0][0];
			else if(save[0][1] == save[0][2])
				l = save[0][1];
			else {
				System.out.println(0);
				continue;
			}
			
			boolean check = false;
			for(int i = 0 ; i < 4 ; i++) {
				int count = 0;
				int tmp = 0;
				for(int j = 0 ; j < 3 ; j++)
					if(save[i][j] == l)
						count++;
					else
						tmp += save[i][j];
				
				if(count != 2 || (2*l) != tmp) {
					System.out.println(0);
					check = true;
					break;
				}
			}
			if(!check)
				System.out.println(1);
		}
	}
}