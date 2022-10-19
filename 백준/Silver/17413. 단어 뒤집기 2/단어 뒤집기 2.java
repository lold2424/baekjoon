import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        String str = br.readLine() + "\n";

        Stack<Character> stack = new Stack<>();
        for (int j = 0; j < str.length(); j++) {
            if(str.charAt(j) == '<'){
                while (!stack.empty()) {
                    sb.append(stack.pop());
                }
               int idx = str.indexOf('>',j);
               sb.append(str,j,idx+1);
               j = idx;
            }
            else if (str.charAt(j) == ' ' || str.charAt(j) == '\n') {
                while (!stack.empty()) {
                    sb.append(stack.pop());
                }
                sb.append(" ");
            }
            else{
                stack.push(str.charAt(j));
            }

        }
        bw.write(sb.toString());


        bw.flush();
        bw.close();
    }
}