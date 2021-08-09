import java.util.*;
import java.io.*;

class NodeS1257 {
	NodeS1257[] child;
	int childNum;
	boolean isTerminal;

	public NodeS1257() {
		child = new NodeS1257[26];
		childNum = 0;
		isTerminal = false;
	}

}

class TrieS1257 {
	NodeS1257 root;
	int l = 0;
	StringBuilder sb = new StringBuilder();

	void init(int t) {
		root = new NodeS1257();
		l = 0;
		sb.append("#" + t + " " + "none\n");
	}

	public void add(String str) {
		int length = str.length();
		NodeS1257 current = root;
		for (int i = 0; i < length; i++) {
			int cToi = str.charAt(i) - 'a';
			if (current.child[cToi] == null) {
				current.child[cToi] = new NodeS1257();
			}
			current.childNum++;
			current = current.child[cToi];
		}
		current.childNum++;
		current.isTerminal = true;
	}

	public void query(NodeS1257 node, int k, String s, int t) {
		if (k == l) {
			sb = new StringBuilder();
			sb.append("#" + t + " " + s + "\n");
			return;
		}
		for (int i = 0; i < 26; i++) {
			if (node.child[i] != null) {
				l++;
				query(node.child[i], k, s + (char) (i + 'a'), t);
			}
		}
	}
}

public class SWEA1257 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			int k = Integer.parseInt(br.readLine());
			String str = br.readLine();
			TrieS1257 trie = new TrieS1257();
			trie.init(t);
			for (int i = 0; i < str.length(); i++) {
				for (int j = i + 1; j <= str.length(); j++) {
					trie.add(str.substring(i, j));
				}
			}
			trie.query(trie.root, k, "", t);
			sb.append(trie.sb.toString());
		}
		System.out.println(sb);
	}

}
