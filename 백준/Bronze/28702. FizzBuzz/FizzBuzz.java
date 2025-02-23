import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] arr = new String[3];
		int nextNum = 0;
		
		for (int i = 0; i < 3; i ++) {
			arr[i] = br.readLine();
			if (checkNum(arr[i])) {
				nextNum = (Integer.parseInt(arr[i]) + (3 - i));
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
	
	public static String checkFizzBuzz(int nextNum) {
		if (nextNum % 3 == 0 && nextNum % 5 == 0) {
			return "FizzBuzz";
		}
		else if (nextNum % 3 == 0) {
			return "Fizz";
		}
		else if (nextNum % 5 == 0){
			return "Buzz";
		}
		
		return Integer.toString(nextNum);
	}
}
