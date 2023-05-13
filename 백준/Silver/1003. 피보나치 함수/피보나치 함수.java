import java.util.Scanner;

public class Main {
	static int[][] Fibo = new int[41][2];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int Test_Case = sc.nextInt();
		Fibo[0][0] = 1; Fibo[0][1] = 0;
		Fibo[1][0] = 0; Fibo[1][1] = 1;
		for(int i = 2; i < 41; i++) {
			Fibo[i][0] = Fibo[i-2][0] + Fibo[i-1][0];
			Fibo[i][1] = Fibo[i-2][1] + Fibo[i-1][1];
				}
		for(int i = 0; i < Test_Case; i++) { 
			int A = sc.nextInt(); System.out.println(Fibo[A][0] + " " + Fibo[A][1]); 
		} 
	} 
}