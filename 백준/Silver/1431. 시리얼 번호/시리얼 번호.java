import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int numItems = Integer.parseInt(br.readLine());

		List<String> itemList = new ArrayList<>();

		for (int i = 0; i < numItems; i++) {
			itemList.add(br.readLine());
		}

		Collections.sort(itemList, new Comparator<String>() {

			@Override
			public int compare(String str1, String str2) {
				if (str1.length() == str2.length()) {
					int sum1 = sumDigits(str1);
					int sum2 = sumDigits(str2);
					if (sum1 == sum2) {
						return str1.compareTo(str2);
					} else {
						return sum1 - sum2;
					}
				} else {
					return str1.length() - str2.length();
				}
			}

			private int sumDigits(String str) {
				int sum = 0;
				for (int i = 0; i < str.length(); i++) {
					int digit = str.charAt(i) - '0';
					if (digit >= 0 && digit <= 9) {
						sum += digit;
					}
				}
				return sum;
			}

		});

		for (int i = 0; i < itemList.size(); i++) {
			sb.append(itemList.get(i)).append("\n");
		}

		System.out.println(sb);
	}
}
