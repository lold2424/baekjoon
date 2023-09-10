import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static class Edge {
        int v1, v2, value;

        public Edge(int v1, int v2, int value) {
            this.v1 = v1;
            this.v2 = v2;
            this.value = value;
        }
    }

    static int parent[];

    public static int find(int x) {
        return parent[x] == x ? x : (parent[x] = find(parent[x]));
    }

    public static void union(int x, int y) {
        parent[find(x)] = find(y);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        ArrayList<Edge> edges = new ArrayList<>(E);

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            edges.add(new Edge(v1, v2, value));
        }

        Collections.sort(edges, (a, b) -> a.value - b.value);

        parent = new int[V + 1];

        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }

        int edgeCount = 0;
        int minimumCost = 0;

        for (Edge edge : edges) {
            if (edgeCount == V - 1) break;

            int root1 = find(edge.v1);
            int root2 = find(edge.v2);

            if (root1 != root2) {
                union(root1, root2);
                minimumCost += edge.value;
                edgeCount++;
            }
        }

        System.out.println(V == 1 ? edges.get(0).value : minimumCost);
    }
}
