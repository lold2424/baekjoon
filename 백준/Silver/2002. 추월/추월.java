import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.List;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<String> start = new ArrayList<>();
		List<String> end = new ArrayList<>();
		
		int car = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < car; i++) {
			start.add(br.readLine());
		}
		
		for(int i = 0; i < car; i++) {
			end.add(br.readLine());
		}

		int tmp = start.size();
		boolean check = true;
		
		while(check) {
			int i = 0;
			
			for(i = 0; i < end.size(); i++) {
				if(start.get(i).equals(end.get(i))) {
					continue;
				}
				start.remove(start.indexOf(end.remove(i)));
				break;
			}
			
			if(i == end.size()) {
				break;
			}
		}
		
		System.out.println(tmp - end.size());
	}
}