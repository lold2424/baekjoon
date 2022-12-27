import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] vote = new int[101];
		int[] when = new int[101];
		boolean[] place = new boolean[101];
		int cnt = 0;
		
		for(int i = 1; i <= m; i++) {
			int x = Integer.parseInt(st.nextToken());
			vote[x] ++;			
			if(!place[x]) {
				when[x] = i;
				if(cnt >= n) {
					int del = 10000;
					int w = 10000;
					int t = 0;
					for(int j = 1; j <= 100; j++) {
						if(place[j]) {
							if(del > vote[j]) {
								t = j;
								w = when[j];
								del = vote[j];
							} else if(del == vote[j]) {
								if(w > when[j]) {
									t = j;
									w = when[j];
									del = vote[j];
								}
							}
						}
					}
					place[t] = false;
					vote[t] = 0;
				} else {
					cnt++;
				}
				place[x] = true;
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= 100; i++) {
			if(place[i]) {
				sb.append(i + " ");
			}
		}
		System.out.println(sb.toString());
	}
}