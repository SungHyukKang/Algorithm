import java.util.*;
import java.io.*;

class Node5670 {
	Node5670[] child;
	int childNum;
	boolean isTerminal;
	int cnt;

	public Node5670() {
		child = new Node5670[26];
		childNum = 0;
		isTerminal = false;
		cnt = 0;
	}
}

class Trie5670 {
	private Node5670 root;
	double sum = 0;

	public Node5670 getRoot() {
		return root;
	}

	public void init() {
		root = new Node5670();
	}

	public void add(char[] str, int idx) {
		Node5670 node = root;

		for (int i = 0; i < str.length; i++) {
			int cToi = str[i] - 'a';
			if (node.child[cToi] == null) {
				node.child[cToi] = new Node5670();
				node.childNum++;
			}
			node.child[cToi].cnt++;
			node = node.child[cToi];
		}
		node.isTerminal = true;
	}

	public void search(Node5670 node, char[] str, int depth, int typing) {
		if (str.length - 1 == depth) {
			sum += typing;
			return;
		}
		if (node.child[str[depth] - 'a'].cnt == 1) {
			sum += typing;
			return;
		}
		search(node.child[str[depth] - 'a'], str, depth + 1,
				node.child[str[depth] - 'a'].childNum == 1 && !node.child[str[depth] - 'a'].isTerminal ? typing
						: typing + 1);
	}

}

public class Baek5670 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String input;
		while ((input = br.readLine()) != null) {
			int N = Integer.parseInt(input);
			Trie5670 trie = new Trie5670();
			trie.init();
			ArrayList<char[]> list = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				char[] arr = br.readLine().toCharArray();
				list.add(arr);
				trie.add(arr, i);
			}
			for (char[] str : list) {
				trie.search(trie.getRoot(), str, 0, 1);
			}
			sb.append(String.format("%.2f", trie.sum / N) + "\n");
		}
		System.out.println(sb);

	}

}
