import java.util.*;
import java.io.*;

public class Baek18870 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		HashSet<Integer> hsset = new HashSet<>();
		ArrayList<Integer> list = new ArrayList<>();
		while (st.hasMoreTokens()) {
			int x = Integer.parseInt(st.nextToken());
			list.add(x);
			hsset.add(x);
		}
		ArrayList<Integer> arr = new ArrayList<>();
		for (int x : hsset) {
			arr.add(x);
		}
		Collections.sort(arr, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 <= o2 ? 1 : -1;
			}
		});
		HashMap<Integer, Integer> hsmap = new HashMap<>();
		for (int i = 0; i < arr.size(); i++) {
			hsmap.put(arr.get(i), arr.size() - (i + 1));
		}
		StringBuilder sb = new StringBuilder();
		for (int x : list) {
			sb.append(hsmap.get(x) + " ");
		}
		System.out.println(sb);
	}

	public static void recursion(int l, int w, int h) {

	}

}
