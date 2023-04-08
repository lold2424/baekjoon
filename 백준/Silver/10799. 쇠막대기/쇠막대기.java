import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Stack;
 
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] str = br.readLine().split("");
		
		Stack<String> stack = new Stack<>();
		
		int answer = 0;
		for (int i = 0; i < str.length; i++) {
			String now = str[i];
			
			if (now.equals("(")) stack.push(now);
			else {
				if (str[i - 1].equals("(")) {
					stack.pop();
					answer += stack.size();
				} else {
					answer ++;
					stack.pop();
				}
			}
		}
		
		sb.append(String.valueOf(answer));
		System.out.println(sb);
	}
}