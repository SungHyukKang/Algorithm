import java.util.*;

import java.io.*;

class NodeS1231 {
	int left;
	char data;
	int right;

	public NodeS1231(char data) {
		this.data = data;
	}

}

class BSTS1231 {
	NodeS1231[] tree;
	StringBuilder sb = new StringBuilder();

	public BSTS1231() {
		tree = new NodeS1231[101];
	}

	public void add(int idx, char data, int left, int right) {
		tree[idx] = new NodeS1231(data);
		if (left != -1)
			tree[idx].left = left;
		if (right != -1)
			tree[idx].right = right;
	}

	public void inorder(int idx) {
		if (tree[idx] == null)
			return;
		inorder(tree[idx].left);
		sb.append(tree[idx].data);
		inorder(tree[idx].right);
	}
}

public class SWEA1231 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder a = new StringBuilder();
		for (int t = 1; t <= 10; t++) {
			int N = Integer.parseInt(br.readLine());
			int cnt = N - 1;
			BSTS1231 bsts = new BSTS1231();
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int nodeIdx = Integer.parseInt(st.nextToken());
				char data = st.nextToken().charAt(0);
				int left = -1;
				int right = -1;
				if (cnt != 0) {
					left = Integer.parseInt(st.nextToken());
					cnt--;
				}
				if (cnt != 0) {
					right = Integer.parseInt(st.nextToken());
					cnt--;
				}
				bsts.add(nodeIdx, data, left, right);
			}
			bsts.inorder(1);
			a.append("#" + t + " " + bsts.sb.toString() + "\n");
		}
		System.out.println(a);
	}

}
