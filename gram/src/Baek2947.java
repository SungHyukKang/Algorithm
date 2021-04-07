import java.util.*;
import java.io.*;

public class Baek2947 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<Integer> list = new ArrayList<>();
		while (st.hasMoreTokens()) {
			int x = Integer.parseInt(st.nextToken());
			list.add(x);
		}
		StringBuilder sb = new StringBuilder();
		while (true) {
			for (int i = 0; i < list.size() - 1; i++) {
				if (list.get(i) > list.get(i + 1)) {
					int temp = list.get(i);
					list.set(i, list.get(i + 1));
					list.set(i + 1, temp);
					sb.append(list.toString().replace("[", "").replace("]", "").replaceAll(",", "") + "\n");
				}
			}
			int cnt = 0;
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i) == i + 1) {
					cnt++;
				}
			}
			if (cnt == 5) {
				break;
			}
		}
		System.out.println(sb);

	}

}
