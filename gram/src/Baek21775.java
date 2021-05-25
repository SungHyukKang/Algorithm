import java.util.*;
import java.io.*;

class Hand {
	int id;
	String oper;
	int data;

	public Hand(int id, String oper, int data) {
		this.id = id;
		this.oper = oper;
		this.data = data;
	}

}

public class Baek21775 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] turn = new int[T];
		HashMap<Integer, Boolean> hsmap = new HashMap<>();
		HashMap<Integer, Hand> hands = new HashMap<>();
		for (int i = 0; i < T; i++) {
			turn[i] = Integer.parseInt(st.nextToken());
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			if (hands.get(turn[i]) == null) {
				st = new StringTokenizer(br.readLine());
				int id = Integer.parseInt(st.nextToken());
				String op = st.nextToken();
				int num = -1;
				if (st.hasMoreTokens()) {
					num = Integer.parseInt(st.nextToken());
				}
				if (op.equals("next")) {
				} else if (op.equals("acquire")) {
					if (hsmap.get(num) == null || !hsmap.get(num)) {
						hsmap.put(num, true);
					} else {
						hands.put(turn[i], new Hand(id, op, num));
					}
				} else {
					hsmap.put(num, false);
				}
				sb.append(id + "\n");
			} else {
				Hand h = hands.get(turn[i]);
				int num = h.data;
				int id = h.id;
				if (!hsmap.get(num)) {
					hsmap.put(num, true);
					hands.put(turn[i], null);
				}
				sb.append(id + "\n");
			}
		}
		System.out.println(sb);
	}
}