import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int numRows = Integer.parseInt(st.nextToken());
		int numCols = Integer.parseInt(st.nextToken());
		int totalBeachLength = 0;

		char previousTile, currentTile;
		String[] hexagonRows = new String[2];
		String currentRow;

		for (int i = 0; i < numRows; i++) {
			currentRow = hexagonRows[i % 2] = br.readLine();
			previousTile = ' ';

			// Check alternating tiles for different types (water vs. land)
			for (int j = 0; i > 0 && j < 2 * numCols; j++) {
				currentTile = hexagonRows[j % 2].charAt(j / 2);
				if ((previousTile ^ currentTile) == 13) {
					totalBeachLength++;
				}
				previousTile = currentTile;
			}

			// Count transitions in the same row
			for (int j = 1; j < currentRow.length(); j++) {
				if (currentRow.charAt(j) != currentRow.charAt(j - 1)) {
					totalBeachLength++;
				}
			}
		}

		System.out.println(totalBeachLength);
	}
}