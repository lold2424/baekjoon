import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());

        for(int i = 0; i < testCase; i++){
            String [] riverSite = br.readLine().split(" ");
            long westSite = Long.parseLong(riverSite[0]);
            long eastSite = Long.parseLong(riverSite[1]);
            long result = 1;

            for(int j = 0; j < westSite; j++){
                result *= (eastSite - j);
                result /= (j + 1);
            }

            bw.write(result + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}