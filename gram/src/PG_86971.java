import java.util.*;

public class PG_86971 {
	static ArrayList<ArrayList<Integer>> adjlist = new ArrayList<>();
	static boolean[] visited;

	public static int solution(int n, int[][] wires) {
		for (int i = 0; i <= n; i++)
			adjlist.add(new ArrayList<>());
		visited = new boolean[n + 1];
		for (int i = 0; i < wires.length; i++) {
			adjlist.get(wires[i][0]).add(wires[i][1]);
			adjlist.get(wires[i][1]).add(wires[i][0]);
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < wires.length; i++) {
			int v1 = wires[i][0];
			int v2 = wires[i][1];
			visited = new boolean[n + 1];
			visited[v2] = true;
			min = Math.min(min, Math.abs(dfs(v1) - dfs(v2)));
		}
		return min;
	}

	public static int dfs(int start) {

		visited[start] = true;
		int sum = 1;
		for (int next : adjlist.get(start)) {
			if (!visited[next]) {
				sum += dfs(next);
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		solution(9, new int[][] { { 1, 3 }, { 2, 3 }, { 3, 4 }, { 4, 5 }, { 4, 6 }, { 4, 7 }, { 7, 8 }, { 7, 9 } });
	}

}
