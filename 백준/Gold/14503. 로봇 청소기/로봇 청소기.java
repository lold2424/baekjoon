import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[n][m];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int res = 0;
		
        // 북, 동, 남, 서 를 바라보고 있기 때문에
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
        
		outer:while(true) {
			if(map[x][y]==0) {
				res++;
				map[x][y] = -1;
				// 청소한 곳 표시하기
			}
		
			for(int t=0;t<4;t++) {
				int ld = (d+3)%4; // 현재 방향에서 +3 을 하면 왼쪽 방향을 가리킬 수 있다.
				int nowx = x+dx[ld], nowy = y+dy[ld];

				if(map[nowx][nowy]==1||map[nowx][nowy]==-1) {
					d = ld;
					continue;
				}// 벽이거나 이미 청소했다면 회전
				
                // 청소할 수 있다면 for문 종료
				x = nowx;
				y = nowy;
				d = ld;
				continue outer;
			}
			
			//여기로 내려왔다는 것은 청소를 하지 못했다는 것.
			int nowx = x-dx[d];
			int nowy = y-dy[d];
			// 후진
			
			if(map[nowx][nowy]==1)
				break;
			
			x = nowx;
			y = nowy;
			
		}
		
		System.out.println(res);
	}
}