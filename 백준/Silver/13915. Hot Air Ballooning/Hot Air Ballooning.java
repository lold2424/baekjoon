import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while (true) {
            String input = br.readLine();
            if (input == null || input.equals("")) {
                break;
            }
            
            int N = Integer.parseInt(input.trim());
            int uniqueSets = 0;
            int[] setFlags = new int[1 << 9];
            
            for (int i = 0; i < N; i++) {
                String elements = br.readLine().trim();
                int len = elements.length();
                int setFlag = 0;
                
                for (int j = 0; j < len; j++) {
                    int elementValue = elements.charAt(j) - '1';
                    setFlag = setFlag | (1 << elementValue);
                }
                
                if (setFlags[setFlag] == 0) {
                    setFlags[setFlag] = 1;
                    uniqueSets++;
                }
            }
            
            System.out.println(uniqueSets);
        }
    }
}