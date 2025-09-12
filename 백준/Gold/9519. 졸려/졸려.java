import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());
        String scrambledWord = br.readLine();

        BlinkingWord puzzle = new BlinkingWord(scrambledWord);
        
        String originalWord = puzzle.findOriginalWord(n);

        System.out.println(originalWord);
    }
}

class BlinkingWord {
    private final String scrambledWord;
    private int cycleLength;

    public BlinkingWord(String scrambledWord) {
        this.scrambledWord = scrambledWord;
        this.cycleLength = calculateCycleLength();
    }

    public String findOriginalWord(long n) {
        long effectiveBlinks = n % this.cycleLength;

        String currentWord = this.scrambledWord;
        for (long i = 0; i < effectiveBlinks; i++) {
            currentWord = reverseBlink(currentWord);
        }
        return currentWord;
    }

    private int calculateCycleLength() {
        String currentWord = this.scrambledWord;
        int count = 0;
        do {
            currentWord = reverseBlink(currentWord);
            count++;
        } while (!currentWord.equals(this.scrambledWord));
        return count;
    }

    private String reverseBlink(String word) {
        char[] chars = word.toCharArray();
        StringBuilder frontPart = new StringBuilder();
        StringBuilder backPart = new StringBuilder();

        for (int i = 0; i < chars.length; i++) {
            if (i % 2 == 0) {
                frontPart.append(chars[i]);
            } else {
                backPart.append(chars[i]);
            }
        }
        backPart.reverse();
        return frontPart.toString() + backPart.toString();
    }
}