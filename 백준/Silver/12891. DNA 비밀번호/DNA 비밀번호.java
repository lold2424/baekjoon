import java.io.*;
import java.util.*;

public class Main {
	static int[] check;
	static int[] arr;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//DNA 문자열 길이
		int S = Integer.parseInt(st.nextToken());
		//비밀번호로 사용할 부분문자열의 길이
		int P = Integer.parseInt(st.nextToken());
		char[] ch = (br.readLine()).toCharArray(); //DNA 문자열
		check = new int[4]; //{'A','C','G','T'}의 최소 개수
		arr = new int[4]; // 부분문자열이 가진 {'A','C','G','T'}의 개수
		int count = 0; //가능한 비밀번호 개수
		
		
		st = new StringTokenizer(br.readLine());
		//부분 문자열에 포함되어야 할 {'A','C','G','T'}의 최소 개수 저장
		for(int i=0; i<4; i++) {
			check[i] = Integer.parseInt(st.nextToken());
		}
		
		//처음 부분 문자열 {'A','C','G','T'}의 개수 저장
		for(int i=0; i<P; i++) {
			add(ch[i]);
		}
		//처음 부분 문자열 비밀번호 가능 여부 체크
		if(isCheck()) count++;
		
		for(int end=P; end<S; end++) { //부분 문자열의 end가 문자열의 마지막 글자가 될 때까지
			int start = end-P;
			remove(ch[start]);
			add(ch[end]);
			if(isCheck()) count++;
		}
		
		System.out.println(count);
		
	}
	
	//비밀번호 가능 여부 체크
	public static boolean isCheck() {
		//가능한 비밀번호라면 true 리턴
		if(check[0]<=arr[0] && check[1]<=arr[1] &&
				check[2]<=arr[2] && check[3]<=arr[3]){
			return true;
		}
		return false;
	}
	
	//추가되는 문자 체크
	public static void add(char c) { 
		switch(c) {
		case 'A':
			arr[0]++;
			break;
		case 'C':
			arr[1]++;
			break;
		case 'G':
			arr[2]++;
			break;
		case 'T':
			arr[3]++;
			break;
		}
	}
	
	//제거되는 문자 체크
	public static void remove(char c) {
		switch(c) {
		case 'A':
			arr[0]--;
			break;
		case 'C':
			arr[1]--;
			break;
		case 'G':
			arr[2]--;
			break;
		case 'T':
			arr[3]--;
			break;
		}
	}
}