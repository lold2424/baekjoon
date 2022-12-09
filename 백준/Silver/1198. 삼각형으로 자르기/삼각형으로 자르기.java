import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] point;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		point = new int[N][2];
		for(int i=0; i<N; ++i) {
			st = new StringTokenizer(br.readLine());
			point[i][0] = Integer.parseInt(st.nextToken());
			point[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int max = 0;
		for(int i=0; i<N-2; ++i) {
			for(int j=i+1; j<N-1; ++j) {
				for(int k=j+1; k<N; ++k) {
					max = Math.max(max, area(i,j,k));
				}
			}
		}
		System.out.print(sb.append(max/2).append(max%2==0?".0":".5"));
	}
	static int area(int a, int b, int c) {
		int n1 = point[a][0]*point[b][1]+point[b][0]*point[c][1]+point[c][0]*point[a][1];
		int n2 = point[a][1]*point[b][0]+point[b][1]*point[c][0]+point[c][1]*point[a][0];
		return Math.abs(n1-n2);
	}
}