import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<Integer> listN = new ArrayList<>();
        for (int i = 2; i <= N; i++) {
            listN.add(i);
        }
        
        System.out.print(recurEpato(listN, K, 0) + "");
    }

    static int recurEpato(ArrayList<Integer> listN, int k, int resultcount) {
        int firstNum = listN.get(0);

        for (int i = 0; i < listN.size(); i++) {
           if (listN.get(i) % firstNum == 0) {
                resultcount++;
                if (resultcount == k) {
                    return listN.get(i);
                }
                listN.remove(i);
            }
        }
        
        return recurEpato(listN, k, resultcount);
    }
}