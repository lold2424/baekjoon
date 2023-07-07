import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = 0, M = 0, R = 0, start = 0, end = 0, order = 1, front = 0, num = 0;
		int[] res;
		boolean visited[];
		List<List<Integer>> list = new ArrayList<>();
		Queue<Integer> que = new LinkedList<Integer>();
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i <= N; i++)
			list.add(new ArrayList<>());
		visited = new boolean[N + 1];
		res = new int[N + 1];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			
			list.get(start).add(end);
			list.get(end).add(start);
		}
		
		for(int i = 0; i < list.size(); i++)
			Collections.sort(list.get(i));
		
		que.add(R);
		visited[R] = true;
		res[R] = order++;
		
		while(!que.isEmpty()) {
			front = que.poll();
			
			for(int i = 0 ; i < list.get(front).size(); i++) {
				num = list.get(front).get(i);
				if(visited[num] == false) {
					visited[num] = true;
					que.add(num);
					res[num] = order++;
				}
			}
		}
		
		for(int i = 1; i < res.length; i++)
			sb.append(res[i]).append("\n");
		
		System.out.println(sb);
	}
}