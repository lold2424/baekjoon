import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
		StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
		
		int [] A = new int[N];
		int [] B = new int[N];
		
		for(int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st1.nextToken());
			B[i] = Integer.parseInt(st2.nextToken());
		}
		
		int answer = 0;
		boolean visit = false;
		
		if(equals_cheack(A, B)) {
			answer = 1;
			System.out.println(answer);
		} else {
			for(int i = 0; i < A.length - 1; i++) {
				for(int j = 0; j < A.length - 1 - i; j++) {
					if(A[j] > A[j + 1]) {
						int temp = A[j + 1];
						A[j + 1] = A[j];
						A[j] = temp;
						visit = true;
						if((A[j] == B[j]) && (A[j + 1] == B[j + 1])) {
							if(equals_cheack(A, B)) {
								answer = 1;
								break;
							}
						}
					}
				}
			}
				
			System.out.print(answer);
		}
	}
	
	public static boolean equals_cheack(int [] arr1, int [] arr2) {
		return Arrays.equals(arr1, arr2);
	}
}