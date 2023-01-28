import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int arr1[][] = new int[N + 1][3];
        int arr2[][] = new int[N + 1][3];
        
		for(int i = 1; i <= N; i ++) {
			st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j ++) {
            	arr2[i][j] = Integer.parseInt(st.nextToken());
            }
            arr1[0][0] = arr1[0][1] = arr1[0][2] = arr2[0][0] = arr2[0][1] = arr2[0][2] = 0;
		}
		
		for(int i = 1; i <= N; i ++){
			arr1[i][0] = Min(arr1[i - 1][1], arr1[i - 1][2]) + arr2[i][0];
			arr1[i][1] = Min(arr1[i - 1][0], arr1[i - 1][2]) + arr2[i][1];
			arr1[i][2] = Min(arr1[i - 1][0], arr1[i - 1][1]) + arr2[i][2];
		}
		
		System.out.println(Min(Min(arr1[N][0], arr1[N][1]), arr1[N][2]));
	}
	static int Min(int a, int b){ return a < b ? a : b; }
}