import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
 
public class Main {
	
	static int idx, idx2;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		char temp;
		
		for(int i = 0; i < T; i ++) {
			char[] word = br.readLine().toCharArray();
			
			idx = -1;
			idx2 = 0;
			temp = '\u0000';
			
			for(int j = word.length - 1; j > 0; j --) {
				if(word[j - 1] < word[j]) {
					idx = j - 1;
					break;
				}
			}
			
			if(idx == -1) {
				for(int j = 0; j < word.length; j ++) {
					sb.append(word[j]);
				}
				sb.append("\n");
			} else {
				for(int j = word.length - 1; j >= 0; j --) {
					if(word[idx] < word[j]) {
						idx2 = j;
						break;
					}
				}
				temp = word[idx];
				word[idx] = word[idx2];
				word[idx2] = temp;
				
				Arrays.sort(word, idx + 1, word.length);
				
				for(int j = 0;j < word.length; j ++) {
					sb.append(word[j]);
				}
				sb.append("\n");
			}
		}
		
		System.out.println(sb.toString());
	}
}