import java.util.*;

class Pairg implements Comparable<Pairg> {
	int idx;
	int val;

	public Pairg(int idx, int val) {
		this.idx = idx;
		this.val = val;
	}

	@Override
	public int compareTo(Pairg o) {
		return this.val >= o.val ? -1 : 1;
	}
}

public class GoldWar {
	static int n;
	static boolean[] visited;
	static HashMap<Integer, Boolean> hsmap = new HashMap<>();
	static int[] gv;
	static PriorityQueue<Pairg> pq = new PriorityQueue<Pairg>();

	public static int solution(int[] goldValues) {
		n = goldValues.length;
		gv = goldValues;
		visited = new boolean[goldValues.length];

		int sum = 0;
		for (int i = 0; i < n; i++) {
			hsmap.put(i, false);
		}
		
		return 0;
	}

	public static void dfs(int nu) {
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[] { 5, 2, 1, 4, 3, 1 }));
		System.out.println("------------------------------------");
		System.out.println(solution(new int[] { 2, 1, 4, 1, 2, 1, 8, 1 }));
	}

}
