import java.util.*;
import java.io.*;

public class Baek16960 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		HashSet<Integer> hsset = new HashSet<>();
		for (int i = 0; i < N; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			while (st.hasMoreTokens()) {
				list.get(i).add(Integer.parseInt(st.nextToken()));
			}
		}

		for (int i = 0; i < N; i++) {
			hsset = new HashSet<>();
			for (int j = 0; j < N; j++) {
				if (i == j)
					continue;
				for (int n : list.get(j))
					hsset.add(n);
				if (hsset.size() == M) {
					System.out.println("1");
					return;
				}
			}
		}
		System.out.println("0");

	}

}
