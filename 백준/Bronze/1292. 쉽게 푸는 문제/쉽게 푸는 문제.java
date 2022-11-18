import java.util.Scanner;
 
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a=sc.nextInt(), b=sc.nextInt();
		int ans=0, cnt=0;
		// i를 무한 반복으로 돌림
		for(int i=1;;i++) {
			// 1 22 333 갯수처럼 i는 i번 나올수 있기에 이중 for문을 활용
			for(int j=1;j<=i;j++) {
				// 각 단계마다 반복하는 횟수를 지정
				cnt++;
				// 반복되는 횟수가 a랑 b사이에 들어오면 i값을 추가함
				if(a<=cnt && cnt<=b)
					ans+=i;			
			}
			// cnt가 b보다 크다면 반복문 종료
			if(cnt>b)
				break;
		}
		System.out.println(ans);
	}
}