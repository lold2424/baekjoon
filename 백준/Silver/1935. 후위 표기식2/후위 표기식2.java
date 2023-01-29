import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Stack;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Double> stack = new Stack<>();
        
        int N = Integer.parseInt(br.readLine());
        String prefix = br.readLine();

        int[] arr = new int[N];
        
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        int len = prefix.length();
        
        for(int i = 0; i < len; i++) {
            char ch = prefix.charAt(i);
            if('A' <= ch && ch <= 'Z') {
                double d = arr[ch - 'A'];
                stack.push(d);
            } else {
                double d1 = stack.pop();
                double d2 = stack.pop();
                double d3 = 0.0;
                switch(ch) {
                    case '+' :
                        d3 = d2 + d1;
                        break;
                    case '-' :
                        d3 = d2 - d1;
                        break;
                    case '*' :
                        d3 = d2 * d1;
                        break;
                    case '/' :
                        d3 = d2 / d1;
                        break;
                }
                stack.push(d3);
            }
        }
        
        System.out.printf("%.2f", stack.pop());
    }
}