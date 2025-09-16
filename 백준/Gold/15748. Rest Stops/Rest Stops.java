import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    static class RestStop implements Comparable<RestStop> {
        int position;
        int tastiness;

        public RestStop(int position, int tastiness) {
            this.position = position;
            this.tastiness = tastiness;
        }

        @Override
        public int compareTo(RestStop other) {
            return Integer.compare(this.position, other.position);
        }
    }

    static class RestChunk implements Comparable<RestChunk> {
        int tastiness;
        long time;

        public RestChunk(int tastiness, long time) {
            this.tastiness = tastiness;
            this.time = time;
        }
        
        @Override
        public int compareTo(RestChunk other) {
            return Integer.compare(this.tastiness, other.tastiness);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int L = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        long rF = Long.parseLong(st.nextToken());
        long rB = Long.parseLong(st.nextToken());

        List<RestStop> stops = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            stops.add(new RestStop(x, c));
        }
        stops.add(new RestStop(L, 0));
        
        Collections.sort(stops);

        PriorityQueue<RestChunk> pq = new PriorityQueue<>();
        
        long lastPosition = 0;
        long diffRate = rF - rB;

        for (RestStop currentStop : stops) {
            long distance = currentStop.position - lastPosition;
            long timeAvailable = distance * diffRate;
            
            while (!pq.isEmpty() && pq.peek().tastiness < currentStop.tastiness) {
                RestChunk lessTastyChunk = pq.poll();
                timeAvailable += lessTastyChunk.time;
            }
            
            if (timeAvailable > 0) {
                 pq.add(new RestChunk(currentStop.tastiness, timeAvailable));
            }
            
            lastPosition = currentStop.position;
        }
        
        long totalTastiness = 0;
        while(!pq.isEmpty()){
            RestChunk chunk = pq.poll();
            totalTastiness += chunk.tastiness * chunk.time;
        }

        System.out.println(totalTastiness);
    }
}