import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
 
public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int e = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
 
        int te = 1;
        int ts = 1;
        int tm = 1;
        int result = 0;
        while(true){
            result++;
            
            if(e==te&&s==ts&&m==tm){
                System.out.println(result);
                break;
            }
            te++;
            ts++;
            tm++;
            if(te>15) te=1;
            if(ts>28) ts=1;
            if(tm>19) tm=1;
        }
    }
}