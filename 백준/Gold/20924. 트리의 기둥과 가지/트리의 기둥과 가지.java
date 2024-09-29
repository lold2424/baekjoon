import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    private static boolean[] visited;
    private static int totalNodes, rootNode, gigaNode;
    private static ArrayList<ArrayList<Node>> adjacencyList;

    public static void main(String[] args) throws IOException {
        initializeGraph(); // 그래프 초기화 및 입력 처리
        System.out.println(getPillar(rootNode) + " " + getMaxBranchLength(gigaNode));
    }

    // 그래프 초기화 및 입력 받기
    private static void initializeGraph() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        totalNodes = Integer.parseInt(st.nextToken());
        rootNode = Integer.parseInt(st.nextToken());

        adjacencyList = new ArrayList<>(totalNodes + 5);
        visited = new boolean[totalNodes + 5];
        for (int i = 0; i < totalNodes + 5; i++) {
            adjacencyList.add(new ArrayList<Node>());
        }

        for (int i = 1; i < totalNodes; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            int fromNode = Integer.parseInt(st.nextToken());
            int toNode = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            adjacencyList.get(fromNode).add(new Node(toNode, distance));
            adjacencyList.get(toNode).add(new Node(fromNode, distance));
        }
    }

    // 지가 노드 찾기 및 지가 경로 길이 계산
    private static int getPillar(int currentNode) {
        visited[currentNode] = true;
        gigaNode = currentNode;
        if (isGigaNode(currentNode)) {
            return 0;
        }
        Node nextNode = findNextNode(currentNode);
        return getPillar(nextNode.targetNode) + nextNode.weight;
    }

    // 다음 노드 찾기
    private static Node findNextNode(int currentNode) {
        Node nextNode = adjacencyList.get(currentNode).get(0);
        return visited[nextNode.targetNode] ? adjacencyList.get(currentNode).get(1) : nextNode;
    }

    // 지가 노드 조건 검사
    private static boolean isGigaNode(int currentNode) {
        return (currentNode == rootNode && adjacencyList.get(currentNode).size() > 1) ||
               totalNodes == 1 ||
               adjacencyList.get(currentNode).size() > 2 ||
               (currentNode != rootNode && adjacencyList.get(currentNode).size() == 1);
    }

    // 지가 노드에서 최대 가지 길이 계산
    private static int getMaxBranchLength(int currentNode) {
        visited[currentNode] = true;
        int maxBranchLength = 0;
        for (Node adjacentNode : adjacencyList.get(currentNode)) {
            if (visited[adjacentNode.targetNode]) continue;
            maxBranchLength = Math.max(maxBranchLength, getMaxBranchLength(adjacentNode.targetNode) + adjacentNode.weight);
        }
        return maxBranchLength;
    }

    // 내부 클래스: 노드 표현
    private static class Node {
        private int targetNode, weight;

        public Node(int targetNode, int weight) {
            this.targetNode = targetNode;
            this.weight = weight;
        }
    }
}
