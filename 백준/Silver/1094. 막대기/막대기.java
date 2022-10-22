import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int bar = 64;
		int x = Integer.parseInt(br.readLine());
		int cnt = 0;
		
		while(x != 0){
			if(bar > x){
				bar = bar / 2;
			}
			
			else{
				x = x - bar;
				cnt ++;
			}
		}
		
		System.out.print(cnt);
	}
}