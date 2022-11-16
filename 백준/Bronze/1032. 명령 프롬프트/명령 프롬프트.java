import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        char[] pattern = br.readLine().toCharArray();
        
        for (int i = 0; i < N - 1; i++) {
            char[] fileName = br.readLine().toCharArray();
            for (int j = 0; j < pattern.length; j++) {
                
                if(pattern[j] != fileName[j]) pattern[j] = '?';
            }
        }
        
        System.out.println(pattern);
    }
}