import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] grid = new int[M][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        City jinwooCity = new City(N, M, grid);

        Pathfinder pathfinder = new Pathfinder();
        boolean isReachable = pathfinder.canReachDestination(jinwooCity);

        if (isReachable) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
	
	public static class City {
	    private final int width;
	    private final int height;
	    private final int[][] grid;

	    public City(int width, int height, int[][] grid) {
	        this.width = width;
	        this.height = height;
	        this.grid = grid;
	    }

	    public int getWidth() {
	        return width;
	    }

	    public int getHeight() {
	        return height;
	    }

	    public boolean isPassable(int row, int col) {
	        if (row < 0 || row >= height || col < 0 || col >= width) {
	            return false;
	        }
	        return grid[row][col] == 1;
	    }
	}
	
	public static class Pathfinder {
	    public boolean canReachDestination(City city) {
	        int M = city.getHeight();
	        int N = city.getWidth();

	        boolean[][] dp = new boolean[M][N];

	        if (city.isPassable(0, 0)) {
	            dp[0][0] = true;
	        }

	        for (int i = 0; i < M; i++) {
	            for (int j = 0; j < N; j++) {
	                if (!city.isPassable(i, j)) {
	                    continue;
	                }

	                if (i > 0 && dp[i - 1][j]) {
	                    dp[i][j] = true;
	                }

	                if (j > 0 && dp[i][j - 1]) {
	                    dp[i][j] = true;
	                }
	            }
	        }

	        return dp[M - 1][N - 1];
	    }
	}
}