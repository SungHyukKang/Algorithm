import java.util.*;
import java.io.*;

public class Baek16906 {

	static class Node {
		Node[] child;
		boolean isTerminal;

		public Node() {
			child = new Node[2];
			isTerminal = false;
		}
	}

	static class Trie {
		Node root;
		boolean tf;
		int count;
		StringBuilder sb;

		public Trie() {
			root = new Node();
			count = 0;
			sb = new StringBuilder();
		}

		public void add(Node cur, int length, int depth, String str) {
			if (length == depth) {
				for (int i = 0; i < 2; i++) {
					if (cur.child[i] != null) {
						return;
					}
				}
				cur.isTerminal = true;
				tf = true;
				sb.append(str).append("\n");
				return;
			}
			if (tf)
				return;
			for (int i = 0; i < 2; i++) {
				if (tf)
					return;
				if (cur.child[i] == null || !cur.child[i].isTerminal) {
					if (cur.child[i] == null) {
						cur.child[i] = new Node();
					}
					add(cur.child[i], length, depth + 1, str + i);
				}
			}

		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Trie trie = new Trie();
		for (int i = 0; i < N; i++) {
			int length = Integer.parseInt(st.nextToken());
			trie.tf = false;
			trie.add(trie.root, length, 0, "");
			if (trie.tf) {
				trie.count++;
			}
		}
		System.out.println(trie.count == N ? "1\n" + trie.sb.toString() : -1);
	}

}
