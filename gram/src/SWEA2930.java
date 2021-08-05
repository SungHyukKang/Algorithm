import java.util.*;
import java.io.*;

class TreeS2930 {
	int[] tree;
	int heapSize;

	public void init(int N) {
		tree = new int[N];
		heapSize = 0;
	}

	public void add(int data) {
		tree[heapSize] = data;
		int current = heapSize;
		heapSize++;

		while (current > 0 && tree[current] > tree[(current - 1) / 2]) {
			int temp = tree[current];
			tree[current] = tree[(current - 1) / 2];
			tree[(current - 1) / 2] = temp;
			current = (current - 1) / 2;
		}
	}

	public int pop() {
		if (heapSize == 0)
			return -1;
		int value = tree[0];
		heapSize--;
		tree[0] = tree[heapSize];
		int treeCount = heapSize;
		int current = 0;
		while (current * 2 + 1 < treeCount) {
			int child;
			if (current * 2 + 2 == treeCount) {
				child = current * 2 + 1;
			} else {
				child = tree[current * 2 + 1] > tree[current * 2 + 2] ? current * 2 + 1 : current * 2 + 2;
			}
			if (tree[current] > tree[child])
				break;

			int temp = tree[current];
			tree[current] = tree[child];
			tree[child] = temp;
			current = child;
		}

		return value;
	}

}

public class SWEA2930 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			TreeS2930 tr = new TreeS2930();
			tr.init(N);
			sb.append("#" + t + " ");
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int com = Integer.parseInt(st.nextToken());
				int data;
				if (com == 1) {
					data = Integer.parseInt(st.nextToken());
					tr.add(data);
				} else {
					data = tr.pop();
					sb.append(data + " ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
