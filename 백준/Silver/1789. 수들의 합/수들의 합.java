import java.util.Scanner;

public class Main {
	static int res;
	static long S;
	static long sum;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		S = sc.nextLong();
		res = 0;
		while(true) {
			sum += res;
			if(sum > S) break;
			res++;
		}
		System.out.println(--res);
	}
}