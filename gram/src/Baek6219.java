import java.util.*;
import java.io.*;

public class Baek6219 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		String D = st.nextToken();
		boolean visited[] = new boolean[B + 1];
		visited[0] = true;
		visited[1] = true;
		ArrayList<String> list = new ArrayList<>();
		for (int i = 2; i <= B; i++) {
			if (visited[i])
				continue;
			list.add(String.valueOf(i));
			for (int j = i * 2; j <= B; j += i) {
				visited[j] = true;
			}
		}
		int cnt = 0;
		for (String X : list) {
			if (Integer.parseInt(X) >= A && X.contains(D)) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}

}
