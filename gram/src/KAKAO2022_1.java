import java.util.*;

public class KAKAO2022_1 {

	public static int[] solution(String[] id_list, String[] report, int k) {
		HashMap<String, Integer> hsmap = new HashMap<>();
		for (int i = 0; i < id_list.length; i++) {
			hsmap.put(id_list[i], i);
		}
		boolean[][] visited = new boolean[id_list.length][id_list.length];
		HashMap<Integer, Integer> toCount = new HashMap<>();
		for (String str : report) {
			StringTokenizer st = new StringTokenizer(str);
			int to = hsmap.get(st.nextToken());
			int from = hsmap.get(st.nextToken());
			if (!visited[to][from]) {
				toCount.put(from, toCount.getOrDefault(from, 0) + 1);
				visited[to][from] = true;
			}
		}
		int[] answer = new int[id_list.length];
		for (int singo : toCount.keySet()) {
			if (toCount.get(singo) >= k) {
				for (int i = 0; i < id_list.length; i++) {
					if (visited[i][singo]) {
						answer[i]++;
					}
				}
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		solution(new String[] { "muzi", "frodo", "apeach", "neo" },
				new String[] { "muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi" }, 2);
	}

}
