import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Stack;
 
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		
		String str = br.readLine();
		
		int result = 0;
		int value = 1;
		
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == '(') { 
				stack.push(str.charAt(i)); 
				value *= 2;
			} else if(str.charAt(i) == '[') {
				stack.push(str.charAt(i)); 
				value *= 3;
			} else if(str.charAt(i) == ')') {
				if(stack.isEmpty() || stack.peek() != '(') { 
					result = 0;
					break;
				} else if(str.charAt(i-1) == '(') {
					result += value;
				}
				stack.pop();
				value /= 2;
			} else if(str.charAt(i) == ']') {
				if(stack.isEmpty() || stack.peek() != '[') {
					result = 0;
					break;
				} else if(str.charAt(i - 1) == '[') {
					result += value;
				}
				stack.pop();
				value /= 3;
			}
		}
		
		if(!stack.isEmpty()) {
			sb.append(0);
		} else {
			sb.append(result);
		}
		
		System.out.println(sb);
	}
}