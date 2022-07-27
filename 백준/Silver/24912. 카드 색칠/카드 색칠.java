import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String[] card = br.readLine().split(" ");
		
		for (int i = 0; i < N; i++) {
			if(card[i].equals("0")) {
				if ((i == 0 || !card[i - 1].equals("1")) && (i == N - 1 || !card[i + 1].equals("1"))) card[i] = "1";
				else if ((i == 0 || !card[i - 1].equals("2")) && (i == N - 1 || !card[i + 1].equals("2"))) card[i] = "2";
				else card[i] = "3";
			}
			else if ((i != 0 && card[i - 1].equals(card[i])) || (i != N - 1 && card[i + 1].equals(card[i]))) {
				System.out.print(-1);
				return;
			}
		}
		StringBuilder answer = new StringBuilder();
		for (String i : card) answer.append(i + " ");
		System.out.print(answer);
	}
}