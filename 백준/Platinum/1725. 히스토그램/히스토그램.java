import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class Main {
	
	public static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		sb.append(division(0, N - 1)).append('\n');
		arr = null;
			
		System.out.println(sb);
	}
	
	public static long division(int left, int right) {
		
		if (left == right) {
			return arr[left];
		}
		
		int mid = (left + right) / 2;
		
		long leftArea = division(left, mid);
		long rightArea = division(mid + 1, right);
		
		long max = Math.max(leftArea, rightArea);
		
		max = Math.max(max, MidDivision(left, right, mid));
 
		return max;
		
	}
	
	public static long MidDivision(int left, int right, int mid) {
		
		int toLeft = mid;
		int toRight = mid;
		
		long height = arr[mid];
		
		long maxArea = height;
		
		while (left < toLeft && toRight < right) {
			if (arr[toLeft - 1] < arr[toRight + 1]) {
				toRight ++;
				height = Math.min(height, arr[toRight]);	
			}
			else {
				toLeft --;
				height = Math.min(height, arr[toLeft]);
			}
			
			maxArea = Math.max(maxArea, height * (toRight - toLeft + 1)); 
		}
		
		while (toRight < right) {
			toRight ++;
			height = Math.min(height, arr[toRight]);
			maxArea = Math.max(maxArea, height * (toRight - toLeft + 1)); 
		}
		
		while (left < toLeft) {
			toLeft --;
			height = Math.min(height, arr[toLeft]);
			maxArea = Math.max(maxArea, height * (toRight - toLeft + 1)); 
		}
		return maxArea;
	} 
}