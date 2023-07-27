import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String, Integer> parseIntFunction = Integer::parseInt;

        int N = parseIntFunction.apply(br.readLine());
        String[] strings = new String[N];

        for (int i = 0; i < N; i++) {
            strings[i] = br.readLine();
        }

        Arrays.sort(strings, (str1, str2) -> str2.length() - str1.length());
        List<String> nonPrefixStrings = new ArrayList<>();

        for (String currentString : strings) {
            if (nonPrefixStrings.size() == 0) {
                nonPrefixStrings.add(currentString);
                continue;
            }

            boolean isPrefix = false;

            for (String existingString : nonPrefixStrings) {
                if (existingString.indexOf(currentString) == 0) {
                    isPrefix = true;
                    break;
                }
            }

            if (!isPrefix) {
                nonPrefixStrings.add(currentString);
            }
        }

        System.out.println(nonPrefixStrings.size());
    }
}