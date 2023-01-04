import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.List;

public class Main {
	
	static int N, ans;
	static ArrayList<Pair> tree[];
	static boolean visited[];
	static ArrayList<Integer> leaf = new ArrayList<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		tree = new ArrayList[N + 1];
		visited = new boolean[N + 1];
		
		for(int i = 1; i <= N; i++) {
			tree[i] = new ArrayList<>();
		}
		for(int i = 0; i< N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			tree[a].add(new Pair(b, c));
			tree[b].add(new Pair(a, c));
		}
		
		for(int i = 2; i <= N; i++) {
			if(tree[i].size() < 2) {
				leaf.add(i);
			}
		}
		
		for(int i = 0; i < leaf.size(); i++) {
			visited = new boolean[N + 1];
			visited[leaf.get(i)] = true;
			dfs(leaf.get(i), 0, leaf.get(i));
		}
		
		System.out.println(ans);
		
	}
	
	static void dfs(int idx, int sum, int start) {
		if(tree[idx].size() == 1 && idx != start) {
			ans = Math.max(ans,sum);
			return;
		}
		
		for(int i = 0; i < tree[idx].size(); i++) {
			int next = tree[idx].get(i).num;
			if(!visited[next]) {
				visited[next] = true;
				dfs(next, sum+tree[idx].get(i).len, start);
			}
		}
	}
	
	static class Pair{
		int num, len;
		Pair(int a, int b){
			this.num = a;
			this.len = b;
		}
	}
}