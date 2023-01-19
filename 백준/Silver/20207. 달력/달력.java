import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {
	
	static int YEAR = 365;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] cnt = new int[YEAR + 1];
		
		while (N -- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            for (int i = S; i <= E; i++) {
                cnt[i] ++;
            }
        }

        int sum = 0;
        int maxHeight = 0;
        int width = 0;
        
        for (int i = 0; i <= YEAR; i++) {
            if (cnt[i] == 0) {
                sum += maxHeight * width;
                maxHeight = width = 0;
                continue;
            }
            width ++;
            maxHeight = Math.max(maxHeight, cnt[i]);
        }
        sum += maxHeight * width;
        System.out.println(sum);
	}
}