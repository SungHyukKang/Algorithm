import java.util.*;
import java.io.*;

public class Baek4803_2 {

	public static int find(int s, int[] parent) {
		if (parent[s] == s)
			return s;
		parent[s] = find(parent[s], parent);
		return parent[s];
	}

	public static void union(int a, int b, int[] parent) {
		int aRoot = find(a, parent);
		int bRoot = find(b, parent);
		if (aRoot == bRoot) {
			parent[bRoot] = aRoot;
			parent[aRoot] = 0;
		} else if (aRoot < bRoot)
			parent[bRoot] = aRoot;
		else
			parent[aRoot] = bRoot;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = 0;
		while (true) {
			T++;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			if (N == 0 && M == 0)
				break;
			int[] parent = new int[N + 1];
			for (int i = 1; i <= N; i++)
				parent[i] = i;
			HashSet<Integer> hsset = new HashSet<>();
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				union(s, e, parent);
			}
			for (int i = 1; i <= N; i++) {
				int iRoot = find(i, parent);
				if (iRoot > 0) {
					hsset.add(iRoot);
				}
			}
			int tree = hsset.size();
			if (tree > 1) {
				sb.append("Case " + T + ": A forest of " + tree + " trees.\n");
			} else if (tree == 1) {
				sb.append("Case " + T + ": There is one tree.\n");
			} else {
				sb.append("Case " + T + ": No trees.\n");
			}
		}
		System.out.println(sb);
	}

}
