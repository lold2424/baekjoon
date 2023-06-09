import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Stream;

class Edge implements Comparable<Edge> {
    int node, weight;

    public Edge(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return this.weight - o.weight;
    }
}

public class Main {
    static ArrayList<Edge> adjacencyList[];
    static int distance[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int numberOfVertices = input[0], numberOfEdges = input[1];
        int startNode = Integer.parseInt(br.readLine());

        adjacencyList = new ArrayList[numberOfVertices + 1];
        for (int i = 1; i <= numberOfVertices; i++)
            adjacencyList[i] = new ArrayList<Edge>();
        for (int i = 0; i < numberOfEdges; i++) {
            String[] edgeInfo = br.readLine().split(" ");
            int nodeA = Integer.parseInt(edgeInfo[0]);
            int nodeB = Integer.parseInt(edgeInfo[1]);
            int weight = Integer.parseInt(edgeInfo[2]);
            adjacencyList[nodeA].add(new Edge(nodeB, weight));
        }

        distance = new int[numberOfVertices + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[startNode] = 0;

        dijkstra(startNode);

        for (int i = 1; i <= numberOfVertices; i++) {
            if (distance[i] == Integer.MAX_VALUE)
                System.out.println("INF");
            else
                System.out.println(distance[i]);
        }
    }

    private static void dijkstra(int startNode) {
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<Edge>();
        priorityQueue.add(new Edge(startNode, 0));

        while (!priorityQueue.isEmpty()) {
            Edge current = priorityQueue.poll();
            for (Edge neighbor : adjacencyList[current.node]) {
                if (distance[neighbor.node] > current.weight + neighbor.weight) {
                    distance[neighbor.node] = current.weight + neighbor.weight;
                    priorityQueue.add(new Edge(neighbor.node, distance[neighbor.node]));
                }
            }
        }
    }
}
