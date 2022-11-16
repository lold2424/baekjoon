import java.io.BufferedReader;
import java.io.InputStreamReader;
 
public class Main {
 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		char[][] arrCandies = new char[N][N];
		
		for (int i = 0; i < N; i++) {
			char[] arrTemp = br.readLine().toCharArray();
			arrCandies[i] = arrTemp;
		}
		
        int Max = 0;
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
 
                if ((j + 1) < N) {
                    swap(arrCandies, i, j, true, false);
                    
                    int tempMax = countMaxCandiesSquare(arrCandies);
                    swap(arrCandies, i, j, true, true);
                    Max = (tempMax > Max) ? tempMax : Max;
                }
                
                if ((i + 1) < N) {
                    swap(arrCandies, i, j, false, false);
                    
                    int tempMax = countMaxCandiesSquare(arrCandies);
                    swap(arrCandies, i, j, false, true);
                    Max = (tempMax > Max) ? tempMax : Max;
                }
            }
        }
        System.out.println(Max);
    }
 
    static int countMaxCandiesSquare(char[][] arrCandies) {
        
        int N = arrCandies.length;
        int Max = 0;
        
        for (int i = 0; i < arrCandies.length; i++) {
 
            int count = 1;
            for (int j = 0; j < N - 1; j++) {
 
                if (arrCandies[i][j + 1] == arrCandies[i][j]) {
                    count++;
                    Max = (count > Max) ? count : Max;
                    continue;
                }
                count = 1;
            }
        }
        
        for (int j = 0; j < arrCandies.length; j++) {
 
            int count = 1;
            for (int i = 0; i < N - 1; i++) {
 
                if (arrCandies[i + 1][j] == arrCandies[i][j]) {
                    count++;
                    Max = (count > Max) ? count : Max;
                    continue;
                }
                count = 1;
            }
        }
        return Max;
    }
    
    static void swap(char[][] arrCandies, int i, int j, boolean isRight, boolean isReverse) {
 
        int a = i;
        int b = j;
 
        if (isRight) {
            b = j + 1;
            if (isReverse) {
                int temp = j;
                j = b;
                b = temp;
            }
        } else {
            a = i + 1;
            if (isReverse) {
                int temp = i;
                i = a;
                a = temp;
            }
        }
 
        char temp = arrCandies[i][j];
        arrCandies[i][j] = arrCandies[a][b];
        arrCandies[a][b] = temp;
    }
}