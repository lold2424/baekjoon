import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    
    static int W = 0;
    static int H = 0;
    static int[][] map;
    static int[][] visited;
    static int[][] emptyVisited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][W];
        visited = new int[H][W];
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int cnt = 0;
        int sum = 0;
        for (int x = 0; x < H; x++) {
            for (int y = 0; y < W; y++) {
                if((x ==0 || y ==0 || x==H-1 ||y== W-1  )&&map[x][y] == 0){
                    makeOutSide(x,y);
                }
                if (map[x][y] == 1 && visited[x][y] == 0) {
                    cnt = BFS(x, y);
                    sum += cnt * 6 + 1;
                }
            }
        }

        int emptyCnt = 0;
        int emptySum = 0;
        emptyVisited = new int[H][W];
        for (int x = 0; x < H; x++) {
            for (int y = 0; y < W; y++) {
                if (map[x][y] == 0 && emptyVisited[x][y] == 0) {
                    // 0의 갯수 파악
                    emptyCnt = emptyBFS(x, y);
                    emptySum +=  emptyCnt*6 + 1;
                }
            }
        }
        int overLap = 0;
        int emptyOverLap = 0;
        for (int x = 0; x < H; x++) {
            for (int y = 0; y < W; y++) {
                if (visited[x][y] != 0)
                    overLap += visited[x][y];
                if(emptyVisited[x][y] != 0)
                    emptyOverLap += emptyVisited[x][y];
            }
        }

        System.out.println(sum - overLap - emptySum + emptyOverLap);
        br.close();

    }
    public static int emptyBFS(int x, int y){
        int cnt = 1;
        Queue<int[]> queue = new LinkedList<>();
        emptyVisited[x][y] = 1;
        queue.add(new int[]{x,y});
        int currentX = 0;
        int currentY = 0;
        int[] dx;
        int[] dy;
        while (!queue.isEmpty()) {
            currentX = queue.peek()[0];
            currentY = queue.peek()[1];
            queue.poll();

            if (currentX % 2 == 0) {
                dx = new int[]{0, 0, 1, 1, -1, -1};
                dy = new int[]{-1, 1, 0, 1, 0, 1};
            } else {
                dx = new int[]{0, 0, 1, 1, -1, -1};
                dy = new int[]{-1, 1, 0, -1, 0, -1};
            }
            int updateX = 0;
            int updateY = 0;
            for (int i = 0; i < 6; i++) {
                updateX = currentX + dx[i];
                updateY = currentY + dy[i];

                if (updateX < 0 || updateX > H - 1 || updateY < 0 || updateY > W - 1) continue; // 예외처리

                if (map[updateX][updateY] == 0) {
                    if (emptyVisited[updateX][updateY] == 0) { // 방문한적 없다면 queue추가
                        cnt++;
                        queue.add(new int[]{updateX, updateY});
                    }
                    emptyVisited[updateX][updateY] += 1; // 방문 추가
                }

            }
        }
        return cnt;
    }
    public static void makeOutSide(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        map[x][y] = -1;
        int currentX = 0;
        int currentY = 0;
        int[] dx;
        int[] dy;
        while (!queue.isEmpty()){
            currentX = queue.peek()[0];
            currentY = queue.peek()[1];
            queue.poll();


            if (currentX % 2 == 0) {
                dx = new int[]{0, 0, 1, 1, -1, -1};
                dy = new int[]{-1, 1, 0, 1, 0, 1};
            } else {
                dx = new int[]{0, 0, 1, 1, -1, -1};
                dy = new int[]{-1, 1, 0, -1, 0, -1};
            }
            int updateX = 0;
            int updateY = 0;
            for (int i = 0; i < 6; i++) {
                updateX = currentX + dx[i];
                updateY = currentY + dy[i];

                if (updateX < 0 || updateX > H - 1 || updateY < 0 || updateY > W - 1) continue; // 예외처리

                if (map[updateX][updateY] == 0) {
                    map[updateX][updateY] = -1;
                    queue.add(new int[]{updateX, updateY});
                }
            }
        }
    }
    public static int BFS(int x, int y) {
        int cnt = 1;
        Queue<int[]> queue = new LinkedList<>();
        visited[x][y] = 1;
        queue.add(new int[]{x,y});
        int currentX = 0;
        int currentY = 0;
        int[] dx;
        int[] dy;
        while (!queue.isEmpty()) {
            currentX = queue.peek()[0];
            currentY = queue.peek()[1];
            queue.poll();

            if (currentX % 2 == 0) {
                dx = new int[]{0, 0, 1, 1, -1, -1};
                dy = new int[]{-1, 1, 0, 1, 0, 1};
            } else {
                dx = new int[]{0, 0, 1, 1, -1, -1};
                dy = new int[]{-1, 1, 0, -1, 0, -1};
            }
            int updateX = 0;
            int updateY = 0;
            for (int i = 0; i < 6; i++) {
                updateX = currentX + dx[i];
                updateY = currentY + dy[i];

                if (updateX < 0 || updateX > H - 1 || updateY < 0 || updateY > W - 1) continue; // 예외처리

                if (map[updateX][updateY] == 1) {
                    if (visited[updateX][updateY] == 0) {
                        cnt++;
                        queue.add(new int[]{updateX, updateY});
                    }
                    visited[updateX][updateY] += 1;
                }

            }
        }
        return cnt;
    }
}