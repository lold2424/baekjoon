import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int R, C, T;
    static int[][] map;
    static int airPurifierTopRow = -1;
    static int airPurifierBottomRow;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == -1 && airPurifierTopRow == -1) {
                    airPurifierTopRow = i;
                    airPurifierBottomRow = i + 1;
                }
            }
        }

        for (int i = 0; i < T; i++) {
            spreadDust();
            operateAirPurifier();
        }

        int totalDust = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] > 0) {
                    totalDust += map[i][j];
                }
            }
        }
        System.out.println(totalDust);
    }

    private static void spreadDust() {
        int[][] tempMap = new int[R][C];

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (map[r][c] == -1) {
                    tempMap[r][c] = -1;
                    continue;
                }

                tempMap[r][c] += map[r][c];

                int spreadAmount = map[r][c] / 5;
                int spreadCount = 0;

                for (int i = 0; i < 4; i++) {
                    int nr = r + dr[i];
                    int nc = c + dc[i];

                    if (nr < 0 || nr >= R || nc < 0 || nc >= C || map[nr][nc] == -1) {
                        continue;
                    }

                    tempMap[nr][nc] += spreadAmount;
                    spreadCount++;
                }
                tempMap[r][c] -= spreadAmount * spreadCount;
            }
        }
        map = tempMap;
    }

    private static void operateAirPurifier() {
        int top = airPurifierTopRow;

        for (int i = top - 1; i > 0; i--) {
            map[i][0] = map[i - 1][0];
        }
        for (int i = 0; i < C - 1; i++) {
            map[0][i] = map[0][i + 1];
        }
        for (int i = 0; i < top; i++) {
            map[i][C - 1] = map[i + 1][C - 1];
        }
        for (int i = C - 1; i > 1; i--) {
            map[top][i] = map[top][i - 1];
        }
        map[top][1] = 0;

        int bottom = airPurifierBottomRow;

        for (int i = bottom + 1; i < R - 1; i++) {
            map[i][0] = map[i + 1][0];
        }
        for (int i = 0; i < C - 1; i++) {
            map[R - 1][i] = map[R - 1][i + 1];
        }
        for (int i = R - 1; i > bottom; i--) {
            map[i][C - 1] = map[i - 1][C - 1];
        }
        for (int i = C - 1; i > 1; i--) {
            map[bottom][i] = map[bottom][i - 1];
        }
        map[bottom][1] = 0;
    }
}