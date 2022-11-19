import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(token.nextToken());
		int K = Integer.parseInt(token.nextToken());
		
		Country[] countries = new Country[N];
		for (int i = 0; i < N; i++) {
			token = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(token.nextToken());
			int g = Integer.parseInt(token.nextToken());
			int s = Integer.parseInt(token.nextToken());
			int b = Integer.parseInt(token.nextToken());
			countries[i] = new Country(n, g, s, b);
		}
        
		Arrays.sort(countries);
		
		int rank = 1;
		int cnt = 1;
        
		for (int i = 0; i < countries.length; i++) {
			if(i == 0) {
				countries[i].rank = rank;
			}else {
				/* 금,은,동이 같다면 */
				if(countries[i].gold == countries[i-1].gold &&
						countries[i].silver == countries[i-1].silver &&
							countries[i].bronze == countries[i-1].bronze) {
					countries[i].rank = rank - cnt;
					cnt++;
				} else {
					countries[i].rank = rank;
					cnt = 1;
				}
			}
            
			rank++;
		}
		for(Country c : countries) {
            
			if(c.number == K) {
				System.out.println(c.rank);
				break;
			}
		}
	}
	public static class Country implements Comparable<Country>{
		int number;
		int gold;
		int silver;
		int bronze;
		int rank;
		
		public Country(int n, int g, int s, int b) {
			this.number = n;
			this.gold = g;
			this.silver = s;
			this.bronze = b;
		}
		@Override
		public int compareTo(Country o) {
			// TODO Auto-generated method stub
			if(this.gold == o.gold) {
				if(this.silver == o.silver) {
					return -(this.bronze - o.bronze);
				}else {
					return -(this.silver - o.silver);
				}
			}else {
				return -(this.gold - o.gold);
			}
		}
	}
}
