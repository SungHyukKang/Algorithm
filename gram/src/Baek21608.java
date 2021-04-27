import java.util.*;
import java.io.*;

class Node21608 {
	int x, y;
	int friends;
	int empties;

	public Node21608(int x, int y, int friends, int empties) {
		this.x = x;
		this.y = y;
		this.friends = friends;
		this.empties = empties;
	}

	@Override
	public String toString() {
		return "Node21608 [x=" + x + ", y=" + y + ", friends=" + friends + ", empties=" + empties + "]";
	}

}

class Pair21608 {
	int num;
	int[] arr = new int[4];

	public Pair21608(int num, int[] arr) {
		this.num = num;
		this.arr = arr;
	}
}

public class Baek21608 {
	static int N;
	static int[][] map;
	static int[] nx = { 0, 1, 0, -1 };
	static int[] ny = { 1, 0, -1, 0 };
	static int[][] iwf;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		Queue<Pair21608> q = new LinkedList<>();
		map = new int[N][N];
		iwf = new int[N * N + 1][4];
		for (int i = 0; i < N * N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int[] arr = new int[4];
			for (int j = 0; j < arr.length; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			q.offer(new Pair21608(num, arr));
		}

		while (!q.isEmpty()) {
			Pair21608 p = q.poll();
			int num = p.num;
			int[] arr = p.arr;
			iwf[num] = arr;
			ArrayList<Node21608> list = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 0) {
						int friends = 0;
						int empties = 0;
						for (int z = 0; z < 4; z++) {
							int dx = nx[z] + i;
							int dy = ny[z] + j;
							if (isPossible(dx, dy)) {
								if (map[dx][dy] != 0) {
									for (int v = 0; v < 4; v++) {
										if (map[dx][dy] == iwf[num][v]) {
											friends++;
											break;
										}
									}
								} else {
									empties++;
								}
							}
						}
						list.add(new Node21608(i, j, friends, empties));
					}
				}
			}

			Collections.sort(list, new Comparator<Node21608>() {
				@Override
				public int compare(Node21608 o1, Node21608 o2) {
					if (o1.friends < o2.friends) {
						return 1;
					} else if (o1.friends == o2.friends) {
						if (o1.empties < o2.empties) {
							return 1;
						} else if (o1.empties == o2.empties) {
							if (o1.x > o2.x) {
								return 1;
							} else if (o1.x == o2.x) {
								return Integer.compare(o1.y, o2.y);
							}
						}
					}
					return -1;
				}
			});
			map[list.get(0).x][list.get(0).y] = num;
		}
		int ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int cnt = 0;
				for (int z = 0; z < 4; z++) {
					int dx = nx[z] + i;
					int dy = ny[z] + j;
					if (isPossible(dx, dy)) {
						for (int x = 0; x < 4; x++) {
							if (iwf[map[i][j]][x] == map[dx][dy]) {
								cnt++;
							}
						}
					}
				}
				ans += cnt == 1 ? 1 : cnt == 2 ? 10 : cnt == 3 ? 100 : cnt == 4 ? 1000 : 0;
			}
		}
		System.out.println(ans);
	}

	public static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("-----------------------");
	}

	public static boolean isPossible(int x, int y) {
		if (x < 0 || x >= N || y < 0 || y >= N)
			return false;

		return true;
	}

}
