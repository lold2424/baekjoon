import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[][] nodes;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		nodes = new int[N][2];
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i ++) {
			nodes[i][0] = Integer.parseInt(st.nextToken());
		}
		
		getChildNum();
		remove(Integer.parseInt(br.readLine()));
		System.out.println(getAnswer());
	}

	private static int getAnswer() {
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			if(nodes[i][0] != -2 && nodes[i][1] == 0) {
				cnt++;
			}
		}
		return cnt;
	}

	private static void remove(int num) {
		if(nodes[num][0] != -1) {
			nodes[nodes[num][0]][1] --;
		}
		nodes[num][0] = -2;
		if(nodes[num][1] > 0) {
			for(int i = 0; i < N; i ++) {
				if(nodes[i][0] == num) {
					remove(i);
				}
			}
		}
	}

	private static void getChildNum() {
		for(int i = 0; i < N; i ++) {
			for(int j = 0; j < N; j++) {
				if(nodes[j][0] == i) nodes[i][1] ++;
			}
		}
	}
}