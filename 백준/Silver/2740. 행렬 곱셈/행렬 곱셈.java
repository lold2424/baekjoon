import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
 
public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st1.nextToken());
        int M = Integer.parseInt(st1.nextToken());
        
        int arr1[][] = new int[N][M];
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr1[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        
        int bn = Integer.parseInt(st2.nextToken());
        int bm = Integer.parseInt(st2.nextToken());
        
        int arr2[][] = new int[bn][bm];
        
        for (int i = 0; i < bn; i++) {
            StringTokenizer t = new StringTokenizer(br.readLine());
            for (int j = 0; j < bm; j++) {
                arr2[i][j] = Integer.parseInt(t.nextToken());
            }
        }
        
        int ans[][] = new int[N][bm];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < bm; j++) {
                for (int k = 0; k < M; k++)
                {
                    ans[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                sb.append(ans[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
