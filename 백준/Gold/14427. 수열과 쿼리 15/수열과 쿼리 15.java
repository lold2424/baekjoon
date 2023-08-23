import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int[] ar;
    static PriorityQueue<Node> minHeap = new PriorityQueue<>((a, b) -> {
        if (a.value == b.value) {
            return a.index - b.index;
        }
        return Long.compare(a.value, b.value);
    });

    static class Node {
        int index;
        long value;

        public Node(int index, long value) {
            this.index = index;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ar = new int[N];

        for (int i = 0; i < N; i++) {
            ar[i] = Integer.parseInt(st.nextToken());
            minHeap.offer(new Node(i, ar[i]));
        }

        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int q = Integer.parseInt(st.nextToken());

            if (q == 1) {
                int a = Integer.parseInt(st.nextToken()) - 1;
                int b = Integer.parseInt(st.nextToken());

                ar[a] = b;
                minHeap.offer(new Node(a, b));
            } else {
                while (!minHeap.isEmpty() && ar[minHeap.peek().index] != minHeap.peek().value) {
                    minHeap.poll();
                }
                sb.append(minHeap.peek().index + 1).append("\n");
            }
        }

        System.out.println(sb);
    }
}
