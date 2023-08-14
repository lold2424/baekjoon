import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int rowCount = Integer.parseInt(st.nextToken());
        int colCount = Integer.parseInt(st.nextToken());
        int specialCount = 0;

        char[][] field = new char[rowCount][colCount];
        boolean[][] isSpecial = new boolean[rowCount][colCount];

        for (int i = 0; i < rowCount; i++) {
            String rowInput = br.readLine();
            for (int j = 0; j < colCount; j++) {
                field[i][j] = rowInput.charAt(j);
            }
        }

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if (field[i][j] == '#') {
                    field[i][j] = '.';
                    if (i > 0 && field[i - 1][j] == '#') {
                        isSpecial[i - 1][j] = true;
                    }
                    if (i < rowCount - 1 && field[i + 1][j] == '#') {
                        isSpecial[i + 1][j] = true;
                    }
                    if (j > 0 && field[i][j - 1] == '#') {
                        isSpecial[i][j - 1] = true;
                    }
                    if (j < colCount - 1 && field[i][j + 1] == '#') {
                        isSpecial[i][j + 1] = true;
                    }
                    if (!isSpecial[i][j]) {
                        specialCount++;
                    }
                }
            }
        }

        System.out.println(specialCount);
    }
}
