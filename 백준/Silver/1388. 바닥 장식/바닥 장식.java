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
        
        String[] rows = new String[N];
        
        for(int i = 0; i < N; i++) {
            rows[i] = br.readLine();
        }
        
        int count = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(rows[i].charAt(j) == '-') {
                    if(j == 0 || rows[i].charAt(j - 1) == '|') {
                        count++;
                    }
                } else if(rows[i].charAt(j) == '|') {
                    if(i == 0 || rows[i - 1].charAt(j) == '-') {
                        count++;
                    }
                }
            }
        }
        
        System.out.println(count);
    }
}