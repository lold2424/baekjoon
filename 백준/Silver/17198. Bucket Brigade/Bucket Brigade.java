import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char map[][] = new char[10][10];
		int barnRow = 0, lRow = 0, rRow = 0;
		int barnCol = 0, lCol = 0, rCol = 0;

		for (int i = 0; i < 10; i++) {
			String rowInput = br.readLine();
			for (int j = 0; j < rowInput.length(); j++) {
				map[i][j] = rowInput.charAt(j);
			}
		}

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (map[i][j] == 'B') {
					barnRow = i;
					barnCol = j;
				}
				if (map[i][j] == 'L') {
					lRow = i;
					lCol = j;
				}
				if (map[i][j] == 'R') {
					rRow = i;
					rCol = j;
				}
			}
		}

		if (barnRow == lRow && lRow == rRow && ((rCol > lCol && rCol < barnCol) || (rCol > barnCol && rCol < lCol))) {
			System.out.println(Math.abs(barnCol - lCol) + 1);
		} else if (barnCol == lCol && lCol == rCol && ((rRow > lRow && rRow < barnRow) || (rRow > barnRow && rRow < lRow))) {
			System.out.println(Math.abs(barnRow - lRow) + 1);
		} else {
			System.out.println((Math.abs(barnRow - lRow) + Math.abs(barnCol - lCol)) - 1);
		}
		
	}
}
