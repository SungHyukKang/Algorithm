import java.util.PriorityQueue;

class Nodeno2 implements Comparable<Nodeno2> {
	int s, e, d;

	public Nodeno2(int s, int e, int d) {
		this.s = s;
		this.e = e;
		this.d = d;
	}

	@Override
	public int compareTo(Nodeno2 arg0) {
		return this.d <= arg0.d ? -1 : 1;
	}
}

public class skillcheck_no2 {
	static int[] parent;

	static int find(int s) {
		if (parent[s] == s)
			return s;
		parent[s] = find(parent[s]);
		return parent[s];
	}

	static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot != bRoot)
			parent[aRoot] = b;
		else
			return;
	}

	public static int solution(int n, int[][] costs) {
		int answer = 0;
		parent = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}
		PriorityQueue<Nodeno2> pq = new PriorityQueue<Nodeno2>();

		for (int i = 0; i < costs.length; i++) {
			pq.offer(new Nodeno2(costs[i][0], costs[i][1], costs[i][2]));
		}
		int sum=0;
		while(!pq.isEmpty()) {
			Nodeno2 nd =pq.poll();
			int s=nd.s;
			int e=nd.e;
			int d=nd.d;
			int a = find(s);
			int b = find(e);
			
			if(a==b) {
				continue;
			}
			union(s,e);
			sum+=d;
		}

		return sum;
	}

	public static void main(String[] args) {
		System.out.println(solution(4, new int[][] { { 0, 1, 1 }, { 0, 2, 2 }, { 1, 2, 5 }, { 1, 3, 1 }, { 2, 3, 8 } }));
	}

}
