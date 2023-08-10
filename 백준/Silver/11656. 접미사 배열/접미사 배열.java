import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        String word = reader.readLine();

        String[] suffixes = new String[word.length()];
        for (int i = 0; i < suffixes.length; i++) {
            suffixes[i] = word.substring(i);
        }
        Arrays.sort(suffixes);

        for (String suffix : suffixes) {
            result.append(suffix).append("\n");
        }

        System.out.print(result);
    }
}
