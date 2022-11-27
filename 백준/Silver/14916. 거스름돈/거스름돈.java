import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = -1;

        for(int i = n / 5; i >= 0; i--){
            int except = n - (5 * i);
            if(except % 2 == 0) {
            	answer = except / 2 + i;
                break;
            }
        }
        
        System.out.println(answer);
    }
}