import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	Stack<Integer> answer = new Stack<>();
    	
    	int A = Integer.parseInt(st.nextToken());
    	int B = Integer.parseInt(st.nextToken());
    	
    	int m = Integer.parseInt(br.readLine());
    	
    	int temp = 0;
    	
    	st = new StringTokenizer(br.readLine());
    	
    	for(int i = m - 1; i >= 0; i--) {
    		int num = Integer.parseInt(st.nextToken());
    		int mul = (int) Math.pow(A, i);
    		temp += (num * mul);
    	}
    	
    	while(temp != 0) {
    		answer.push(temp % B);
    		temp = temp / B;
    	}
    	
    	int answer_size = answer.size();
    	
    	for(int i = 0; i < answer_size; i++) {
    		if(i == answer_size - 1) {
    			bw.write(String.valueOf(answer.pop()));
    		} else {
    			bw.write(answer.pop() + " ");
    		}
    	}
    	bw.close();
	}
}