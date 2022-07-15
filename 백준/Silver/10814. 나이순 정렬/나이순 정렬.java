import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Comparator;
 
public class Main {
	public static void main(String[] args) throws IOException {		
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
        
		People[] p = new People[N];
 
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			p[i] = new People(age, name);
		}

		Arrays.sort(p, new Comparator<People>() {
			@Override
			public int compare(People s1, People s2) {
				return s1.age - s2.age;
			}
		});
 
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < N; i++) {
			sb.append(p[i]);
		}
        
		System.out.println(sb);
	}
    
	public static class People {
		int age;
		String name;
        
		public People(int age, String name) {
			this.age = age;
			this.name = name;
		}
		@Override
		public String toString() {
			return age + " " + name + "\n";
		}
	}
}