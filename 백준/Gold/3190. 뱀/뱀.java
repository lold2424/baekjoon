import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
 
public class Main {
	
    static int N, K, L, time;
    static int map[][];
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};
    
    static Queue<info> queue = new LinkedList<>();
    static Deque<info> snake = new LinkedList<>();
    
    static class info{	// 게임의 정보를 저장해줄 클래스
        int time;	// 게임이 몇 초 진행되는지 저장할 변수
        String dir;	// 방향을 저장할 변수
        
        int x, y;	// 뱀의 위치를 저장할 변수
        
        public info(int x, int y) {	// 좌표 x, y를 받았을 때
            this.x = x;
            this.y = y;
        }
        
        public info(int time, String direction) {	// 시간과 방향을 받았을 때
            this.time = time;
            this.dir = direction;
        }
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());	// 보드의 크기
        K = Integer.parseInt(br.readLine());	// 사과의 개수
        
        map = new int[N][N];	// 보드 생성
        
        for(int i = 0; i < K; i++) {	// int
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            
            map[x][y] = 1;
        }
        
        L = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            String direction = st.nextToken();
            
            queue.add(new info(time,direction));
        }
        
        move();
        System.out.println(time + 1);
 
    }
    
    public static void move() {
        
        int dir = 1;
        
        snake.add(new info(0, 0));
        map[0][0] = 2;
        
        while(true) {
            info snail = snake.peekFirst();
            
            int nx = snail.x + dx[dir];
            int ny = snail.y + dy[dir];
            if(!range(nx,ny)) break;
            else {
                if(map[nx][ny] == 1) {
                    snake.addFirst(new info(nx, ny));
                    map[nx][ny] = 2 ;
                }
                
                else if(map[nx][ny] == 2) {
                    break;
                }
                
                else {
                    info del = snake.pollLast();
                    map[del.x][del.y] = 0;
                    snake.addFirst(new info(nx, ny));
                    map[nx][ny] =2;
                }
                
                time++;
                
                if(!queue.isEmpty()) {
                    
                    info temp = queue.peek();
                    
                    if(time == temp.time) {
                        if(temp.dir.equals("D")) {
                            if(dir == 3) dir=0;
                            else dir++;
                        }else if(temp.dir.equals("L")) {
                            if(dir == 0) dir = 3;
                            else dir --;
                        }
                        queue.poll();
                    }
                }
            }
        }
    }
    
    public static boolean range(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}