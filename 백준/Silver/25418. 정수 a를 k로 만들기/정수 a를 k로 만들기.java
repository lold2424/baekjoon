import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int cnt = 0;

        while (true) {
            if (a == k) {
                System.out.println(cnt);
                break;
            }

            if (k % 2 == 0 && k >= a * 2) {
                k = k / 2;
            } else {
                k--;
            }

            cnt++;
        }
        
        br.close();
    }
}
