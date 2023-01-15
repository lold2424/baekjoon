import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Stack;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int index = 1;
		
		while(true) {
			Stack<String> stack = new Stack<>();
			String[] input = br.readLine().split("");
			if(input[0].equals("-")) {
				break;
			}
			
			for(String str : input) {
				if(stack.isEmpty()) {
					stack.push(str);
				} else if (stack.peek().equals("{") && str.equals("}")) {
					stack.pop();
				} else {
					stack.push(str);
				}
			}
			
			int sum = 0;
			
			while(!stack.isEmpty()){
				if(stack.pop().equals("{")) sum ++;
				if(stack.pop().equals("}")) sum ++;
			}
			
			System.out.println(index ++ + ". " + sum);
		}
	}
}