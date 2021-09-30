import java.util.*;
import java.io.*;

public class Baek5766 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			if (N == 0 && M == 0)
				break;
			HashMap<Integer, Integer> hsmap = new HashMap<>();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				while (st.hasMoreTokens()) {
					int player = Integer.parseInt(st.nextToken());
					hsmap.put(player, hsmap.getOrDefault(player, 0) + 1);
				}
			}
			ArrayList<int[]> list = new ArrayList<>();
			for (Map.Entry<Integer, Integer> entry : hsmap.entrySet()) {
				list.add(new int[] { entry.getKey(), entry.getValue() });
			}
			Collections.sort(list, (new Comparator<int[]>() {
				@Override
				public int compare(int[] arg0, int[] arg1) {
					if (arg0[1] < arg1[1]) {
						return 1;
					} else if (arg0[1] == arg1[1]) {
						return Integer.compare(arg0[0], arg1[0]);
					}
					return -1;
				}
			}));
			for (int i = 1; i < list.size(); i++) {
				if (list.get(i)[1] != list.get(1)[1])
					break;
				sb.append(list.get(i)[0]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
