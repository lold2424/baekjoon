import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {

    static int[][] paperColors;
    static int whiteCount = 0;
    static int blueCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        paperColors = new int[n][n];

        for (int i = 0; i < paperColors.length; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < paperColors[i].length; j++) {
                paperColors[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        countColors(0, 0, n);
        System.out.println(whiteCount + "\n" + blueCount);
    }

    private static void countColors(int x, int y, int size) {
        if (isSameColor(x, y, size)) {
            if (paperColors[x][y] == 1) {
                blueCount++;
            } else {
                whiteCount++;
            }
        } else {
            int halfSize = size / 2;
            int[] startX = { x, x, x + halfSize, x + halfSize };
            int[] startY = { y, y + halfSize, y, y + halfSize };

            for (int i = 0; i < 4; i++) {
                countColors(startX[i], startY[i], halfSize);
            }
        }
    }

    private static boolean isSameColor(int x, int y, int size) {
        if (size == 1) {
            return true;
        } else {
            int color = paperColors[x][y];
            for (int i = x; i < x + size; i++) {
                for (int j = y; j < y + size; j++) {
                    if (paperColors[i][j] != color) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}