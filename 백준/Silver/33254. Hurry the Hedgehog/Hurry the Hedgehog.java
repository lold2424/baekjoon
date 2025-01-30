import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        boolean[] hasMushroom = new boolean[n + 1];
        hasMushroom[1] = true;
        hasMushroom[n] = true;

        String mushroomLine = br.readLine();

        if (s > 2) {
            st = new StringTokenizer(mushroomLine);
            for (int i = 0; i < s - 2; i++) {
                int x = Integer.parseInt(st.nextToken());
                hasMushroom[x] = true;
            }
        }
        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (hasMushroom[a] && hasMushroom[b]) {
                graph[a].add(b);
                graph[b].add(a);
            }
        }

        int[] distance = new int[n + 1];
        Arrays.fill(distance, -1);
        distance[1] = 0;
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            if (cur == n) break;

            for (int nxt : graph[cur]) {
                if (distance[nxt] == -1) {
                    distance[nxt] = distance[cur] + 1;
                    queue.offer(nxt);
                }
            }
        }

        int result = (distance[n] == -1) ? 0 : distance[n] + 1;
        bw.write(String.valueOf(result));
        bw.newLine();

        bw.flush();
        bw.close();
        br.close();
    }
}
