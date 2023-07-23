import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[][] puddles = new int[N][2];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            puddles[i][0] = Integer.parseInt(st.nextToken());
            puddles[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(puddles, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0])
                    return Integer.compare(o1[1], o2[1]);
                return Integer.compare(o1[0], o2[0]);
            }
        });

        int tarpsNeeded = 0;
        int tarpRange = 0;
        
        for (int i = 0; i < N; i++) {
            if (puddles[i][0] > tarpRange)
                tarpRange = puddles[i][0];
            
            if (puddles[i][1] >= tarpRange) {
                while (puddles[i][1] > tarpRange) {
                    tarpRange += L;
                    tarpsNeeded++;
                }
            }
        }

        System.out.println(tarpsNeeded);
    }
}
