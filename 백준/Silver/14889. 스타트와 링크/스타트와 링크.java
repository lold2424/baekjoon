import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[][] map;
	static boolean[] visited;
	static int different = 2147483647;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N + 1][N + 1];
		visited = new boolean[N + 1];
		
		for(int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j < N + 1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		backTracking(0, 1);
		
		System.out.println(different);
	}
	
	static void backTracking(int d, int index) {
		
		if(d == N / 2) {
			teamStat();
			return;
		}
		
		for(int i = index; i < N + 1; i++) {
			if(!visited[i]) {
				visited[i] = true;
				backTracking(d + 1, i + 1);
				visited[i] = false;
			}
		}
		
	}
	
	static void teamStat() {
		
		List<Integer> startTeam = new ArrayList<Integer>();
		List<Integer> linkTeam = new ArrayList<Integer>();
		
		for(int i = 1; i < N + 1; i++) {
			
			if(visited[i]) startTeam.add(i);
			
			else linkTeam.add(i);
		}
		
		int startTeamStat = 0;
		int linkTeamStat = 0;
		
		for(int i = 0; i < startTeam.size(); i++) {
			for(int j = i + 1; j < startTeam.size(); j++) {
				startTeamStat += map[startTeam.get(i)][startTeam.get(j)];
				startTeamStat += map[startTeam.get(j)][startTeam.get(i)];
				
				linkTeamStat += map[linkTeam.get(i)][linkTeam.get(j)];
				linkTeamStat += map[linkTeam.get(j)][linkTeam.get(i)];
			}
		}
		
		different = Math.min(Math.abs(startTeamStat - linkTeamStat), different);
	}
}