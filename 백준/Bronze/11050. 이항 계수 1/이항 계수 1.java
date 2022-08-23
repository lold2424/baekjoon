import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        int n = sc.nextInt();
        int k = sc.nextInt();
        int bunja = 1;
        int factorial = 1;
     
        for(int i =n ; i > n - k; i--) {
            bunja *= i;
        }

        for(int j = 1; j <= k; j++) {
            factorial *= j;
        }
        System.out.println(bunja / factorial);
    }     
}
