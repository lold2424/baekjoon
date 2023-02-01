import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int dnaLen = Integer.parseInt(st.nextToken());
        int pwLen = Integer.parseInt(st.nextToken());
        
        String dna = br.readLine();
        char[] dnaArr = dna.toCharArray();
        
        int[] checkLen = new int[4];
        int[] dataLen = new int[4];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i ++) {
            checkLen[i] = Integer.parseInt(st.nextToken());
        }
       
        int answer = 0;
        
        int prevIdx1 = -1;
        for(int i = 0; i < dnaLen; i ++) {
            int idx1 = i;
            int idx2 = i + pwLen;
            
            if(prevIdx1 == -1) {
                for(int j=idx1; j<idx2; j++) {
                    switch(dnaArr[j]) {
                        case 'A':
                            dataLen[0]++;
                            continue;
                        case 'C':
                            dataLen[1]++;
                            continue;
                        case 'G':
                            dataLen[2]++;
                            continue;
                        case 'T':
                            dataLen[3]++;
                            continue;
                    }
                }
            } else if(idx2 <= dnaLen) {
                switch(dnaArr[prevIdx1]) {
                    case 'A':
                        dataLen[0]--;
                        break;     
                    case 'C':
                        dataLen[1]--;
                        break;
                    case 'G':
                        dataLen[2]--;
                        break;
                    case 'T':
                        dataLen[3]--;
                        break;
                }
                
                switch(dnaArr[idx2-1]) {
                    case 'A':
                        dataLen[0]++;
                        break;     
                    case 'C':
                        dataLen[1]++;
                        break;
                    case 'G':
                        dataLen[2]++;
                        break;
                    case 'T':
                        dataLen[3]++;
                        break;
                }
            } else break;
            
            int cnt = 0;
            for(int j = 0; j < 4; j ++) {
                if(dataLen[j] < checkLen[j]) break;
                else cnt++;
            }
            
            if(cnt == 4) answer++;
        
            prevIdx1 = i;
        }
        
        System.out.println(answer);
    }
}