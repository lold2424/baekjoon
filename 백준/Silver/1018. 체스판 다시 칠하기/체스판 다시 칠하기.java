import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
 
public class Main {
 
	public static boolean[][] arr; // w와 b를 넣을 2차원 배열을 선언한다. 배열의 크기는 모르기 때문에 전역변수로 선언해준다.
	public static int min = 64;	// 가장 작은값을 넣어줄 변수를 생성한다. 변수에는 가장 큰 값인 64를 넣어준다.
 
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");	// N 과 M이 한줄에 띄어쓰기로 주어지기 때문에 StringTokenizer을 이용하였다.
 
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
 
		arr = new boolean[N][M];	// 주어진 N과 M으로 2차원 배열을 생성하였다.
		
 
		// 아래 코드는 배열 입력이다.
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			
			for (int j = 0; j < M; j++) {
				if (str.charAt(j) == 'W') {	// 배열이 한 문장으로 입력되기 때문에 한 글자만 선택해서 보기 위해 charAt를 이용한다.
					arr[i][j] = true;		// W일 때는 true 
				} else {
					arr[i][j] = false;		// B일 때는 false
				}
 
			}
		}
 
		
		int N_row = N - 7;	// 열이 총 몇가지 경우가 있는지 계산
		int M_col = M - 7;	// 행이 총 몇가지 경우가 있는지 계산
 
		for (int i = 0; i < N_row; i++) {
			for (int j = 0; j < M_col; j++) {
				find(i, j);	// 열과 행을 1씩 올리면서 아래 만들어준 find를 이용하여 최소값을 찾아준다.
			}
		}
		System.out.println(min);
	}
 
	
	public static void find(int x, int y) {
		int end_x = x + 8;	// x축의 검색할 값에 입력받은값에 8 을 더해준다.
		int end_y = y + 8;	// y축의 검색할 값에 입력받은값에 8 을 더해준다.
		int count = 0;		// 몇번 다시 칠해야하는지 카운트 해줄 변수를 선언한다.
 
		boolean TF = arr[x][y];	// 첫 번째 칸의 색 
 
		for (int i = x; i < end_x; i++) {
			for (int j = y; j < end_y; j++) {
 
				// 올바른 색이 아닐경우 count 1 증가 
				if (arr[i][j] != TF) {	
					count++;
				}
				
				/* 
				 * 다음 칸은 색이 바뀌므로
				 * true라면 false로, false 라면 true 로
				 * 값을 변경한다.
				 */
				TF = (!TF);
			}
			
			TF = !TF;
		}
		
		/*
		 *  첫 번째 칸을 기준으로 할 때의 색칠 할 개수(count)와
		 *  첫 번째 칸의 색의 반대되는 색을 기준으로 할 때의
		 *  색칠 할 개수(64 - count) 중 최솟값을 count 에 저장 
		 */
		count = Math.min(count, 64 - count);
		
		/*
		 * 이전까지의 경우 중 최솟값보다 현재 count 값이
		 * 더 작을 경우 최솟값을 갱신 
		 */
		min = Math.min(min, count);
	}
}
