import java.util.*;

public class 다칫판_프로그래머스 {

	public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
		int[] answer = new int[enroll.length];
		HashMap<String, String> hsmap = new HashMap<>();
		HashMap<String, Integer> income = new HashMap<>();
		int c = 0;
		for (String X : referral) {
			hsmap.put(enroll[c], X);
			income.put(X, 0);
			income.put(enroll[c], 0);
			c++;
		}
		for (int i = 0; i < seller.length; i++) {
			String sell = seller[i];
			int benefit = amount[i] * 100;
			int init = income.get(sell);
			int painit = income.get(hsmap.get(sell));
			income.put(sell, (int) (init + benefit * 0.9));
			income.put(hsmap.get(sell), (int) (painit + benefit * 0.1));
			sell = hsmap.get(sell);
			int dadan = benefit / 10;
			while (!sell.equals("-")) {
				income.put(sell, (int) (income.get(sell) - dadan / 10));
				income.put(hsmap.get(sell), (int) (income.get(hsmap.get(sell)) + dadan / 10));
				dadan = dadan / 10;
				sell = hsmap.get(sell);
			}

		}
		for (int i = 0; i < enroll.length; i++) {
			answer[i] = income.get(enroll[i]);
		}
		return answer;
	}

	public static void main(String[] args) {
		solution(new String[] { "john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young" },
				new String[] { "-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward" },
				new String[] { "young", "john", "tod", "emily", "mary" }, new int[] { 12, 4, 2, 5, 10 });
	}

}
