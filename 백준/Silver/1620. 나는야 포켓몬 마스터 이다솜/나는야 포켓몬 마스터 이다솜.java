import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<String,Integer> hashMap = new HashMap<>();
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String [] arr = new String[N+1];

        for (int i = 1; i <= N; i++) {
            arr[i] = br.readLine();
            hashMap.put(arr[i],i);
        }
        
        for (int i = 0; i < M; i++) {
            String s = br.readLine();
            
            if(isNumber(s)){
                int i1 = Integer.parseInt(s);
                System.out.println(arr[i1]);
            } else{
                System.out.println(hashMap.get(s));
            }
        }
    }
    private static boolean isNumber(String s) {
        try {
            int i = Integer.parseInt(s);
        } catch (NumberFormatException e){
            return false;
        }
        return true;
    }
}