import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[][] heightData = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                heightData[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Terrain terrain = new Terrain(n, heightData);
        SafetyZoneFinder finder = new SafetyZoneFinder(terrain);

        int maxSafeZones = finder.findMaxSafeZones();

        System.out.println(maxSafeZones);
    }
}

class Terrain {
    private final int size;
    private final int[][] heights;
    private final int maxHeight;

    public Terrain(int size, int[][] heights) {
        this.size = size;
        this.heights = heights;
        this.maxHeight = calculateMaxHeight();
    }

    private int calculateMaxHeight() {
        int max = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (heights[i][j] > max) {
                    max = heights[i][j];
                }
            }
        }
        return max;
    }

    public int getSize() {
        return size;
    }

    public int getHeight(int r, int c) {
        return heights[r][c];
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public boolean isWithinBounds(int r, int c) {
        return r >= 0 && r < size && c >= 0 && c < size;
    }
}

class SafetyZoneFinder {
    private final Terrain terrain;
    private boolean[][] visited;

    private static final int[] dr = {-1, 1, 0, 0};
    private static final int[] dc = {0, 0, -1, 1};

    public SafetyZoneFinder(Terrain terrain) {
        this.terrain = terrain;
    }

    public int findMaxSafeZones() {
        int maxZones = 0;

        for (int rainHeight = 0; rainHeight < terrain.getMaxHeight(); rainHeight++) {
            int currentZones = countSafeZonesAt(rainHeight);
            maxZones = Math.max(maxZones, currentZones);
        }
        
        return maxZones == 0 ? 1 : maxZones;
    }

    private int countSafeZonesAt(int rainHeight) {
        int size = terrain.getSize();
        visited = new boolean[size][size];
        int zoneCount = 0;

        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                if (!visited[r][c] && terrain.getHeight(r, c) > rainHeight) {
                    zoneCount++;
                    dfs(r, c, rainHeight);
                }
            }
        }
        return zoneCount;
    }

    private void dfs(int r, int c, int rainHeight) {
        visited[r][c] = true;

        for (int i = 0; i < 4; i++) {
            int nextR = r + dr[i];
            int nextC = c + dc[i];

            if (isSafeAndUnvisited(nextR, nextC, rainHeight)) {
                dfs(nextR, nextC, rainHeight);
            }
        }
    }

    private boolean isSafeAndUnvisited(int r, int c, int rainHeight) {
        return terrain.isWithinBounds(r, c)
                && !visited[r][c]
                && terrain.getHeight(r, c) > rainHeight;
    }
}