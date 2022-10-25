import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
        
		int T = Integer.parseInt(st.nextToken());
		int result = 0;
        
		for(int t=0;t<T;t++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			int n;
            
			switch (str) {
			case "add":
				n = Integer.parseInt(st.nextToken());
				result|=(1<<n);
				break;
			case "remove":
				n = Integer.parseInt(st.nextToken());
				result &=~(1<<n);
				break;
			case "check":
				n = Integer.parseInt(st.nextToken());
				if((result&(1<<n)) !=0)
					bw.write("1\n");
				else
					bw.write("0\n");
				break;
			case "toggle":
				n = Integer.parseInt(st.nextToken());
				result ^=(1<<n);
				break;
			case "all":
				result = (1<<21)-1;
				break;
			case "empty":
				result = 0;
				break;
			default:
				break;
			}
		}
        
		bw.flush();
	}
}