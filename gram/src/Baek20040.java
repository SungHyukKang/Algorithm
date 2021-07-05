import java.util.*;
import java.io.*;

public class Baek20040 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] parent = new int[N + 1];
		for (int i = 0; i <= N; i++)
			parent[i] = i;
		int cnt = 1;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int aRoot = find(s, parent);
			int bRoot = find(e, parent);
			if (aRoot == bRoot) {
				System.out.println(cnt);
				return;
			}
			union(s, e, parent);
			cnt++;
		}
		System.out.println(0);
	}

	public static void union(int a, int b, int[] parent) {
		int aRoot = find(a, parent);
		int bRoot = find(b, parent);
		if (aRoot != bRoot) {
			parent[bRoot] = a;
		} else
			return;
	}

	public static int find(int a, int[] parent) {
		if (a == parent[a])
			return a;
		parent[a] = find(parent[a], parent);
		return parent[a];
	}

}
