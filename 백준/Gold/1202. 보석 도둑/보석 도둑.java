import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.PriorityQueue;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<jewel> list = new ArrayList<>();
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        for(int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list.add(new jewel(m, v));
        }
        
        Collections.sort(list, (o1, o2) -> o1.m - o2.m);
        
        int[] weight = new int[K];
        
        for(int i = 0; i < K; i++) {
            weight[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(weight);
        
        long total = 0;
        int listIdx = 0;
        
        PriorityQueue<jewel> queue = new PriorityQueue<>((o1, o2) -> o2.v - o1.v);
        
        for(int i = 0; i < K; i++) {
            while(listIdx < N && list.get(listIdx).m <= weight[i]) {
            	jewel current = list.get(listIdx++);
            	queue.add(new jewel(current.m, current.v));
            }
            
            if(!queue.isEmpty()) total += queue.poll().v;
        }
        
        System.out.println(total);
    }
    
    public static class jewel {
        int m;
        int v;
        
        public jewel(int m, int v) {
            this.m = m;
            this.v = v;
        }
    }
}