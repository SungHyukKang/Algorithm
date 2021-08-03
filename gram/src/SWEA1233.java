import java.util.*;
import java.io.*;

class NodeS1233 {
	int left;
	int data;
	int right;

	NodeS1233(int data) {
		this.data = data;
	}

}

class TreeS1233 {
	NodeS1233[] tree;

	public TreeS1233() {
		tree = new NodeS1233[1001];
	}

	public void add(int idx, int data, int left, int right) {
		tree[idx] = new NodeS1233(data);
		tree[idx].left = left;
		tree[idx].right = right;
	}

	public boolean inorder(NodeS1233 node) {
		if (node == null) {
			return false;
		}
		System.out.println(node.data);
		if (node.data >= '0' && node.data <= '9') {
			if (node.left != -1 || node.right != -1) {
				return false;
			} else {
				return true;
			}
		} else {
			if (node.left == -1 || node.right == -1) {
				return false;
			}
			return (inorder(tree[node.left]) && inorder(tree[node.right]));
		}

	}

}

public class SWEA1233 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= 10; t++) {
			int N = Integer.parseInt(br.readLine());
			TreeS1233 ts = new TreeS1233();
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int idx = Integer.parseInt(st.nextToken());
				int data = -1;
				int left = -1;
				int right = -1;
				if (st.countTokens() == 3) {
					data = st.nextToken().charAt(0);
					left = Integer.parseInt(st.nextToken());
					right = Integer.parseInt(st.nextToken());
					ts.add(idx, data, left, right);
				} else {
					data = st.nextToken().charAt(0);
					ts.add(idx, data, left, right);
				}
			}
			sb.append("#" + t + " " + (ts.inorder(ts.tree[1]) ? 1 : 0) + "\n");
		}
		System.out.println(sb);
	}

}
