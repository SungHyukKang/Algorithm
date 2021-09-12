import java.util.*;

public class KAKAO2022_6 {

	public static int solution(int[][] board, int[][] skills) {
		int answer = 0;

		for (int[] skill : skills) {
			int type = skill[0];
			int r1 = skill[1];
			int c1 = skill[2];
			int r2 = skill[3];
			int c2 = skill[4];
			int degree = skill[5];
			for (int i = r1; i <= r2; i++) {
				for (int j = c1; j <= c2; j++) {
					if (type == 1)
						board[i][j] -= degree;
					else
						board[i][j] += degree;
				}
			}
		}
		answer = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] > 0) {
					answer++;
				}
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		solution(new int[][] { { 5, 5, 5, 5, 5 }, { 5, 5, 5, 5, 5 }, { 5, 5, 5, 5, 5 }, { 5, 5, 5, 5, 5 } },
				new int[][] { { 1, 0, 0, 3, 4, 4 }, { 1, 2, 0, 2, 3, 2 }, { 2, 1, 0, 3, 1, 2 }, { 1, 0, 1, 3, 3, 1 } });
	}

}
