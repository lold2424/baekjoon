import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<Character>();
		
		String str = br.readLine();	// 기본 문자열
		String boom_str = br.readLine();	// 폭발 문자열

		for(int i = 0; i < str.length(); i++) {
			stack.push(str.charAt(i));	// 스택에 기본 문자열을 Char형으로 1개씩 집어넣는다.

			if(stack.size() >= boom_str.length()) {	// stack의 크기가 폭발문자열과 같거나 클경우
				boolean boom = true;	// 폭발 문자형과 같은 문자열인지 확인할 boolean형
				for(int j = 0; j < boom_str.length(); j++) {	// 스택과 폭발 문자열과 비교를 위한 for문
					if(stack.get(stack.size() - boom_str.length() + j) != boom_str.charAt(j)) { 
						// get을 사용하여 stack값을 가져와서 폭발 문자열과 비교한다.
						// 이때 statck.size에서 빼는 이유는 이전 폭발 문자열과의 비교 결과 기본 문자열일 경우 stack에 그대로 남아있기 때문이다.
						boom = false;	// 폭발 문자열과 stack에 문자열이 다르면 false를 넣는다.
						break;	// 폭발 문자열과 stack내의 문자열이 정확히 같아야 하므로 하나라도 틀리면 남은 stack은 검사할 필요가 없어진다.
					}
				}
				if(boom) {	// boom이 true일 경우
					for (int j = 0; j < boom_str.length(); j++) {	// 폭발 문자열을 stack에서 빼준다.
						stack.pop();
					}
				}
			}
		}
		
		for(char ch : stack) {	// 향상된 for문을 이용하여 sb에 stack값을 넣었다.
			sb.append(ch);
		}
		
		System.out.println(sb.length() > 0 ? sb.toString() : "FRULA");
		// 삼항연산자를 이용하여 문자열이 없을경우 FRULA를 출력하게하였다.
	}
}