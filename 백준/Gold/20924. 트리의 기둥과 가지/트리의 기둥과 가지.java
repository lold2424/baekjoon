import java.util.*;
 
public class Main {
 
    static int n, r; 
    static int pillar, max, gigaNode;
    static boolean[] visited;
    static ArrayList<Node>[] nodeList;
 
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
 
        n = scan.nextInt();
        r = scan.nextInt();
 
        nodeList = new ArrayList[n + 1];
        for(int i = 1; i < n + 1; i++) {
            nodeList[i] = new ArrayList<>();
        }
 
        for(int i = 0; i < n - 1; i++) {
            int n1 = scan.nextInt();
            int n2 = scan.nextInt();
            int cost = scan.nextInt();
            nodeList[n1].add(new Node(n2, cost));
            nodeList[n2].add(new Node(n1, cost));
        }
 
        pillar = 0;
        max = 0;
        if(n != 1) {
            visited = new boolean[n + 1];
            findPillarDFS(r, 0); 
            findMaxDFS(gigaNode, 0);
        }
 
        System.out.println(pillar + " " + max);
    }
 
    public static void findPillarDFS(int n, int total) {
        if (nodeList[n].size() > 2 || (nodeList[n].size() == 1 && n != r) || (nodeList[n].size() == 2 && n == r)) {
            pillar = total;
            gigaNode = n;
            return;
        }
 
        for (int i = 0; i < nodeList[n].size(); i++) {
            Node next = nodeList[n].get(i);
            if (!visited[next.num]) {
                visited[next.num] = true;
                findPillarDFS(next.num, total + next.cost);
            }
        }
    }
 
    public static void findMaxDFS(int n, int total) {
        if (nodeList[n].size() == 1) { // 리프 노드라면
            max = Math.max(max, total);
            return;
        }
 
        for (int i = 0; i < nodeList[n].size(); i++) {
            Node next = nodeList[n].get(i);
            if (!visited[next.num]) {
                visited[n] = true;
                total += next.cost;
                findMaxDFS(next.num, total);
                total -= next.cost;
                visited[n] = false;
            }
        }
    }
 
    public static class Node {
        int num;
        int cost;
 
        public Node(int num, int cost) {
            this.num = num;
            this.cost = cost;
        }
    }
}
