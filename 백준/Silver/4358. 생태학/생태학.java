import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> map = new HashMap<>();
        
        String str;
        int cnt = 0;
        
        while((str = br.readLine()) != null) {
        	cnt ++;
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        
        List<String> list = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            String tree = entry.getKey();
            list.add(tree);
        }
        
        Collections.sort(list);
        
        for(String tree : list) {
            int count = map.get(tree) * 100;
            sb.append(tree + " " + String.format("%.4f", (double)count / (double)cnt) + "\n");
        }
        
        System.out.print(sb);
    }
}