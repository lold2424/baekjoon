import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 빠른 입출력을 위한 BufferedReader/BufferedWriter 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        // 1) N 입력
        int N = Integer.parseInt(br.readLine().trim());
        
        // 2) 카드 값 저장용 2차원 배열 (인덱스를 1부터 사용)
        long[][] arr = new long[2][N+1];
        
        // 3) 입력 (위 행)
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int j = 1; j <= N; j++) {
            arr[0][j] = Long.parseLong(st.nextToken());
        }
        // 4) 입력 (아래 행)
        st = new StringTokenizer(br.readLine());
        for (int j = 1; j <= N; j++) {
            arr[1][j] = Long.parseLong(st.nextToken());
        }
        
        // 5) DP 배열 선언 및 초기화
        // dp[i][j] : j번째 열을 처리한 뒤 i행(0:위, 1:아래)에 있을 때의 최대합
        long[][] dp = new long[2][N+1];
        // 초기값을 아주 작은 값으로 채우려면 Arrays.fill 사용 가능
        // 여기서는 첫 열에서 값을 직접 설정하므로 생략
        
        // 첫 열(j=1)에서:
        //  - 위쪽 행에 머무르는 경우 dp[0][1]
        //    = max( arr[0][1], arr[0][1] + arr[1][1] )
        //      (첫 열에서 "위만 방문" vs "위→아래→위" 로 두 칸 모두 방문)
        //  - 아래쪽 행에 머무르는 경우 dp[1][1]
        //    = arr[0][1] + arr[1][1]
        //      (첫 열에서 "위→아래"로 두 칸 모두 방문하고 아래 행에 위치)
        dp[0][1] = Math.max(arr[0][1], arr[0][1] + arr[1][1]);
        dp[1][1] = arr[0][1] + arr[1][1];
        
        // 6) 점화식으로 DP 채우기
        for (int j = 2; j <= N; j++) {
            long topVal = arr[0][j];    // 이번 열 위쪽 값
            long botVal = arr[1][j];    // 이번 열 아래쪽 값
            
            // --- dp[0][j] 계산 (j번째 열을 마친 후 위쪽 행에 위치) ---
            // 세 가지 경우 중 최댓값
            //   1) dp[0][j-1] + topVal
            //        (이전 열도 위에 있었고 이번 열은 '위쪽 칸'만 방문)
            //   2) dp[0][j-1] + (topVal + botVal)
            //        (이전 열도 위에 있었고 이번 열 위→아래→위로 두 칸 모두 방문)
            //   3) dp[1][j-1] + (topVal + botVal)
            //        (이전 열은 아래에 있었고 이번 열 위+아래 모두 방문 후 위로 올라옴)
            long cand1 = dp[0][j-1] + topVal;
            long cand2 = dp[0][j-1] + topVal + botVal;
            long cand3 = dp[1][j-1] + topVal + botVal;
            dp[0][j] = Math.max(Math.max(cand1, cand2), cand3);
            
            // --- dp[1][j] 계산 (j번째 열을 마친 후 아래쪽 행에 위치) ---
            // 세 가지 경우 중 최댓값
            //   1) dp[1][j-1] + botVal
            //        (이전 열도 아래에 있었고 이번 열 아래 칸만)
            //   2) dp[1][j-1] + (topVal + botVal)
            //        (이전 열도 아래였고 이번 열 아래→위→아래로 두 칸 모두 방문)
            //   3) dp[0][j-1] + (topVal + botVal)
            //        (이전 열은 위였고 이번 열 위+아래 모두 방문 후 아래로 내려옴)
            cand1 = dp[1][j-1] + botVal;
            cand2 = dp[1][j-1] + topVal + botVal;
            cand3 = dp[0][j-1] + topVal + botVal;
            dp[1][j] = Math.max(Math.max(cand1, cand2), cand3);
        }
        
        // 7) 최종적으로 n번째 열 아래쪽 행(dp[1][N])이 문제에서 요구하는 답
        long answer = dp[1][N];
        
        // 결과 출력
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}
