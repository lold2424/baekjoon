import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int R, C, X, Y, K, num;	// 입력 받을 값들 과 num은 바꿔지는 숫자를 저장하는 변수
    static int [][] matrix;	// 그림을 입력받을 배열
    static int [] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};	// 행 열이 이동하면서 사용될 배열

    static void dfs() {	// 깊이 우선 탐색
        boolean [][] visited = new boolean[R][C];	// 바꿀 값인지 아닌지 저장할 변수
        Queue<int []> queue = new LinkedList<>();	// 큐 선언
        queue.add(new int[] {X, Y});	// 큐에 시작 위치 x, y값을 넣는다
        visited[X][Y] = true;	// 시작 위치는 바꿀 숫자와 동일하다.
        matrix[X][Y] = K;	// 입력한 숫자로 바꿔준다.

        while(!queue.isEmpty()) {	// 큐가 비어있지 않을때
            int x = queue.peek()[0];	// peek를 사용해서 0번째 큐에 들어온 값을 저장 
            int y = queue.peek()[1];	// peek를 사용해서 1번째 큐에 들어온 값을 저장
            queue.poll();	// 큐 값을 빼준다.

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];	// x값 이동
                int ny = y + dy[i];	// y값 이동
                if (nx < 0 || ny < 0 || nx >= R || ny >= C || visited[nx][ny]) continue;
                // x, y값이 음수이거나, x, y값이 그림 크기보다 크거나 방문했던곳이라면 continue를 실행한다.
                visited[nx][ny] = true;	// 이동한곳에 배열에 true를 집어넣는다.
                if (num == matrix[nx][ny]) {	// 바꿔야 할 숫자와 그림에 숫자가 같다면
                    matrix[nx][ny] = K;	// 입력한 숫자로 바꿔준다.
                    queue.add(new int[] {nx, ny});	// 큐에 nx와 ny값을 넣어준다.
                }

            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        R = Integer.parseInt(st.nextToken());	// 행을 나타내는 정수
        C = Integer.parseInt(st.nextToken());	// 열을 나타내는 정수
        matrix = new int[R][C];	// 그림을 입력할 배열 크기 지정
        
        for (int x = 0; x < R; x++) {
            String line = br.readLine();	// 행 입력
            for (int y = 0; y < C; y++) {
                matrix[x][y] = line.charAt(y) - '0';	// charAt로 입력한 행을 배열에 넣음
            }
        }
        
        st = new StringTokenizer(br.readLine());
        
        X = Integer.parseInt(st.nextToken());	// 시작하는 위치의 x값
        Y = Integer.parseInt(st.nextToken());	// 시작하는 위치의 y값
        K = Integer.parseInt(st.nextToken());	// 바꿔진 숫자
        
        num = matrix[X][Y];	// 바꿔야 하는 숫자가 몇인지 num에 저장
        dfs();	// dfs 사용
        
        for (int x = 0; x < R; x++) { 
            for (int y = 0; y < C; y++) {
                sb.append(matrix[x][y]);	// sb에 값 추가
            }
            sb.append("\n");	// sb에 값 추가
        }
        System.out.println(sb);	// sb 출력
    }
}