import java.util.*;
import java.io.*;

public class Baek16934 {
	static class Node {
		Node[] child;

		public Node() {
			child = new Node[26];
		}

	}

	static class Trie {
		Node root;
		HashMap<String, Integer> hsmap;
		StringBuilder sb;

		public Trie() {
			root = new Node();
			hsmap = new HashMap<>();
			sb = new StringBuilder();
		}

		public void add(String nickname) {
			char[] strToChar = nickname.toCharArray();
			hsmap.put(nickname, hsmap.getOrDefault(nickname, 0) + 1);
			if (hsmap.get(nickname) > 1) {
				sb.append(nickname).append(hsmap.get(nickname)).append("\n");
				return;
			}
			Node cur = root;
			boolean tf = true;
			for (int i = 0; i < strToChar.length; i++) {
				int sToi = strToChar[i] - 'a';
				if (tf)
					sb.append(strToChar[i]);
				if (cur.child[sToi] == null) {
					cur.child[sToi] = new Node();
					if (tf)
						sb.append("\n");
					tf = false;
				}
				cur = cur.child[sToi];
			}
			if (tf)
				sb.append("\n");
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Trie trie = new Trie();
		for (int i = 0; i < N; i++) {
			trie.add(br.readLine());
		}
		System.out.println(trie.sb);
	}

}
