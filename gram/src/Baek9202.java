import java.util.*;
import java.io.*;

public class Baek9202 {
	static int[] dx = { 1, 1, 1, -1, -1, -1, 0, 0 };
	static int[] dy = { 0, 1, -1, 0, 1, -1, 1, -1 };
	static Set<String> hsset;
	static boolean[][] visited;

	static class Node {
		Node[] child;
		boolean isTerminal;

		public Node() {
			this.child = new Node[26];
			isTerminal = false;
		}
	}

	static class Trie {
		Node root;

		Trie() {
			root = new Node();
		}

		public void add(String str) {
			Node cur = root;
			char[] strToChar = str.toCharArray();
			for (int i = 0; i < strToChar.length; i++) {
				int cToi = strToChar[i] - 'A';
				if (cur.child[cToi] == null) {
					cur.child[cToi] = new Node();
				}
				cur = cur.child[cToi];
			}
			cur.isTerminal = true;
		}

		public void search(char[][] map, int x, int y, Node cur, int depth, String str) {
			if (cur.isTerminal && !hsset.contains(str)) {
				hsset.add(str);
			}

			if (cur.child[map[x][y] - 'A'] != null) {
				for (int i = 0; i < 8; i++) {
					int nx = dx[i] + x;
					int ny = dy[i] + y;
					if (isPossible(nx, ny) && !visited[x][y]) {
						visited[x][y] = true;
						search(map, nx, ny, cur.child[map[x][y] - 'A'], depth + 1, str + map[x][y]);
						visited[x][y] = false;
					}
				}
			}
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Trie trie = new Trie();
		int score[] = { 0, 0, 0, 1, 1, 2, 3, 5, 11 };
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			trie.add(br.readLine());
		}
		br.readLine();
		int B = Integer.parseInt(br.readLine());
		char[][][] map = new char[B][4][4];
		for (int i = 0; i < B; i++) {
			hsset = new HashSet<>();
			visited = new boolean[4][4];
			for (int j = 0; j < 4; j++) {
				map[i][j] = br.readLine().toCharArray();
			}
			for (int j = 0; j < 4; j++) {
				for (int k = 0; k < 4; k++) {
					trie.search(map[i], j, k, trie.root, 0, "");
					visited = new boolean[4][4];
				}
			}

			if (i != B - 1)
				br.readLine();
			int index = 0;
			String[] sarr = new String[hsset.size()];
			int sum = 0;
			for (String Z : hsset) {
				sum += score[Z.length()];
				sarr[index++] = Z;

			}
			Arrays.sort(sarr, new Comparator<String>() {
				@Override
				public int compare(String arg0, String arg1) {
					if (arg0.length() < arg1.length()) {
						return -Integer.compare(arg0.length(), arg1.length());
					} else if (arg0.length() == arg1.length()) {
						return arg0.compareTo(arg1);
					}
					return -1;
				}
			});
			sb.append(sum + " " + sarr[0] + " " + sarr.length + "\n");
		}
		System.out.println(sb);

	}

	public static boolean isPossible(int x, int y) {
		if (x < 0 || x >= 4 || y < 0 || y >= 4)
			return false;
		return true;
	}

}
