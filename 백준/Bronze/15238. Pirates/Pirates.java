import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static char arr[];
	static int next = 0, Max = 0;
	static char[] Alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
			'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
	static int[] count = new int[26];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		arr = new char[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = str.charAt(i);
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < 26; j++) {
				if(arr[i] == Alphabet[j]) {
					count[j] += 1;
					break;
				}
			}
		}
		
		for(int i = 0; i < 26; i++) {
			if(Max < count[i]) {
				Max = count[i];
			}
		}
        
		for(int i = 0; i < 26; i++) {
			if(Max == count[i]) {
				System.out.printf("%c %d", Alphabet[i], count[i]);
			}
		}
	}
}