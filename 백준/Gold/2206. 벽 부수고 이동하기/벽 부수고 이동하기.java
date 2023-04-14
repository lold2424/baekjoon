import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int map[][];  // 통로 정보 입력 받을 배열
    static int visited[][][]; // visited[][][0] -> 아직 벽 부수지 않고 방문체크, visited[][][1] -> 벽 부순 후 방문 체크
    static int min_dis;
    public static class Node {
        int x;
        int y;
        int use;
        int dis;
        public Node(int x, int y, int use, int dis){
            this.x = x;
            this.y = y;
            this.use = use;
            this.dis = dis;

        }
    }
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);

        map = new int[n][m];
        visited = new int[n][m][2];
        // 지나가는 통로 정보 입력 받기
        for (int i = 0; i < n; i ++){
            String data = br.readLine();
            for (int j = 0; j < m; j ++){
                map[i][j] = data.charAt(j) -'0';
            }
        }
        
        min_dis = Integer.MAX_VALUE;
        // bfs 돌아서 움직이면서 map[n-1][m-1] 까지 가는 최소값 구하기
        bfs();
        // 만약 bfs 다 돌았는데 n-1, m-1 도달하지 못하면 min_dis 는 초기 주어진 값이므로 -1 출력하고
        // bfs 돌았는데 최소값 구하면 해당 값 출력
        if (min_dis == Integer.MAX_VALUE){
            System.out.println("-1");
        } else {
            System.out.println(min_dis);
        }



    }

    public static void bfs() {
        Queue<Node> q = new LinkedList<>();
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        // Node 객체에 행, 열 위치정보, 벽 부쉈는지 여부(0, 1), 이동 거리
        // 이동거리가 1인 이유는 문제에서 시작하는 칸과 끝나는 칸도 포함해서 이동거리를 센다고 조건 반영
        q.add(new Node(0, 0, 0, 1));
        // 0, 0은 아직 벽을 부수지 않은 상태(0)에서 방문처리
        visited[0][0][0] = 1;

        // queue가 빌 때까지 완전탐색
        while (!q.isEmpty()) {
            Node node = q.poll();
            // 만약 다 돌고 난 후 도착지이면 이때까지 이동할 때까지 걸린 거리를 최소 이동 거리랑 비교해서 최솟값 갱신
            if (node.x == n - 1 && node.y == m - 1) {
                min_dis = Math.min(min_dis, node.dis);
            }
            // 4방향 탐색
            for (int k = 0; k < 4; k++) {
                int nx = node.x + dx[k];
                int ny = node.y + dy[k];
                // 범위 벗어나지 않게 체크
                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    // 만약 방문했다면(이미 처리) 이곳은 탐색하지 않음
                  if (visited[nx][ny][node.use] != 0){
                      continue;
                  }

                  if (map[nx][ny] == 0){
                      // 이동할 곳이 이동할 수 있는 곳이면, 방문 처리 후 q에 이동거리 1증가시킨 node 객체 생성해서 큐에 추가
                      visited[nx][ny][node.use] = 1;
                      q.add(new Node(nx, ny, node.use, node.dis + 1));
                  } else if (map[nx][ny] == 1 && node.use == 0){
                      // 만약 한번도 부순 적 없는 상태에서 벽을 만나면 한 번 벽을 부순 후 지나갈 수 있으므로
                      // 벽을 부순상태로 변경하고, 방문처리 후 큐에 추가
                      visited[nx][ny][1] = 1;
                      q.add(new Node(nx, ny, 1, node.dis + 1));
                  }
                }

            }
        }
    }
}