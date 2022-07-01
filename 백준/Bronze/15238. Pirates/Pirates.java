import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static char arr[];	// 입력받을 문자열을 저장하는 배열
	static int Max = 0;	// Max는 최대값을 저장해줄 변수
	static char[] Alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
			'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};	// Alphabet에 알파벳 순서대로 저장
	static int[] count = new int[26];	// 알파벳 순서대로 몇번 나왔는지 저장할 배열
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());	// 문자 개수 입력
		String str = br.readLine();	// str에 문자열 입력
		arr = new char[N];	// 입력받을 문자열 길이만큼 배열을 생성해줌
		
		for(int i = 0; i < N; i++) {
			arr[i] = str.charAt(i);	// chatAt를 통해 str의 문자열을 문자 단위로 끊어서 배열에 저장
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < 26; j++) {
				if(arr[i] == Alphabet[j]) {	// 입력받은 문자와 알파벳이 같은지 확인
					count[j] += 1;	// 같다면 미리 선언해둔 count배열에 1을 더해줌
					break;	// 같은게 확인되었기 때문에 뒤에 포문은 생략
				}
			}
		}
		
		for(int i = 0; i < 26; i++) {
			if(Max < count[i]) {	// 최대값보다 큰지 확인
				Max = count[i];	// 최대값 갱신
			}
		}
        
		for(int i = 0; i < 26; i++) {
			if(Max == count[i]) {	// 최대값인지 확인
				System.out.printf("%c %d", Alphabet[i], count[i]);	// 최대값을 출력
			}
		}
	}
}
