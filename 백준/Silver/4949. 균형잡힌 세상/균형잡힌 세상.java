import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

import java.util.Stack;

public class Main {
    public static boolean solution(String str){
    	
        Stack<String> stack = new Stack();
        boolean isPossible = true;

        for (int i = 0; i < str.length(); i++) {
            String c = String.valueOf(str.charAt(i));

            if(c.equals("(") || c.equals("[")){
                stack.push(c);
            } 
            
            else if(c.equals(")")){
                if(stack.empty() || !stack.peek().equals("(")){
                    return false;
                }
                
                else {
                    stack.pop();
                }

            }
            
            else if(c.equals("]")){
                if(stack.empty() || !stack.peek().equals("[")){
                    return false;
                }
                
                else {
                    stack.pop( );
                }
            }
        }

        if(!stack.empty())	return false;

        return isPossible;

    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            String str = br.readLine();
            if(str.charAt(0) == '.'){
                break;
            }

            boolean isPossible = solution(str);
            
            if(isPossible){
                bw.write("yes\n");
            }
            
            else {
                bw.write("no\n");
            }

        }

        br.close();
        bw.close();
    }
}