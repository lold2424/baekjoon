import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int count = 0;
		String[] arr = new String[N];
		
		for(int i = 0; i < N; i ++) arr[i] = br.readLine();
		for(int i = 0; i < M; i ++) {
			String str = br.readLine();
			for(int j = 0; j < N; j ++)
				if(arr[j].startsWith(str)) {
					count ++;
					break;
				}
		}
		
		System.out.println(count);
	}
}