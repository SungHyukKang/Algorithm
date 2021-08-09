import java.util.*;
import java.io.*;

class NodeS1256 {
	NodeS1256[] child;
	boolean isTerminal;
	int childNum;
	char val;

	NodeS1256() {
		child = new NodeS1256[26];
		isTerminal = false;
		childNum = 0;
	}

}

class TrieS1256 {
	NodeS1256 root;

	TrieS1256() {
		root = new NodeS1256();
		this.root.val = ' ';
	}

	private int charToInt(char c) {
		return c - 'a';
	}

	public void insert(String str) {
		int length = str.length();
		NodeS1256 current = this.root;

		for (int i = 0; i < length; i++) {
			char c = str.charAt(i);
			int num = charToInt(c);

			if (current.child[num] == null) {
				current.child[num] = new NodeS1256();
				current.child[num].val = c;
			}
			current.childNum++;
			current = current.child[num];
		}
		current.childNum++;
		current.isTerminal = true;
	}

	public String find(int k) {
		NodeS1256 current = this.root;
		StringBuilder sb = new StringBuilder();
		if (k > current.childNum) {
			sb.append("none");
			return sb.toString();
		}
		while (true) {
			if (current.isTerminal)
				k--;
			if (k == 0)
				break;
			int left = k;
			for (int i = 0; i < 26; i++) {
				k = left;
				if (current.child[i] != null)
					left -= current.child[i].childNum;
				if (left <= 0) {
					sb.append((char) (i + 'a'));
					current = current.child[i];
					break;
				}
			}
		}
		return sb.toString();
	}

}

public class SWEA1256 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			TrieS1256 trie = new TrieS1256();
			int k = Integer.parseInt(br.readLine());
			String str = br.readLine();
			char[] ch = str.toCharArray();
			Arrays.sort(ch);
			for (int i = 0; i < str.length(); i++) {
				trie.insert(str.substring(i));
			}
			sb.append("#"+t+" "+trie.find(k)+"\n");
		}
		System.out.println(sb);
	}

}
