import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        Map<BigInteger, Integer> map = new HashMap<>();
        
        map.put(BigInteger.ZERO, 0);
        map.put(BigInteger.ONE, 2);
        BigInteger lastTwo = BigInteger.ONE;
        BigInteger lastOne = BigInteger.ONE;
        
        for (int i = 3; i <= 100_000; i++) {
            BigInteger next = lastTwo.add(lastOne);
            map.put(next, i);
            lastTwo = lastOne;
            lastOne = next;
        }

        while (T-- > 0) {
            String n = br.readLine();
            sb.append(map.get(new BigInteger(n))).append('\n');
        }
        
        System.out.println(sb);
    }
}