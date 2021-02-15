import java.util.*;
import java.io.*;

public class Baek7662 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int k = Integer.parseInt(br.readLine());
			TreeMap<Integer, Integer> treeMap = new TreeMap<>();
			for (int i = 0; i < k; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String com = st.nextToken();
				int X = Integer.parseInt(st.nextToken());
				if (com.equals("I")) {
					treeMap.put(X, treeMap.getOrDefault(X, 0) + 1);
				} else {
					if (X == -1) {
						if (!treeMap.isEmpty()) {
							int key = treeMap.firstKey();
							if (treeMap.containsKey(key)) {
								treeMap.put(key, treeMap.get(key) - 1);
								if (treeMap.get(key) == 0) {
									treeMap.remove(key);
								}
							}
						}
					} else {
						if (!treeMap.isEmpty()) {
							int key = treeMap.lastKey();
							if (treeMap.containsKey(key)) {
								treeMap.put(key, treeMap.get(key) - 1);
								if (treeMap.get(key) == 0) {
									treeMap.remove(key);
								}
							}
						}
					}
				}
			}
			if (treeMap.isEmpty()) {
				bw.write("EMPTY\n");
			} else {
				bw.write(treeMap.lastKey() + " ");
				bw.write(treeMap.firstKey() + "");
				bw.write("\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
