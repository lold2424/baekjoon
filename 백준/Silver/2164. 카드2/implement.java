import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class Main {
 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] q = new int[2 * N];	  // 한 턴에 1개 씩 삭제되고 뒤에 1개가 추가 되므로 2 * N - 1 의 공간이 필요하다.
		                            // 다만 index는 1부터 시작할 것이기 때문에 2 * N 공간으로 생성한다.
		for(int i = 1; i <= N; i++) {
			q[i] = i;
		}
		int first_index = 1;
		int last_index = N; // 원소는 1부터 N까지 index에 들어가기 때문에 first_index에 처음원소와, last_index에 마지막 N의 원소를 넣는다.
		
		while(N-- > 1) {  // while을 이용하여 N에서 1까지 감소하도록 반복을 설정해놓는다.
			first_index++;  // // 삭제하는 대신 first_index가 가르키는 첫 원소를 다음 원소르 변경해준다.
			q[last_index + 1] = q[first_index]; // 마지막 원소 다음 공간에 first_index 즉, 첫 번째 원소를 삽입한다.
			last_index++; // 각자 변수가 가르키는 index를 1씩 증가시켜준다.
			first_index++;
		}
 
		System.out.println(q[first_index]);
	}
 
}
