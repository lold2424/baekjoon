import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
static int net[][];	// 컴퓨터의 네트워크가 연결되어 어떻게 연결되어 있는지 저장할 배열
static boolean visit[];	// 연결이 되어있는지 참, 거짓으로 판별할 배열이다.
static int computer, connect, start;	// 각각의 컴퓨터 수, 연결된 컴퓨터 쌍의 수, 시작 위치의 변수이다.
static int count = 0;	// 몇개가 연결되어 있는지 숫자를 세줄 변수이다.

public static int bfs(int i) {	// bfs(너비 우선 탐색) 메서드
	Queue<Integer> q = new LinkedList<Integer>();	// q라는 이름을 가진 que를 생성한다.
	q.offer(i);	// q에 i를 추가한다.
	visit[i] = true;	// i번째 배열은 시작과 간선이기 때문에 네트워크 상에 연결되어있다.
	
	while(!q.isEmpty()) {	// q가 비어있지 않는다면 while문이 돌아간다.
		int temp = q.poll();	//temp안에 q의 가장 나중값을 반환한다.
		for(int j = 1; j <= computer; j++) {	// 1부터 주어진 컴퓨터 갯수까지 for문을 돌린다
			if(net[temp][j] == 1 && visit[j] == false) {	// 아래 main에서 구한값이 1일경우와 한번도 탐색하지 않은경우
				q.offer(j);
				visit[j] = true;
				count ++;	// 카운트를 1 추가한다.
			}
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
		net = new int[computer + 1][computer + 1];	// 각 정점간 탐색 경로를 저장할 배열
		visit = new boolean[computer + 1];	// 정점의 탐색 여부 체크
		
		for(int i = 0; i < connect; i++) {	// 간선의 수만큼 for문을 돌려준다.
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());	// 첫번째 컴퓨터
			int b = Integer.parseInt(st.nextToken());	// 두번째 컴퓨터
			net[a][b] = net[b][a] = 1;	// 간선으로 연결되어 있어 간선을 나타내는 배열에 1을 집어넣는다.
		}
		System.out.println(bfs(1));
	}
}
