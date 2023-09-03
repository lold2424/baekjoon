import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Integer.*;
import static java.lang.System.in;

public class Main {
    static int n, k;
    static int[][] board;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        init();

        int count = 0;
        while(maxDiffLargerThan(k)) {
            count++;
            addFish();
            firstFold();
            spread();
            unFold();
            secondFold();
            spread();
            unFold();
        }

        System.out.println(count);
    }

    public static boolean maxDiffLargerThan(int k) {
        int minFish = MAX_VALUE;
        int maxFish = MIN_VALUE;

        for (int i = 0; i < n; i++) {
            minFish = min(minFish, board[i][0]);
            maxFish = max(maxFish, board[i][0]);
        }

        if(maxFish - minFish > k) return true;
        else return false;
    }


    public static void addFish() {
        int minFish = MAX_VALUE;
        for(int i = 0; i < n; i++)
            minFish = min(minFish, board[i][0]);

        for (int i = 0; i < n; i++) {
            if (board[i][0] == minFish)
                board[i][0]++;
        }
    }


    public static void firstFold() {
        int startX = 0;
        int vert = 1;
        int hori = 1;
        while (startX + vert + hori <= n) {
            for (int i = vert-1; i >= 0; i--) {
                for (int j = 0; j < hori; j++) {
                    int nx = startX + vert + j;
                    int ny = vert - i;
                    board[nx][ny] = board[startX + i][j];
                    board[startX + i][j] = 0;
                }
            }
            startX += vert;
            if (vert == hori) hori++;
            else vert++;
        }
    }

    public static void spread() {
        int[][] save = new int[n][25];
        boolean[][] visited = new boolean[n][25];

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < 25; y++) {
                visited[x][y] = true;
                if(board[x][y] == 0) continue;

                for (int dir = 0; dir < 4; dir++) {
                    int nx = x + dx[dir];
                    int ny = y + dy[dir];
                    if(valid(nx, ny) && !visited[nx][ny] && board[nx][ny] != 0) {
                        int diff = (board[x][y] - board[nx][ny])/5;
                        if(Math.abs(diff) >= 1) {
                            save[x][y] -= diff;
                            save[nx][ny] += diff;
                        }
                    }
                }
            }
        }

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < 25; y++) {
                board[x][y] += save[x][y];
            }
        }
    }


    public static void unFold() {
        int x = 0;
        while(board[x][0] == 0) x++;

        int index = 0;
        int[] save = new int[n];
        for (int i = x; i < n; i++) {
            for (int j = 0; j < 25; j++) {
                if(board[i][j] == 0) break;
                save[index++] = board[i][j];
                board[i][j] = 0;
            }
        }
        for (int i = 0; i < n; i++) {
            board[i][0] = save[i];
        }
    }


    public static void secondFold() {
        for(int i = 0; i < n/2; i++) {
            board[n-1-i][1] = board[i][0];
            board[i][0] = 0;
        }

        for (int i = 0; i < n/4; i++) {
            for (int j = 0; j < 2; j++) {
                board[n-1-i][3-j] = board[n/2+i][j];
                board[n/2+i][j] = 0;
            }
        }
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String[] line = br.readLine().split(" ");
        n = st(line[0]);
        k = st(line[1]);
        board = new int[n][25];

        line = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            board[i][0] = st(line[i]);
        }
    }


    public static boolean valid(int x, int y) {
        if(x < 0 || x >= n || y < 0 || y >= 25) return false;
        else return true;
    }


    public static int st(String str) {
        return parseInt(str);
    }

}