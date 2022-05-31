import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			int distance = y - x;
			int count = 0;
			
			int max = (int)Math.sqrt(distance);
			
			if(max == Math.sqrt(distance)) {
				count = max * 2 - 1;
			}
			else if(distance <= max * max + max) {
				count = max * 2;
			}
			
			else {
				count = max * 2 + 1;
			}
			bw.write(count + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}