import java.util.*;
import java.io.*;

class NodeS4038 {
	char[] key;
	int data;
	NodeS4038 next;

	public NodeS4038(char[] key, int data, NodeS4038 next) {
		this.key = key.clone();
		this.data = data;
		this.next = next;
	}

	NodeS4038 alloc(char[] _key, int data, NodeS4038 next) {
		this.key = key.clone();
		this.data = data;
		this.next = next;
		return this;
	}

	NodeS4038 getPrevNode(char[] _key) {
		NodeS4038 node = this;
		while (node.next != null) {
			if (strCmp(_key, node.next.key)) {
				break;
			}
			node = node.next;
		}
		return node;
	}

	boolean strCmp(char[] a, char[] b) {
		int i = 0;

		while (true) {
			if (a[i] != b[i])
				break;
			i++;
		}

		return (a[i] == b[i]);
	}
}

class HashS4038 {
	private final int HASH_SIZE = (1 << 18);
	private final int MAXN = 100000;
	private final int DIV = (HASH_SIZE - 1);
	int bCnt;
	NodeS4038[] buf = new NodeS4038[MAXN];
	NodeS4038[] hashTable = new NodeS4038[HASH_SIZE];

	HashS4038() {
		bCnt = 0;
	}

	int getKey(char[] str) {
		long key = 5381;
		for (int i = 0; i < str.length; i++) {
			key = ((key << 5) + key) + (str[i] - 'a' + 1);
		}

		return (int) (key & DIV);
	}

	int find(char[] key) {
		NodeS4038 prevNode;
		int target = getKey(key);
		prevNode = hashTable[target].getPrevNode(key);
		return prevNode.next.data;
	}

	void add(char[] key, int data) {
		int target = getKey(key);
		hashTable[target].next = buf[bCnt++].alloc(key, data, hashTable[target].next);
	}

	int remove(char[] key) {
		NodeS4038 prevNode, targetNode;
		int target = getKey(key);
		prevNode = hashTable[target].getPrevNode(key);
		targetNode = prevNode.next;
		prevNode.next = targetNode.next;
		return targetNode.data;
	}

}

public class SWEA4038 {

	private static final int HASH_SIZE = (1 << 18);
	private static final int DIV = HASH_SIZE - 1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			char[] B = br.readLine().toCharArray();
			char[] S = br.readLine().toCharArray();
			int bKey = 0;
			int sKey = 0;
			int R = 1;
			for (int i = 0; i < S.length; i++) {
				bKey = ((bKey << 6) + bKey * 3 + (B[i] - '0' + 1)&DIV);
				sKey = ((sKey << 6) + sKey * 3 + (S[i] - '0' + 1)&DIV);
				R = (((R << 6) + R * 3)&DIV);
			}

			int ans = 0;

			for (int i = 0; i <= B.length - S.length; i++) {
				if (sKey == bKey) {
					ans++;
				}
				if (i + S.length < B.length)
					bKey = ((bKey << 6) + 3 * bKey - R * (B[i] - '0' + 1) + (B[i + S.length] - '0' + 1) & DIV);
			}

			sb.append("#" + t + " " + ans + "\n");
		}
		System.out.println(sb);
	}
}
