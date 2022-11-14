import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	
    static int N, M;
    static int map[][];
    static boolean visit[];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+1][N+1];
        visit = new boolean[N+1];
        
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            map[u][v] = 1;
            map[v][u] = 1;
        }
        
        int result = 0;
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                if(map[i][j] == 1 && !visit[i]) {
                    bfs(i);
                    result++;
                }
            }
        }

        for(int i = 1; i <= N; i++){
            if(!visit[i]) result++;
        }
        
        System.out.println(result);
    }

    private static void bfs(int row) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(row);

        while (!q.isEmpty()){
            int num = q.poll();
            for(int i = 1; i <= N; i++){
                if(map[num][i] == 1 && !visit[i]){
                    q.offer(i);
                    visit[i] = true;
                }
            }
        }
    }
}