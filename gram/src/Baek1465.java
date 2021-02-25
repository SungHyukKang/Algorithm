import java.util.*;
import java.io.*;

public class Baek1465 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		boolean[] visited = new boolean[10000001];
		ArrayList<Integer> list = new ArrayList<>();
		visited[0] = true;
		visited[1] = true;
		for (int i = 2; i <= 10000000; i++) {
			if (visited[i])
				continue;
			list.add(i);
			for (int j = 2 * i; j <= 10000000; j = j + i) {
				visited[j] = true;
			}
		}

		HashSet<Long> hsset = new LinkedHashSet<>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) <= B)
				for (int j = 2; Math.pow(list.get(i), j) <= B; j++) {
					if (Math.pow(list.get(i), j) >= A)
						hsset.add((long) Math.pow(list.get(i), j));
				}
		}
		System.out.println(hsset.size());
	}

}
