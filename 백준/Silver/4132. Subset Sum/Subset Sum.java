import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static long minTotalPurchase = Long.MAX_VALUE;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
        
    	List<Long> input = input();
    	
        int n = input.get(0).intValue();
        int m = input.get(1).intValue();

        long[] sizes = new long[m];
        
        for (int i = 0; i < m; i++) {
            sizes[i] = input().get(0);
        }

        backtrack(0, 0, n, m, sizes);

        if (minTotalPurchase == Long.MAX_VALUE) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(minTotalPurchase);
        }
    }
    
    public static List<Long> input() throws IOException {
    	List<Long> input = new ArrayList<Long>();
    	st = new StringTokenizer(br.readLine().trim());
    	
    	while (st.hasMoreElements()) {
    		input.add(Long.parseLong(st.nextToken()));
    	}
    	
    	return input;
    }

    public static void backtrack(int index, long currentSum, int n, int m, long[] sizes) {
        
        if (currentSum >= minTotalPurchase) {
            return;
        }

        if (index == m) {
            if (currentSum >= n) {
                minTotalPurchase = Math.min(minTotalPurchase, currentSum);
            }
            return;
        }

        backtrack(index + 1, currentSum + sizes[index], n, m, sizes);

        backtrack(index + 1, currentSum, n, m, sizes);
    }
}