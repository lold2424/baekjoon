import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long a = input.nextLong();
        long b = input.nextLong();

        long gcd = getGCD(a, b);
        long lcm = a / gcd * b; // formula for LCM

        System.out.println(lcm);
    }

    // Euclidean algorithm to find greatest common divisor (GCD)
    private static long getGCD(long a, long b) {
        while (b > 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}