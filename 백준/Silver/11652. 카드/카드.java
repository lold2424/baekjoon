import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int maxValue = 0;
		Long maxKey = 0L;
		
		TreeMap<Long, Integer> map = new TreeMap<>();
		
		while (n -- > 0){
			long input = Long.parseLong(br.readLine());
			map.put(input, map.getOrDefault(input, 0) + 1);
		}
		
		
		for (Map.Entry<Long, Integer> entry : map.entrySet()) {
		    int currentValue = entry.getValue();
		    if (currentValue > maxValue) {
		        maxValue = currentValue;
		        maxKey = entry.getKey();
		    }
		}
		
		System.out.println(maxKey);
	}
}