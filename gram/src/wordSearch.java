import java.util.Arrays;
import java.util.HashMap;

class NodeWS {
	NodeWS[] child;
	boolean isTerminal;
	int childNum;

	public NodeWS() {
		this.child = new NodeWS[26];
		this.isTerminal = false;
		this.childNum = 0;
	}

}

class TrieWS {
	NodeWS root;
	int count;

	public TrieWS() {
		this.root = new NodeWS();
		count = 0;
	}

	public void add(String str, int type) {
		char[] strToChar = str.toCharArray();
		NodeWS cur = root;
		if (type == 0) {
			for (int i = strToChar.length - 1; i >= 0; i--) {
				int cToi = strToChar[i] - 'a';
				if (cur.child[cToi] == null) {
					cur.child[cToi] = new NodeWS();
					cur.childNum++;
				}
				cur = cur.child[cToi];
			}
			cur.isTerminal = true;
		} else {
			for (int i = 0; i < strToChar.length; i++) {
				int cToi = strToChar[i] - 'a';
				if (cur.child[cToi] == null) {
					cur.child[cToi] = new NodeWS();
					cur.childNum++;
				}
				cur = cur.child[cToi];
			}
			cur.isTerminal = true;
		}
	}

	public void find(NodeWS cur, char[] str, int depth) {
		if (depth == str.length) {
			if (cur.isTerminal)
				count++;
			return;
		}
		if (str[depth] == '?') {
			for (int i = 0; i < 26; i++) {
				if (cur.child[i] != null) {
					find(cur.child[i], str, depth + 1);
				}
			}
		} else {
			if (cur.child[str[depth] - 'a'] != null)
				find(cur.child[str[depth] - 'a'], str, depth + 1);
		}

	}

	public int search(String str) {
		char[] strToChar = str.toCharArray();
		NodeWS cur = root;
		find(cur, strToChar, 0);
		return this.count;
	}

}

public class wordSearch {

	public static int[] solution(String[] words, String[] queries) {
		int[] answer = new int[queries.length];
		TrieWS trie = new TrieWS();
		TrieWS trieRv = new TrieWS();
		HashMap<String, Integer> hsmap = new HashMap<>();
		for (int i = 0; i < words.length; i++) {
			trieRv.add(words[i], 0);
			trie.add(words[i], 1);
		}
		for (int i = 0; i < queries.length; i++) {
			trie.count = 0;
			trieRv.count = 0;
			if (hsmap.get(queries[i]) == null) {
				if (queries[i].charAt(0) == '?') {
					answer[i] = trieRv.search(new StringBuilder().append(queries[i]).reverse().toString());
				} else {
					answer[i] = trie.search(queries[i]);
				}
				hsmap.put(queries[i], answer[i]);
			} else {
				answer[i] = hsmap.get(queries[i]);
			}

		}
		return answer;
	}

	public static void main(String[] args) {
		System.out.println(
				Arrays.toString(solution(new String[] { "frodo", "front", "frost", "frozen", "frame", "kakao" },
						new String[] { "fro??", "????o", "fr???", "fro???", "pro?" })));
	}

}
