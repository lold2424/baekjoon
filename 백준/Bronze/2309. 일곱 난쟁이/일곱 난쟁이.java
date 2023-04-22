import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int[] high = new int[9];
		int sum = 0;
		int spyA = 0, spyB = 0;

		for (int i = 0; i < high.length; i++) { // 난쟁이 키 입력
			high[i] = sc.nextInt();
			sum += high[i]; // sum은 난쟁이 9명의 키의 합
		}
		Arrays.sort(high); //키를 오름순서로 정렬
		
		for(int a = 0; a < high.length-1; a++) { //브루트 포스
			for(int b = a+1; b < high.length; b++) {
				if(sum - high[a] - high[b] == 100) { //핵심
					spyA = a;
					spyB = b;
					break;
				}
			}
		}
		
		for(int j = 0; j < high.length; j++) { // 진짜 난쟁이 키 출력
			if(j == spyA || j == spyB) //주의
				continue;
			System.out.println(high[j]);
		}
		sc.close();
	}
}