import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] parent;
	static StringBuilder sb = new StringBuilder();
	
	static void union(int a, int b) {
		parent[a] = b;
	}
	
	static int find(int a) {
		if(parent[a] == a) return a;
		else return parent[a] = find(parent[a]);
	}
	
	static void findParent(int a, int b) {
		sb.append(((a == b) ? "YES" : "NO") + "\n"); 
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		parent = new int[n + 1];
		
		for(int i = 0; i <= n; i++) {
			parent[i] = i;
		}
		
		int m = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int Calculation = Integer.parseInt(st.nextToken());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			
			int a = find(num1);
			int b = find(num2);        
			
			if(Calculation == 0) union(a, b);
			else findParent(a, b);
		}
		System.out.println(sb);
	}
}