import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {    
 
    static int N, M;
    static int map[][];
    static int dx[] = {0, 1, 0, -1}, dy[] = {1, 0, -1, 0};
    
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
 
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
            	map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int year = 0;
        while(true) {
            int iceburge = countIceburge();
            if(iceburge >= 2) break; 
            else if(iceburge == 0) {
                year = 0;
                break;
            }
            melting();
            year++;
        }
        
        System.out.println(year);
    }
    
    public static void melting() {
        Queue<int[]> q = new LinkedList<>();
        
        boolean[][] memo = new boolean[N][M];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] != 0) {
                    q.offer(new int[] {i, j});
                    memo[i][j] = true;
                }
            }
        }
        
        while(!q.isEmpty()) {
            int count = 0;
            int[] node = q.poll();
            
            for(int i = 0; i < 4; i++) {
                int nx = node[0] + dx[i];
                int ny = node[1] + dy[i];
                if(nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if(!memo[nx][ny] && map[nx][ny] == 0) count++;
                }
            }
            if(map[node[0]][node[1]] < count) map[node[0]][node[1]] = 0;
            else map[node[0]][node[1]] -= count;
            
        }
    }
    
    public static int countIceburge() {
        int count = 0;
        boolean[][] visited = new boolean[N][M];
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] != 0 && !visited[i][j]) {
                    dfs(i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }
    
    public static void dfs(int x, int y, boolean[][] visited) {
        visited[x][y] = true;
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && ny >= 0 && nx < N && ny < M) {
                if(map[nx][ny] != 0 && !visited[nx][ny]) {
                    dfs(nx, ny, visited);
                }
            }
        }
    }
}