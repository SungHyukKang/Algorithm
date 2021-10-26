import java.util.*;
import java.io.*;

public class Baek1744 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> plus = new ArrayList<>();
		ArrayList<Integer> zero = new ArrayList<>();
		ArrayList<Integer> minus = new ArrayList<>();
		int sum = 0;
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num > 1) {
				plus.add(num);
			} else if (num < 0) {
				minus.add(num);
			} else if (num == 1) {
				sum++;
			} else {
				zero.add(num);
			}
		}
		Collections.sort(plus, Collections.reverseOrder());
		Collections.sort(minus);

		for (int i = 0; i < plus.size() - 1; i += 2) {
			sum += (plus.get(i) * plus.get(i + 1));
		}
		if ((plus.size() & 1) == 1)
			sum += plus.get(plus.size() - 1);
		for (int i = 0; i < minus.size() - 1; i += 2) {
			sum += (minus.get(i) * minus.get(i + 1));
		}
		if ((minus.size() & 1) == 1) {
			if (zero.size() == 0) {
				sum += minus.get(minus.size() - 1);
			}
		}
		System.out.println(sum);
	}
}