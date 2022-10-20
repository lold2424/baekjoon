import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String A = st.nextToken();
		String B = st.nextToken();
		
		int idx = 0;						// 문자열의 차까지 1씩 더해줄 변수
		int answer = Integer.MAX_VALUE;		// 최종 문자열의 차이를 저장할 변수
		int len = B.length() - A.length();	// 두 문자열의 길이의 차를 저장
		
		while(true) {
			int cnt = 0;								// 
			for(int i = 0; i < A.length(); i++) {		// A의 길이만큼 for문이 돌아감
				if(A.charAt(i) != B.charAt(i + idx)) {	// A의 i번째 문자가 B의 i + idx 문자와 같은지 비교
					cnt ++;								// 문자가 같다면 cnt에 1을 더해줌
				}
			}
			idx ++;
			
			if(answer > cnt) {	// cnt가 answer보다 작은지 확인 
				answer = cnt;	// answer에 cnt값을 넣음
			}
			
			if(idx > len)		// idx가 두 문자열의 차이보다 큰가 확인
				break;			// 크다면 while문 탈출
		}
		
		System.out.println(answer);
	}
}