import java.util.*;
import java.io.*;

public class Baek5446 {
	static HashMap<Character, Integer> hsmap = new LinkedHashMap<>();

	static class Node {
		Node[] child;
		boolean isBan;
		boolean isTerminal;
		int remove;
		int notRemove;

		public Node() {
			this.child = new Node[63];
			this.isBan = false;
			this.isTerminal = false;
		}

	}

	static class Trie {
		Node root;
		int answer;

		Trie() {
			root = new Node();
			answer = 0;
		}

		public void add(String str) {
			char[] chArr = str.toCharArray();
			Node cur = root;
			for (int i = 0; i < chArr.length; i++) {
				if (cur.child[hsmap.get(chArr[i])] == null) {
					cur.child[hsmap.get(chArr[i])] = new Node();
				}
				cur.remove++;
				cur = cur.child[hsmap.get(chArr[i])];
			}
			cur.isTerminal = true;
		}

		public void ban(String str) {
			char[] chArr = str.toCharArray();
			Node cur = root;
			for (int i = 0; i < chArr.length; i++) {
				if (cur.child[hsmap.get(chArr[i])] == null) {
					cur.child[hsmap.get(chArr[i])] = new Node();
				}
				cur.notRemove++;
				cur = cur.child[hsmap.get(chArr[i])];
				cur.isBan = true;
			}
		}

		public void search(Node cur) {
			if (cur.notRemove == 0 && cur.remove != 0 && !cur.isBan) {
				answer++;
				return;
			}
			if (cur.isTerminal) {
				answer++;
			}
			for (int i = 0; i < hsmap.size(); i++) {
				if (cur.child[i] == null)
					continue;
				search(cur.child[i]);
			}
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < 26; i++) {
			hsmap.put((char) ('a' + i), i);
		}
		for (int i = 0; i < 26; i++) {
			hsmap.put((char) ('A' + i), i + 26);
		}
		hsmap.put('.', 52);
		for (int i = 0; i < 10; i++) {
			hsmap.put((char) ('0' + i), i + 53);
		}
		for (int t = 0; t < T; t++) {
			Trie trie = new Trie();
			int N = Integer.parseInt(br.readLine());
			for (int i = 0; i < N; i++) {
				trie.add(br.readLine());
			}
			N = Integer.parseInt(br.readLine());
			for (int i = 0; i < N; i++) {
				trie.ban(br.readLine());
			}
			trie.search(trie.root);
			System.out.println(trie.answer);
		}
	}

}
