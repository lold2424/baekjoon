import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Arrays;
import java.util.HashMap;

public class Main {
	
	static HashMap<String, Integer> trees;
	static int allCount;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		trees = new HashMap<String, Integer>();
		
		String str = br.readLine();
		
		while(true) {
            trees.put(str, trees.getOrDefault(str, 0) + 1);
			allCount++;
			
			str = br.readLine();
			
			if(str == null || str.length() == 0) break;
		}
		
		Object[] keys = trees.keySet().toArray();
		Arrays.sort(keys);
		
		for(Object key : keys) {
			String keyStr = (String)key;
			int count = trees.get(keyStr);
			double per = (double)(count * 100.0) / allCount;
			
			sb.append(keyStr + " " + String.format("%.4f", per) + "\n"); 
		}
		
		System.out.println(sb.toString());
	}
}