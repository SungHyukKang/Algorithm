import java.util.*;
import java.io.*;

class Node5052 {
	Node5052[] child;
	boolean isTerminal;

	public Node5052() {
		this.child = new Node5052[10];
		this.isTerminal = false;
	}

}

class Trie5052 {
	Node5052 root;

	public Trie5052() {
		this.root = new Node5052();
	}

	public boolean add(char[] str) {

		Node5052 cur = root;
		for (int i = 0; i < str.length; i++) {
			int cToi = str[i] - '0';
			if (cur.child[cToi] == null) {
				cur.child[cToi] = new Node5052();
			}
			if (cur.isTerminal) {
				return false;
			}
			cur = cur.child[cToi];
		}
		cur.isTerminal = true;
		return true;
	}

}

public class Baek5052 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			Trie5052 trie = new Trie5052();
			boolean tf = true;

			char[][] chArr = new char[N][];
			for (int i = 0; i < N; i++) {
				chArr[i] = br.readLine().toCharArray();
			}
			Arrays.sort(chArr, new Comparator<char[]>() {
				@Override
				public int compare(char[] o1, char[] o2) {
					return o1.length - o2.length;
				}
			});

			for (int i = 0; i < N; i++) {
				if (!trie.add(chArr[i])) {
					sb.append("NO\n");
					tf = false;
					break;
				}
			}
			if (tf) {
				sb.append("YES\n");
			}
		}
		System.out.println(sb);
	}

}
