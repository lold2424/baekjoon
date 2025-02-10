import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        
        int[] blocks = new int[W];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            blocks[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] leftMax = new int[W];
        leftMax[0] = blocks[0];
        for (int i = 1; i < W; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], blocks[i]);
        }
        
        int[] rightMax = new int[W];
        rightMax[W - 1] = blocks[W - 1];
        for (int i = W - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], blocks[i]);
        }
        
        int totalWater = 0;
        for (int i = 0; i < W; i++) {
            totalWater += Math.min(leftMax[i], rightMax[i]) - blocks[i];
        }
        
        System.out.println(totalWater);
    }
}
