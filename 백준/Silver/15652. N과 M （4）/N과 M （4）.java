import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        char startChar = (char) (st.nextToken().charAt(0) + 1);
        int length = Integer.parseInt(st.nextToken());
        char[] buffer = new char[length * 2];
        generateCombinations('1', startChar, length, buffer, 0);
        System.out.println(sb);
    }

    private static void generateCombinations(char startValue, char maxValue, int length, char[] buffer, int index) {
        if (length == 0) {
            sb.append(buffer).append('\n');
        } else {
            for (char i = startValue; i < maxValue; i++) {
                buffer[index] = i;
                buffer[index + 1] = ' ';
                generateCombinations(i, maxValue, length - 1, buffer, index + 2);
            }
        }
    }
}
