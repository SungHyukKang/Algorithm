import java.io.BufferedReader;
import java.io.InputStreamReader;

class UserSolution12372 {
	int[][] users;
	int userCount;

	public void init() {
		users = new int[100001][2];
		userCount = 0;
	}

	public void addUser(int uID, int income) {
		users[userCount][0] = uID;
		users[userCount][1] = income;
		int current = userCount;
		while (current > 0 && users[current][1] >= users[(current - 1) / 2][1]) {
			if (users[current][1] == users[(current - 1) / 2][1]) {
				if (users[current][0] < users[(current - 1) / 2][0]) {
					int tId = users[(current - 1) / 2][0];
					int tIc = users[(current - 1) / 2][1];
					users[(current - 1) / 2][0] = users[current][0];
					users[(current - 1) / 2][1] = users[current][1];
					users[current][0] = tId;
					users[current][1] = tIc;
					current = (current - 1) / 2;
				} else {
					break;
				}
			} else {
				int tId = users[(current - 1) / 2][0];
				int tIc = users[(current - 1) / 2][1];
				users[(current - 1) / 2][0] = users[current][0];
				users[(current - 1) / 2][1] = users[current][1];
				users[current][0] = tId;
				users[current][1] = tIc;
				current = (current - 1) / 2;
			}
		}
		userCount++;
	}

	int[] pop() {
		int banbok = userCount >= 10 ? 10 : userCount;
		int[] result = new int[10];
		int heapSize = userCount;
		int[][] temp = new int[10][2];
		for (int i = 0; i < banbok; i++) {
			int value = users[0][0];
			temp[i][0] = users[0][0];
			temp[i][1] = users[0][1];
			result[i] = value;
			heapSize--;
			users[0][0] = users[heapSize][0];
			users[0][1] = users[heapSize][1];
			int current = 0;
			while (current * 2 + 1 < heapSize) {
				int child;
				if (current * 2 + 2 == heapSize) {
					child = current * 2 + 1;
				} else {
					if (users[current * 2 + 1][1] == users[current * 2 + 2][1]) {
						child = users[current * 2 + 1][0] < users[current * 2 + 2][0] ? current * 2 + 1
								: current * 2 + 2;
					} else {
						child = users[current * 2 + 1][1] > users[current * 2 + 2][1] ? current * 2 + 1
								: current * 2 + 2;
					}
				}
				if (users[current][1] > users[child][1])
					break;
				int tempId = users[current][0];
				int tempIc = users[current][1];
				users[current][0] = users[child][0];
				users[current][1] = users[child][1];
				users[child][0] = tempId;
				users[child][1] = tempIc;
				current = child;
			}
			userCount--;
		}

		for (int i = 0; i < banbok; i++) {
			addUser(temp[i][0], temp[i][1]);
		}

//		System.out.println();
//		for (int i = 0; i < banbok; i++) {
//			System.out.print(result[i] + " ");
//		}
//		System.out.println();
		return result;
	}

	int getTop10(int[] result) {
		int[] cpy = pop();
		for (int i = 0; i < 10; i++) {
			result[i] = cpy[i];
		}
		return userCount >= 10 ? 10 : userCount;
	}
}

public class SWEA12372 {

	private final static int MAX_INPUT = 100000;
	private final static int MAX_NUM = 30000;

	private final static UserSolution12372 usersolution = new UserSolution12372();

	private static BufferedReader br;

	private static int[] input = new int[MAX_INPUT];
	private static long seed = 13410;

	private static long pseudoRand() {
		seed = (seed * 214013 + 2531011) & 0xffffffffL;
		return (seed >> 11) % MAX_NUM;
	}

	private static void makeInput(int inputLen) {
		for (int i = 0; i < inputLen; i++) {
			input[i] = (int) (pseudoRand());
		}
	}

	private static int run() throws Exception {
		int score = 100;
		int N, userNum, uID = 0, ret, sum, ans;
		int[] result = new int[10];
		String str;

		str = br.readLine();
		N = Integer.parseInt(str);

		for (int i = 0; i < N; i++) {
			str = br.readLine();
			userNum = Integer.parseInt(str);
			makeInput(userNum);

			for (int j = 0; j < userNum; j++) {
				usersolution.addUser(uID++, input[j]);
			}
			ret = usersolution.getTop10(result);

			sum = 0;
			for (int j = 0; j < ret; j++) {
				sum += result[j];
			}
			str = br.readLine();
			ans = Integer.parseInt(str);
			if (sum != ans) {
				score = 0;
			}
		}
		return score;
	}

	public static void main(String[] args) throws Exception {
		int TC;
		// System.setIn(new java.io.FileInputStream("res/sample_input.txt"));

		br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		TC = Integer.parseInt(str);

		for (int tc = 1; tc <= TC; tc++) {
			usersolution.init();
			System.out.println("#" + tc + " " + run());
		}
	}
}