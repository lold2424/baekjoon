import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int gridSize;
    static int[][] grid;
    static int pathCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        gridSize = Integer.parseInt(br.readLine());
        grid = new int[gridSize][gridSize];

        for (int i = 0; i < gridSize; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < gridSize; j++)
                grid[i][j] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 1, 1);
        System.out.println(pathCount);
        br.close();
    }

    static void dfs(int x, int y, int direction) {
        if (x == gridSize - 1 && y == gridSize - 1) {
            pathCount++;
            return;
        }

        if (direction != 1 && x + 1 < gridSize && grid[x + 1][y] == 0)
            dfs(x + 1, y, 2);

        if (direction != 2 && y + 1 < gridSize && grid[x][y + 1] == 0)
            dfs(x, y + 1, 1);

        if (x + 1 < gridSize && y + 1 < gridSize &&
            grid[x][y + 1] == 0 && grid[x + 1][y] == 0 && grid[x + 1][y + 1] == 0)
            dfs(x + 1, y + 1, 3);
    }
}
