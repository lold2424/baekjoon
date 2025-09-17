import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        
        while (T-- > 0) {
            solve(br);
        }
        
        br.close();
    }

    public static void solve(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[][] grid = new int[R][C];
        
        for (int i = 0; i < R; i++) {
            String rowLine = br.readLine(); 
            for (int j = 0; j < C; j++) {
                grid[i][j] = rowLine.charAt(j) - '0';
            }
        }

        int surfaceArea = 0;

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                int h = grid[r][c];

                if (h == 0) {
                    continue;
                }
                surfaceArea += 2;

                int upNeighbor = (r > 0) ? grid[r - 1][c] : 0;
                surfaceArea += Math.max(0, h - upNeighbor);

                int downNeighbor = (r < R - 1) ? grid[r + 1][c] : 0;
                surfaceArea += Math.max(0, h - downNeighbor);

                int leftNeighbor = (c > 0) ? grid[r][c - 1] : 0;
                surfaceArea += Math.max(0, h - leftNeighbor);

                int rightNeighbor = (c < C - 1) ? grid[r][c + 1] : 0;
                surfaceArea += Math.max(0, h - rightNeighbor);
            }
        }

        System.out.println(surfaceArea);
    }
}