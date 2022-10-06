import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;

class PointXYZ{
    int height;
    int row;
    int col;

    public PointXYZ(int height, int row, int col){
        this.height = height;
        this.row = row;
        this.col = col;
    }
}

public class Main {
    static int dx[] = {-1, 0, 1, 0, 0, 0};
    static int dy[] = {0, 1, 0, -1, 0, 0};
    static int dz[] = {0, 0, 0, 0, 1, -1};
    static int M, N, H;
    static int arr[][][];
    static Queue<PointXYZ> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
        
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        arr = new int[H + 1][N + 1][M + 1];

        for(int i = 1; i <= H; i++){
            for(int j = 1; j <= N; j++){
                st = new StringTokenizer(br.readLine());
                for(int k = 1; k <= M; k++){
                    arr[i][j][k] = Integer.parseInt(st.nextToken());
                    
                    if(arr[i][j][k] == 1) queue.add(new PointXYZ(i, j, k));
                }
            }
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        while (!queue.isEmpty()){
            PointXYZ point = queue.poll();

            int height = point.height;
            int row = point.row;
            int col = point.col;

            for(int i = 0 ; i < 6; i++){
                int moveHeight = height + dz[i];
                int moveRow = row + dx[i];
                int moveCol = col + dy[i];
                
                if(checkPoint(moveHeight, moveRow, moveCol)){
                    queue.add(new PointXYZ(moveHeight, moveRow, moveCol));
                    arr[moveHeight][moveRow][moveCol] = arr[height][row][col] + 1;
                }
            }
        }
        int result = Integer.MIN_VALUE;

        for(int i = 1; i <= H; i++){
            for(int j = 1; j <= N; j++){
                for(int k = 1; k <= M; k++){
                    if(arr[i][j][k] == 0) return -1;
                    
                    result = Math.max(result, arr[i][j][k]);
                }
            }
        }
        if(result == 1) return 0;
        
        else return (result - 1);
    }

    private static boolean checkPoint(int height, int row, int col){
        if(height < 1 || height > H || row < 1 || row > N || col < 1 || col > M) return false;
        
        if(arr[height][row][col] == 0) return true;
        
        else return false;
    }
}