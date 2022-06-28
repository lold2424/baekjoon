import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {
	static ArrayList<Integer>[] a;	// 리스트 생성
	static boolean visit[];	// 정점 탐색여부 체크
	static int computer, connect, start;		// 정점, 간선, 시작 정점
	static int count = 0;	// 정점과 연결된 바이러스 걸리는 컴퓨터 수
	
	public static int dfs(int i) {
		visit[i] = true;
		for(int k : a[i]) {	// 향상된 for문 사용
			if(visit[k] == false) {
				count ++;
				dfs(k);
			}
		}
		return count;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		computer = Integer.parseInt(br.readLine());	// 컴퓨터 수(정점)
		connect = Integer.parseInt(br.readLine());	// 연결된 컴퓨터 쌍의 수(간선)
		start = 1;	// 탐색 시장할 정점의 번호
		visit = new boolean[computer + 1];	// 정점의 탐색 여부 체크

		a = new ArrayList[computer + 1];	// 인덱스 편의상 computer + 1설정, 0번째 요소는 사용 X
		visit = new boolean[computer + 1];
		for(int i = 1; i <= computer; i++) {
			a[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0; i < connect; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int b = Integer.parseInt(st.nextToken());	// 간선으로 이어진 정점1
			int c = Integer.parseInt(st.nextToken());	// 정점1과 간선으로 이어진 정점2
			a[b].add(c);
			a[c].add(b);
		}
		
		System.out.println(dfs(start));
	}
}
