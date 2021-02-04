public class 쿼드압축_후_개수_세기 {
	static int[][] map;
	static int[] ans;

	public int[] solution(int[][] arr) {
		int[] answer = new int[2];
		ans = answer;
		map = arr;
		divide(0, 0, arr.length);
		return answer;
	}

	public static boolean isPossible(int r, int c, int N) {
		int start = map[r][c];
		for (int i = r; i < r + N; i++) {
			for (int j = c; j < c + N; j++) {
				if (start != map[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

	public static void divide(int r, int c, int N) {
		if (isPossible(r, c, N)) {
			if (map[r][c] == 0) {
				ans[0]++;
			} else
				ans[1]++;
		} else {
			int size = N / 2;
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 2; j++) {
					divide(r + i * size, c + j * size, size);
				}
			}
		}
	}

}
