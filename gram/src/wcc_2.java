import java.util.*;

public class wcc_2 {
	static int row;
	static int col;

	static class Pair {
		int x, y, d;

		public Pair(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}

	}

	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static int[] solution(String[] grid) {
		ArrayList<Integer> list = new ArrayList<>();
		row = grid.length;
		col = grid[0].length();
		char[][] arr = new char[row][col];
		int idx = 0;
		for (String X : grid) {
			arr[idx] = X.toCharArray();
			idx++;
		}
		boolean[][][] visited = new boolean[4][row][col];
		for (int xx = 0; xx < row; xx++) {
			for (int yy = 0; yy < col; yy++) {
				for (int i = 0; i < 4; i++) {
					Queue<Pair> q = new LinkedList<>();
					q.offer(new Pair(xx, yy, i));
					int count = 0;
					if (!visited[i][xx][yy]) {
						visited[i][xx][yy] = true;
						while (!q.isEmpty()) {
							Pair p = q.poll();
							int x = p.x;
							int y = p.y;
							int d = p.d;
							count++;
							int nx;
							int ny;
							int dirD;
							if (arr[x][y] == 'S') {
								nx = dx[dirS(d)] + x;
								ny = dy[dirS(d)] + y;
								dirD = dirS(d);
								if (!isPossible(nx, ny)) {
									if (nx < 0) {
										nx = row - 1;
									} else if (nx >= row) {
										nx = 0;
									} else if (ny < 0) {
										ny = col - 1;
									} else {
										ny = 0;
									}
								}
							} else if (arr[x][y] == 'L') {
								nx = dx[dirL(d)] + x;
								ny = dy[dirL(d)] + y;
								dirD = dirL(d);
								if (!isPossible(nx, ny)) {
									if (nx < 0) {
										nx = row - 1;
									} else if (nx >= row) {
										nx = 0;
									} else if (ny < 0) {
										ny = col - 1;
									} else {
										ny = 0;
									}
								}
							} else {
								nx = dx[dirR(d)] + x;
								ny = dy[dirR(d)] + y;
								dirD = dirR(d);
								if (!isPossible(nx, ny)) {
									if (nx < 0) {
										nx = row - 1;
									} else if (nx >= row) {
										nx = 0;
									} else if (ny < 0) {
										ny = col - 1;
									} else {
										ny = 0;
									}
								}
							}
							if (!visited[dirD][nx][ny]) {
								q.offer(new Pair(nx, ny, dirD));
								visited[dirD][nx][ny] = true;
							}
						}
						list.add(count);
					}
				}
			}
		}

		int[] answer = new int[list.size()];
		int i = 0;
		for (int x : list) {
			answer[i++] = x;
		}
		Arrays.sort(answer);
		return answer;
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
//		solution(new String[] { "SL", "LR" });
//		solution(new String[] { "S" });
		solution(new String[] { "S", "S" });
	}

}
