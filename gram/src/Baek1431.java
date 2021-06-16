import java.util.*;
import java.io.*;

class Node1431 {
	String str;
	int sum;

	public Node1431(String str, int sum) {
		this.str = str;
		this.sum = sum;
	}

}

public class Baek1431 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Node1431> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			int sum = 0;
			for (int j = 0; j < str.length(); j++) {
				int num = str.charAt(j) - '0';
				if (num <= 9) {
					sum += num;
				}
			}
			list.add(new Node1431(str, sum));
		}

		Collections.sort(list, new Comparator<Node1431>() {

			@Override
			public int compare(Node1431 o1, Node1431 o2) {
				if (o1.str.length() < o2.str.length()) {
					return -1;
				} else if (o1.str.length() == o2.str.length()) {
					if (o1.sum < o2.sum) {
						return -1;
					} else if (o1.sum == o2.sum) {
						return o1.str.compareTo(o2.str);
					}
				}
				return 1;
			}

		});
		StringBuilder sb = new StringBuilder();
		for (Node1431 n : list) {
			sb.append(n.str + "\n");
		}
		System.out.println(sb);
	}

}
