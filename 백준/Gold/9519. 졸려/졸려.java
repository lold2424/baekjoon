import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main (String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		String inputStr = br.readLine();
		char str[] = inputStr.toCharArray();
		
		String currentWord = inputStr;
		
		int cycleLength = 0;
		do {
			currentWord = reverseBlink(currentWord);
			cycleLength ++;
		} while (!currentWord.equals(inputStr));
		
		long effectiveN = n % cycleLength;
		
		String answerWord = inputStr;
		
		for (long i = 0; i < effectiveN; i ++) {
			answerWord = reverseBlink(answerWord);
		}
		
		System.out.println(answerWord);
	}
	
	static String reverseBlink(String word) {
		char[] chars = word.toCharArray();
		int len = chars.length;

		StringBuilder frontPart = new StringBuilder();
		StringBuilder backPart = new StringBuilder();

		for (int i = 0; i < len; i++) {
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
