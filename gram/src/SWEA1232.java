import java.util.*;
import java.io.*;

class NodeS1232 {
	int left;
	char op;
	int data;
	int right;

	NodeS1232(int data, char op) {
		this.data = data;
		this.op = op;
	}

}

class TreeS1232 {
	NodeS1232[] tree;

	public TreeS1232() {
		tree = new NodeS1232[1001];
	}

	public void add(int idx, int data, char op, int left, int right) {
		tree[idx] = new NodeS1232(data, op);
		tree[idx].left = left;
		tree[idx].right = right;
	}

	public int inorder(NodeS1232 node) {
		int leftResult;
		int rightResult;
		if (node.op != '0') {
			leftResult = inorder(tree[node.left]);
			rightResult = inorder(tree[node.right]);
			if (node.op == '+') {
				return leftResult + rightResult;
			} else if (node.op == '-') {
				return leftResult - rightResult;
			} else if (node.op == '/') {
				return leftResult / rightResult;
			} else {
				return leftResult * rightResult;
			}
		} else {
			return node.data;
		}

	}

}

public class SWEA1232 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= 10; t++) {
			int N = Integer.parseInt(br.readLine());
			TreeS1232 ts = new TreeS1232();
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int idx = Integer.parseInt(st.nextToken());
				int data = -1;
				char op = '0';
				int left = -1;
				int right = -1;
				if (st.countTokens() == 3) {
					op = st.nextToken().charAt(0);
					left = Integer.parseInt(st.nextToken());
					right = Integer.parseInt(st.nextToken());
					ts.add(idx, data, op, left, right);
				} else {
					data = Integer.parseInt(st.nextToken());
					ts.add(idx, data, op, left, right);
				}
			}
			sb.append("#" + t + " " + ts.inorder(ts.tree[1]) + "\n");
		}
		System.out.println(sb);
	}

}
