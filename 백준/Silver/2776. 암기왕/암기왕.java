import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < T; i++) {
            Set<Integer> set = new HashSet<>();
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            for (int j = 0; j < N; j++) {
                set.add(Integer.parseInt(st.nextToken()));
            }
            
            int m = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            
            for (int j = 0; j < m; j++) {
                if (set.contains(Integer.parseInt(st.nextToken()))) sb.append("1\n");
                else sb.append("0\n");
            }
        }
        System.out.print(sb);
    }
}