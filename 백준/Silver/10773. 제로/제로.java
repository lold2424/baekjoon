import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
import java.util.Stack;

public class Main {
		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> money = new Stack<>();
		
		int k = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < k; i++) {
			 int num = Integer.parseInt(br.readLine());
			 if(num != 0) {
				 money.push(num);
			 } else if(num == 0) {
				 if(money.size() > 0) {
					 money.pop();
				 }
			 }
		}
		
		int sum = 0;
		
		for(int i : money) {
			sum += i;
		}
		
		System.out.println(sum);
	}
}