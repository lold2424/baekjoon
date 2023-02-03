import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import java.util.HashSet;
import java.util.Set;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < A; i++) setA.add(Integer.parseInt(st.nextToken()));
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < B; i++) setB.add(Integer.parseInt(st.nextToken()));

        int ans = 0;
        for(int num : setA) {
            if(!setB.contains(num)) {
                ans += 1;
            }
        }
        for(int num : setB) {
            if(!setA.contains(num)) {
                ans += 1;
            }
        }
        System.out.println(ans);
    }
}