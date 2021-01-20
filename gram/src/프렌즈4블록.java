import java.util.*;

public class 프렌즈4블록 {
	public static boolean[][] visited;
	public static boolean[][] visited2;
	static char[][] map;

	public static int solution(int m, int n, String[] board) {
		int answer = 0;
		map = new char[m][n];
		visited = new boolean[m][n];
		int idx = 0;
		for (String X : board) {
			for (int j = 0; j < X.length(); j++) {
				map[idx][j] = X.charAt(j);
			}
			idx++;
		}
		boolean tf=true;
		while (tf) {
			HashSet<String> hsset = new HashSet<>();
			tf=false;
			visited = new boolean[m][n];
			for (int i = 0; i < m - 1; i++) {
				for (int j = 0; j < n - 1; j++) {
					if (map[i][j] == map[i][j + 1] && map[i][j] == map[i + 1][j + 1] && map[i][j] == map[i + 1][j]&&map[i][j]!='0') {
						visited[i][j] = true;
						visited[i][j + 1] = true;
						visited[i + 1][j + 1] = true;
						visited[i + 1][j] = true;
						hsset.add(String.valueOf(i) +" " +String.valueOf(j));
						hsset.add(String.valueOf(i) +" " +String.valueOf(j + 1));
						hsset.add(String.valueOf(i + 1) +" " + String.valueOf(j + 1));
						hsset.add(String.valueOf(i + 1) + " " +String.valueOf(j));
						tf=true;
					}
				}
			}
			for (int i = map.length - 1; i >= 0; i--) {
				for (int j = 0; j < map[i].length; j++) {
					if (visited[i][j])
						map[i][j] = '0';
				}
			}
			for (int i = map.length - 2; i >= 0; i--) {
				for (int j = 0; j < map[i].length; j++) {
					if (map[i][j] != '0' && map[i + 1][j] == '0') {
						char x = map[i][j];
						dfs(i, j, x);
					}
				}
			}
			answer+=hsset.size();
		}
		System.out.println(answer);
		return answer;
	}

	public static void dfs(int x, int y, char w) {
		if (isPossible(x + 1, y) && map[x + 1][y] == '0') {
			map[x][y] = '0';
			map[x + 1][y] = w;
			dfs(x + 1, y, w);
		}
	}

	public static boolean isPossible(int x, int y) {
		if (x < 0 || x >= map.length)
			return false;
		return true;
	}

	public static void main(String[] args) {
		solution(6,6, new String[]{"AABBEE", "AAAEEE", "VAAEEV", "AABBEE", "AACCEE", "VVCCEE"});
		
		solution(6,2, new String[] {"AA", "AA", "CC", "AA", "AA", "DD"});
	}

}
