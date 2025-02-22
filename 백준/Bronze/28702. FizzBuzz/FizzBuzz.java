import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] arr = new String[3];
		String nextNum = null;
		
		for (int i = 0; i < 3; i ++) {
			
			arr[i] = br.readLine();
			if (checkNum(arr[i])) {
				nextNum = Integer.toString(Integer.parseInt(arr[i]) + (3 - i));
			}
		}
		System.out.println(checkFizzBuzz(nextNum));
	}
	
	public static boolean checkNum(String str) {
		if (str.matches("[+-]?\\d*(\\.\\d+)?")) {
			return true;
		}
		return false;
	}
	
	public static String checkFizzBuzz(String nextNum) {
		int num = Integer.parseInt(nextNum);
		if (num % 3 == 0 && num % 5 == 0) {
			return "FizzBuzz";
		}
		else if (num % 3 == 0) {
			return "Fizz";
		}
		else if (num % 5 == 0){
			return "Buzz";
		}
		
		return nextNum;
	}
}
