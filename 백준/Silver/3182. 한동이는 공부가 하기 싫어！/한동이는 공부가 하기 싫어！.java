import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] contactGraph;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(reader.readLine());
		contactGraph = new int[N + 1];
		isVisited = new boolean[N + 1];

		for (int i = 1; i <= N; i++) {
			int contactResponse = Integer.parseInt(reader.readLine());
			contactGraph[i] = contactResponse;
		}

		int maxContacts = 0;
		int personToContact = N + 1;

		for (int i = 1; i <= N; i++) {
			int currentContacts = 0;
			if (contactGraph[i] != 0 && !isVisited[i]) {
				isVisited[i] = true;
				currentContacts = dfs(contactGraph[i], currentContacts);
			}

			if (currentContacts > maxContacts) {
				maxContacts = currentContacts;
				personToContact = i;
			} else if (currentContacts == maxContacts && personToContact > i) {
				personToContact = i;
			}

			initializeVisited();
		}

		System.out.println(personToContact);
	}

	static int dfs(int start, int currentContacts) {
		isVisited[start] = true;
		currentContacts++;

		if (contactGraph[start] != 0 && !isVisited[contactGraph[start]]) {
			currentContacts = dfs(contactGraph[start], currentContacts);
		}

		return currentContacts;
	}

	static void initializeVisited() {
		for (int i = 0; i < isVisited.length; i++) {
			isVisited[i] = false;
		}
	}
}
