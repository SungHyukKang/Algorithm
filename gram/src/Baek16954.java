import java.util.*;
import java.io.*;

class Pair16954 {
	int x, y;
	int cnt;

	public Pair16954(int x, int y, int cnt) {
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}

}

public class Baek16954 {

	static int[][][] arr = new int[8][8][8];
	static ArrayList<Pair16954> wall = new ArrayList<>();
	static Queue<Pair16954> q = new LinkedList<>();
	static int[] nx = { 1, 1, 1, 0, 0, 0, -1, -1, -1 };
	static int[] ny = { -1, 0, 1, -1, 0, 1, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 8; i++) {
			String X = br.readLine();
			for (int j = 0; j < 8; j++) {
				if (X.charAt(j) == '#') {
					arr[0][i][j] = -1;
				}
			}
		}
		for (int i = 1; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				for (int z = 0; z < 8; z++) {
					if (j - 1 >= 0)
						arr[i][j][z] = arr[i - 1][j - 1][z];
				}
			}
		}
		q.offer(new Pair16954(7, 0, 0));
		while (!q.isEmpty()) {
			Pair16954 p = q.poll();
			int x = p.x;
			int y = p.y;
			int cnt = p.cnt;
			if ((x == 0 && y == 7) || cnt >= 7) {
				System.out.println("1");
				return;
			}

			for (int i = 0; i < 9; i++) {
				int dx = nx[i] + x;
				int dy = ny[i] + y;

				if (isPossible(dx, dy) && arr[cnt + 1][dx][dy] != -1 && arr[cnt][dx][dy] != -1) {
					q.offer(new Pair16954(dx, dy, cnt + 1));
				}
			}

		}
		System.out.println("0");
	}

	public static void print(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[i][j] == -1)
					System.out.print("# ");
				else
					System.out.print(". ");

			}
			System.out.println();
		}
		System.out.println("--------------------------");
	}

	public static boolean isPossible(int x, int y) {
		if (x < 0 || x >= 8 || y < 0 || y >= 8)
			return false;

		return true;
	}
}
