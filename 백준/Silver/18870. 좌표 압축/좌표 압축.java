import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
	static int N;
	static ArrayList<Integer> arr, arr2, idx;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		String[] temp = br.readLine().split(" ");
		
		arr = new ArrayList<>();
		arr2 = new ArrayList<>();
		idx = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			int a = Integer.parseInt(temp[i]);
			arr.add(a);
			idx.add(a);
		}
		
		Collections.sort(idx);
		for(int i = 0; i < idx.size() - 1; i++) {
			if(!idx.get(i).equals(idx.get(i + 1)))
				arr2.add(idx.get(i));
		}
		
		arr2.add(idx.get(idx.size() - 1));
		
		for(int a : arr) {
			int pos = lower_bound(a);
			sb.append(pos + " ");
		}
		System.out.println(sb);
		br.close();
	}
	
	public static int lower_bound(int target) {
		int left = 0;
		int right = arr2.size() - 1;
		
		while(left < right) {
			int mid = (left + right) / 2;
			if(arr2.get(mid) >= target)
				right = mid;
			else
				left = mid + 1;
		}
		return right;
	}
}