package graph;

import java.util.*;

public class Ranking {
	final static int INF = 123456;

	public static int solution(int n, int[][] results) {
		int answer = 0;
		int[][] graph = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				graph[i][j] = INF;
			}
		}
		for (int i = 0; i < results.length; i++) {
			graph[results[i][0]][results[i][1]] = 1;
		}
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (graph[i][j] > graph[i][k] + graph[k][j]) {
						graph[i][j] = graph[i][k] + graph[k][j];
					}
				}
			}
		}

		for (int i = 1; i <= n; i++) {
			int count=0;
			for (int j = 1; j <= n; j++) {
				if(i==j)
					continue;
				if(graph[i][j]!=INF||graph[j][i]!=INF) {
					count++;
				}
			}
			if(count==n-1)
				answer++;
		}
		System.out.println(answer);
		return answer;
	}

	public static void main(String[] args) {
		solution(5, new int[][] { { 4, 3 }, { 4, 2 }, { 3, 2 }, { 1, 2 }, { 2, 5 } });
	}

}
