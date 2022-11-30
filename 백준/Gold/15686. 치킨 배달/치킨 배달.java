import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static class Info {
		int y, x;

		public Info(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}
	public static int N, M, answer;
	public static boolean[] isSelected;
	public static List<Info> chickenList;
	public static List<Info> homeList;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		chickenList = new ArrayList<Info>();
		homeList = new ArrayList<Info>();
		
		for (int i = 1; i <= N; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			
			for (int j = 1; j <= N; ++j) {
				int type = Integer.parseInt(st.nextToken());
				
				if (type == 1) {
					homeList.add(new Info(i, j));
				}
				else if (type == 2) {
					chickenList.add(new Info(i, j));
				}
			}
		}
		
		isSelected = new boolean[chickenList.size()];
		answer = Integer.MAX_VALUE;
		go(0, 0);
		
		System.out.println(answer);
	}
	
	public static void go(int cnt, int idx) {
		if (cnt == M) {
			int totalDist = 0;
			
			for (int i = 0; i < homeList.size(); ++i) {
				Info home = homeList.get(i);
				int minDist = Integer.MAX_VALUE;
				for (int j = 0; j < chickenList.size(); ++j) {
					if (!isSelected[j]) {
						continue;
					}
					
					Info chicken = chickenList.get(j);
					int dist = Math.abs(home.y - chicken.y) + Math.abs(home.x - chicken.x);
					minDist = (minDist > dist) ? dist : minDist;
				}
				
				totalDist += minDist;
			}
			
			answer = (answer > totalDist) ? totalDist : answer;
			return;
		}
		
		for (int i = idx; i < chickenList.size(); ++i) {
			isSelected[i] = true;
			go(cnt + 1, i + 1);
			isSelected[i] = false;
		}
	}
}