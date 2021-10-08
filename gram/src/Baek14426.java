import java.util.*;
import java.io.*;

public class Baek14426 {
	static class Node {
		Node[] child = new Node[26];
	}

	static class Trie {
		Node root;

		Trie() {
			root = new Node();
		}

		public void add(char[] str) {
			Node cur = root;
			for (int i = 0; i < str.length; i++) {
				int sToi = str[i] - 'a';
				if (cur.child[sToi] == null) {
					cur.child[sToi] = new Node();
				}
				cur = cur.child[sToi];
			}
		}

		public int search(char[] str) {
			Node cur = root;
			for (int i = 0; i < str.length; i++) {
				int sToi = str[i] - 'a';
				if (cur.child[sToi] == null) {
					return 0;
				}
				cur = cur.child[sToi];
			}
			return 1;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Trie trie = new Trie();
		for (int i = 0; i < N; i++) {
			trie.add(br.readLine().toCharArray());
		}
		int answer = 0;
		for (int i = 0; i < M; i++) {
			answer += trie.search(br.readLine().toCharArray());
		}
		System.out.println(answer);
	}

}
