import java.util.*;

public class wcc_2 {
	static int row;
	static int col;

	static class Pair {
		int x, y, d, cnt;

		public Pair(int x, int y, int cnt, int d) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.d = d;
		}

	}

	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static int[] solution(String[] grid) {
		int[] answer = {};
		ArrayList<Integer> list = new ArrayList<>();
		row = grid.length;
		col = grid[0].length();
		char[][] arr = new char[row][col];
		int cnt = 0;
		for (String X : grid) {
			arr[cnt] = X.toCharArray();
			cnt++;
		}
		boolean[][][] visited = new boolean[4][row][col];
		Queue<Pair> q = new LinkedList<>();
		for (int xx = 0; xx < row; xx++) {
			for (int yy = 0; yy < col; yy++) {
				for (int i = 0; i < 4; i++) {
					q.offer(new Pair(xx, yy, 1, i));
					visited[i][xx][yy] = true;
					while (!q.isEmpty()) {
						Pair p = q.poll();
						int x = p.x;
						int y = p.y;
						int count = p.cnt;
						int d = p.d;
						if (arr[x][y] == 'S') {
							int nx = dx[dirS(d)] + x;
							int ny = dy[dirS(d)] + y;
							if (!isPossible(nx, ny)) {
								if (nx < 0 || nx >= row) {
									if (nx < 0) {
										nx = row - 1;
									} else {
										nx = 0;
									}
								} else {
									if (ny < 0) {
										ny = col - 1;
									} else {
										ny = 0;
									}
								}
							}
							if (!visited[dirS(d)][nx][ny] && d == dirS(d)) {
								if (x == nx && y == ny)
									continue;
								q.offer(new Pair(nx, ny, count + 1, dirS(d)));
								visited[dirS(d)][nx][ny] = true;
							}
						} else if (arr[x][y] == 'L') {
							int nx = dx[dirL(d)] + x;
							int ny = dy[dirL(d)] + y;
							if (!isPossible(nx, ny)) {
								if (nx < 0 || nx >= row) {
									if (nx < 0) {
										nx = row - 1;
									} else {
										nx = 0;
									}
								} else {
									if (ny < 0) {
										ny = col - 1;
									} else {
										ny = 0;
									}
								}
							}
							if (!visited[dirL(d)][nx][ny]) {
								if (x == nx && y == ny && d == dirL(d))
									continue;
								q.offer(new Pair(nx, ny, count + 1, dirL(d)));
								visited[dirL(d)][nx][ny] = true;
							}
						} else if (arr[x][y] == 'R') {
							int nx = dx[dirR(d)] + x;
							int ny = dy[dirR(d)] + y;
							if (!isPossible(nx, ny)) {
								if (nx < 0 || nx >= row) {
									if (nx < 0) {
										nx = row - 1;
									} else {
										nx = 0;
									}
								} else {
									if (ny < 0) {
										ny = col - 1;
									} else {
										ny = 0;
									}
								}
							}
							if (!visited[dirR(d)][nx][ny]) {
								if (x == nx && y == ny && d == dirR(d))
									continue;
								q.offer(new Pair(nx, ny, count + 1, dirR(d)));
								visited[dirR(d)][nx][ny] = true;
							}
						}
					}
					int[] end = tend(visited);
					if (end[1] == 1) {
						if (list.size() > 0 && list.get(list.size() - 1) == end[0])
							continue;
						list.add(end[0]);
						break;
					} else {
						if (list.size() > 0 && list.get(list.size() - 1) == end[0])
							continue;
						list.add(end[0]);
					}
				}
			}
		}

		answer = new int[list.size()];
		answer[0] = list.get(0);
		for (int i = 0; i < list.size() - 1; i++) {
			answer[i + 1] = list.get(i + 1) - list.get(i);
		}
		Arrays.sort(answer);
		System.out.println(Arrays.toString(answer));
		return answer;

	}

	public static int[] tend(boolean[][][] visited) {
		int cnt = 0;
		int tf = 1;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < row; j++) {
				for (int k = 0; k < col; k++) {
					if (!visited[i][j][k]) {
						tf = 0;
					} else
						cnt++;
				}
			}
		}
		return new int[] { cnt, tf };
	}

	public static boolean isPossible(int x, int y) {
		if (x < 0 || x >= row || y < 0 || y >= col) {
			return false;
		}
		return true;
	}

	// 0: 동 1 : 남 2: 서 3: 북
	public static int dirS(int d) {
		return d;
	}

	public static int dirL(int d) {
		if (d == 0) {
			return 3;
		} else if (d == 1) {
			return 0;
		} else if (d == 2) {
			return 1;
		} else {
			return 2;
		}
	}

	public static int dirR(int d) {
		if (d == 0) {
			return 1;
		} else if (d == 1) {
			return 2;
		} else if (d == 2) {
			return 3;
		} else {
			return 0;
		}
	}

	public static void main(String[] args) {
		solution(new String[] { "SL", "LR" });
//		solution(new String[] { "S" });
//		solution(new String[] { "S", "S" });
	}

}
