import java.util.*;
import java.io.*;

class Node14725 {
	HashMap<String, Node14725> hsmap;
	boolean isTerminal;

	public Node14725() {
		this.hsmap = new HashMap<>();
		this.isTerminal = false;
	}

	@Override
	public String toString() {
		return hsmap.toString();
	}

}

class Trie14725 {
	Node14725 root;
	StringBuilder sb = new StringBuilder();

	public Trie14725() {
		this.root = new Node14725();
	}

	public void add(String[] str) {
		Node14725 cur = root;

		for (int i = 0; i < str.length; i++) {
			String s = str[i];
			if (cur.hsmap.get(s) == null) {
				cur.hsmap.put(s, new Node14725());
			}
			cur = cur.hsmap.get(s);
		}
		cur.isTerminal = true;
	}

	public void search(Node14725 node, String depth) {
		Object[] mapKey = node.hsmap.keySet().toArray();
		Arrays.sort(mapKey);
		if (node.hsmap.size() == 0) {
			return;
		}

		for (Object s : mapKey) {
			sb.append(depth + "" + s + "\n");
			search(node.hsmap.get((String) s), depth + "--");
		}

	}
}

public class Baek14725 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Trie14725 trie = new Trie14725();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());
			String[] str = new String[K];
			int j = 0;
			while (st.hasMoreTokens()) {
				str[j++] = st.nextToken();
			}
			trie.add(str);
		}
		trie.search(trie.root, "");
		System.out.println(trie.sb.toString());
	}

}
