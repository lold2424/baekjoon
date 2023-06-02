import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int min = Integer.MAX_VALUE;
    static int N, K;
    static boolean[] visited;
    static int max = 100000;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new boolean[max + 1];
        bfs();
        System.out.println(min);
    }

    public static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(N, 0));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            visited[node.position] = true;
            if (node.position == K)
                min = Math.min(min, node.time);

            if (node.position * 2 <= max && !visited[node.position * 2])
                queue.offer(new Node(node.position * 2, node.time));
            if (node.position + 1 <= max && !visited[node.position + 1])
                queue.offer(new Node(node.position + 1, node.time + 1));
            if (node.position - 1 >= 0 && !visited[node.position - 1])
                queue.offer(new Node(node.position - 1, node.time + 1));
        }
    }

    public static class Node {
        int position;
        int time;

        public Node(int position, int time) {
            this.position = position;
            this.time = time;
        }
    }
}