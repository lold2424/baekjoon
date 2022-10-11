import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;
 
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		
		int N = Integer.parseInt(br.readLine());
		int before = 0;
		
		while(N -- > 0) {
			int n = Integer.parseInt(br.readLine());
			
			if(n > before) {
				for(int i = before + 1; i <= n; i++) {
					stack.push(i);
					sb.append('+').append('\n'); 
				}
				before = n; 
			}
			
			else if(stack.peek() != n) {
				System.out.println("NO");
				return; 
			}
			stack.pop();
			sb.append('-').append('\n');
			
		}
		System.out.println(sb);
		
	}
}