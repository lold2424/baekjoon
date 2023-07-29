import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static class Tree {
        String parent;
        Tree left = null;
        Tree right = null;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Tree[] input = new Tree[26];
        for (int i = 0; i < N; i++) {
            input[i] = new Tree();
        }
        int site = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String parent = st.nextToken();
            String leftChild = st.nextToken();
            String rightChild = st.nextToken();
            for (int j = 0; j <= site; j++) {
                if (site == 0) {
                    input[site].parent = parent;
                }
                if (input[j].parent.equals(parent)) {
                    if (!leftChild.equals(".")) {
                        input[j].left = input[++site];
                        input[site].parent = leftChild;
                    }
                    if (!rightChild.equals(".")) {
                        input[j].right = input[++site];
                        input[site].parent = rightChild;
                    }
                }
            }
        }
        br.close();
        preOrderTraversal(input[0]);
        System.out.println();
        inOrderTraversal(input[0]);
        System.out.println();
        postOrderTraversal(input[0]);
    }

    public static void preOrderTraversal(Tree root) {
        if (root != null) {
            System.out.print(root.parent);
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }

    public static void inOrderTraversal(Tree root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.print(root.parent);
            inOrderTraversal(root.right);
        }
    }

    public static void postOrderTraversal(Tree root) {
        if (root != null) {
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.print(root.parent);
        }
    }
}
