import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Queue<Integer> truck = new LinkedList<Integer>();
		
		st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < n; i++) {
			truck.add(Integer.parseInt(st.nextToken()));
		}
		
		int time = 0;
		int bridge_weight = 0;
		Queue<Integer> bridge = new LinkedList<Integer>();
		
		for(int i = 0; i < w; i++) {
			bridge.add(0);
		}
		while(!bridge.isEmpty()) {
			time ++;
			bridge_weight -= bridge.poll();
			if(!truck.isEmpty()) {
				if(truck.peek() + bridge_weight <= L) {
					bridge_weight += truck.peek();
					bridge.offer(truck.poll());
				} else {
					bridge.offer(0);
				}
			}
		}
		
		System.out.println(time);
	}
}