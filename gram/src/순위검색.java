import java.util.*;

class 순위검색 {
	static HashMap<String, Integer> hsmap = new HashMap<>();
	static boolean[] visited;
	static char[] order;

	public String[] solution(String[] orders, int[] course) {
		String[] answer;
		for (int i = 0; i < orders.length; i++) {
			ArrayList<Character> aaa = new ArrayList<>();
			order = new char[orders[i].length()];
			visited = new boolean[orders[i].length()];
			for (int j = 0; j < orders[i].length(); j++) {
				aaa.add(orders[i].charAt(j));
			}
			Collections.sort(aaa);
			for (int j = 0; j < aaa.size(); j++) {
				order[j] = aaa.get(j);
			}
			dfs(0, 0, "");
		}

		ArrayList<String> ans = new ArrayList<>();
		for (int i = 0; i < course.length; i++) {
			int max = 0;
			for (String Z : hsmap.keySet()) {
				if (Z.length() == course[i] && hsmap.get(Z) >= 2) {
					if (max < hsmap.get(Z)) {
						max = hsmap.get(Z);
					}
				}
			}
			for (String C : hsmap.keySet()) {
				if (hsmap.get(C) == max && C.length() == course[i]) {
					ans.add(C);
				}
			}

		}
		Collections.sort(ans);
		answer = new String[ans.size()];
		int i = 0;
		for (String C : ans)
			answer[i++] = C;
		return answer;
	}

	public static void dfs(int idx, int cnt, String orders) {
		if (cnt >= 2) {
			hsmap.put(orders, hsmap.getOrDefault(orders, 0) + 1);
		}
		for (int i = idx; i < order.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				dfs(i + 1, cnt + 1, orders + order[i]);
				visited[i] = false;
			}
		}
	}

	public static void main(String[] args) {
		순위검색 pb = new 순위검색();
		pb.solution(new String[] { "ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH" }, new int[] { 2, 3, 4 });

	}

}