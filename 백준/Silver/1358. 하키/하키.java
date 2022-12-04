import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        
        int count = 0;
        int player_x, player_y;
        double eq1, eq2;
        
        for(int i = 0; i < P ; i++){
            st = new StringTokenizer(br.readLine());
            
            player_x = Integer.parseInt(st.nextToken());
            player_y = Integer.parseInt(st.nextToken());
            eq1 = (Math.pow(player_x - X, 2) + Math.pow(player_y - (Y + H / 2), 2));
            eq2 = (Math.pow(player_x - (X + W), 2) + Math.pow(player_y - (Y + H / 2), 2));
            
            if(X <= player_x && player_x <= X + W && Y <= player_y && player_y <= Y + H)
                count ++;
            else if(eq1 <= Math.pow(H / 2, 2) || eq2 <= Math.pow(H / 2, 2) )
                count ++;
        }
        System.out.println(String.valueOf(count));
    }
}