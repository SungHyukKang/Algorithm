import java.util.*;
import java.io.*;

public class Baek17140 {
	static class Pair implements Comparable<Pair> {
		int num, v;

		public Pair(int num, int v) {
			this.num = num;
			this.v = v;
		}

		@Override
		public int compareTo(Pair o1) {
			if (this.v > o1.v) {
				return 1;
			} else if (this.v == o1.v) {
				if (this.num > o1.num)
					return 1;
			}
			return -1;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int time = -1;
		int[][] map = new int[101][101];
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		while (time++ < 100) {
			if (map[r - 1][c - 1] == k) {
				System.out.println(time);
				return;
			}

			int maxRow = 0;
			int maxCol = 0;
			for (int i = 0; i <= 100; i++) {
				int rowCnt = 0;
				for (int j = 0; j <= 100; j++) {
					if (map[j][i] == 0) {
						break;
					}
					rowCnt++;
				}
				maxRow = Math.max(maxRow, rowCnt);
			}
			for (int i = 0; i <= 100; i++) {
				int colCnt = 0;
				for (int j = 0; j <= 100; j++) {
					if (map[i][j] == 0)
						break;
					colCnt++;
				}
				maxCol = Math.max(maxCol, colCnt);
			}
			if (maxRow >= maxCol) {
				if (maxRow >= 100)
					maxRow = 100;
				if (maxCol >= 100)
					maxCol = 100;
				for (int i = 0; i < maxRow; i++) {
					HashMap<Integer, Integer> hsmap = new HashMap<>();
					for (int j = 0; j < maxCol; j++) {
						if (map[i][j] == 0) {
							continue;
						}
						hsmap.put(map[i][j], hsmap.getOrDefault(map[i][j], 0) + 1);
					}
					Pair[] pairs = new Pair[hsmap.size()];
					int idx = 0;
					for (Map.Entry<Integer, Integer> entry : hsmap.entrySet()) {
						pairs[idx++] = new Pair(entry.getKey(), entry.getValue());
					}
					Arrays.sort(pairs);

					int iidx = 0;
					Arrays.fill(map[i], 0);
					for (idx = 0; idx < hsmap.size() * 2; idx += 2) {
						map[i][idx] = pairs[iidx].num;
						map[i][idx + 1] = pairs[iidx++].v;
					}
				}
			} else {
				for (int i = 0; i < maxCol; i++) {
					HashMap<Integer, Integer> hsmap = new HashMap<>();
					for (int j = 0; j < maxRow; j++) {
						if (map[j][i] == 0) {
							continue;
						}
						hsmap.put(map[j][i], hsmap.getOrDefault(map[j][i], 0) + 1);
					}
					Pair[] pairs = new Pair[hsmap.size()];
					int idx = 0;
					for (Map.Entry<Integer, Integer> entry : hsmap.entrySet()) {
						pairs[idx++] = new Pair(entry.getKey(), entry.getValue());
					}
					Arrays.sort(pairs);
					int iidx = 0;
					for (int z = 0; z < maxRow; z++) {
						map[z][i] = 0;
					}
					for (idx = 0; idx < hsmap.size() * 2; idx += 2) {
						map[idx][i] = pairs[iidx].num;
						map[idx + 1][i] = pairs[iidx++].v;
					}
				}
			}
		}
		System.out.println(-1);
	}
}
