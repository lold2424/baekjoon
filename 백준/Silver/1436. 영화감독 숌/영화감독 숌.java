import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int num = 666;	// 시작은 종말 숫자인 666부터 시작한다.
		int count = 1;	// 몇번째인지 숫자를 세어줄 변수
		
		while(count != N) {	// 입력한 값과 같은 회차라면 while문이 멈추도록함.
			num++;	// 숫자를 1씩 더해줌
			if(String.valueOf(num).contains("666")) {	// valueOf를 이용해서 num을 String형태로 변형 시키고 거기에 문자열 666이 있는지 확인
				count++;	// 있다면 count에 1을 더함
			}
		}
		System.out.println(num);
	}
}