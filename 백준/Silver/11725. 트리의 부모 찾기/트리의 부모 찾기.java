import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        ArrayList< ArrayList<Integer> > list = new ArrayList< ArrayList<Integer> >();
        int[] parents = new int[n+1];
        int i;
        for(i = 0; i <= n+1; i++) {
            list.add(new ArrayList<Integer>());
        }
        
        int a, b;
        for(i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }
        
        int start = 1;
        bfs(start, list, parents, n);
        
        printParents(parents);
    }

    private static void bfs(int start, ArrayList<ArrayList<Integer>> list, int[] parents, int n) {
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.offer(start);
        parents[start] = 1;
        
        while(!queue.isEmpty()) {
            int parent = queue.poll();
            
            for(int item : list.get(parent)) {
                if(parents[item] == 0) {
                    parents[item] = parent;
                    queue.offer(item);
                }
                
            }
        }
    }
    
    private static void printParents(int[] parents) {
        int i;
        for(i = 2; i < parents.length; i++) System.out.println(parents[i]);
    }
}