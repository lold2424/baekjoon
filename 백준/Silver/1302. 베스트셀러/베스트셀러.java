import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int max = 0;
        String maxString = "";

        while (N-- > 0) {
            String input = br.readLine();
            int num = 1;

            if (map.containsKey(input)) {
                num = map.get(input) + 1;
                map.put(input, num);
            } else {
                map.put(input, 1);
            }

            if (max < num) {
                max = num;
                maxString = input;
            } else if (max == num && input.compareTo(maxString) < 0) {
                maxString = input;
            }
        }

        System.out.print(maxString);
    }
}
