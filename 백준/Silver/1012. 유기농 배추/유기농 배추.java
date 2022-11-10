import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;;
 
public class Main {
	
    static int[][] map;
    static int M, N, min = Integer.MAX_VALUE;
    static int K, temp;
    static StringTokenizer st;
    static int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new int[N][M];
            
            for (int j = 0; j < K; j++) {
            	st = new StringTokenizer(br.readLine());
                int x, y;
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                map[x][y] = 1;
            }
            
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (map[j][k] == 1) {
                        dfs(j, k);
                        temp++;
                    }
                }
            }
            min = temp;
            temp = 0;
            System.out.println(min);
        }
    }
 
    public static void dfs(int n, int m) {
        if (map[n][m] == 0) {
            return;
        }
        
        map[n][m]=0;
 
        for (int i = 0; i < 4; i++) {
            int i1 = n + dx[i];
            int i2 = m + dy[i];
            if (i1 >= 0 && i1 < N && i2 >= 0 && i2 < M) {
                dfs(i1, i2);
            }
        }
    }
}