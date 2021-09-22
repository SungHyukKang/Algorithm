import java.util.*;
import java.util.Map.Entry;
import java.io.*;

public class PG72412 {

	public static HashMap<String, ArrayList<Integer>> hsmap = new HashMap<String, ArrayList<Integer>>();
	static String[] lang = { "cpp", "java", "python", "-" };
	static String[] apply = { "backend", "frontend", "-" };
	static String[] carrer = { "junior", "senior", "-" };
	static String[] soulfood = { "chicken", "pizza", "-" };

	public static void setting() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 3; k++) {
					for (int z = 0; z < 3; z++) {
						hsmap.put(lang[i] + apply[j] + carrer[k] + soulfood[z], new ArrayList<>());
					}
				}
			}
		}
	}

	public static void infoSet(String[] str) {
		String first = str[0];
		String second = str[1];
		String third = str[2];
		String fourth = str[3];
		int score = Integer.parseInt(str[4]);
		String joker = "-";
		hsmap.get(first + second + third + fourth).add(score);
		hsmap.get(first + second + third + joker).add(score);
		hsmap.get(first + second + joker + fourth).add(score);
		hsmap.get(first + joker + third + fourth).add(score);
		hsmap.get(joker + second + third + fourth).add(score);
		hsmap.get(joker + joker + third + fourth).add(score);
		hsmap.get(joker + second + joker + fourth).add(score);
		hsmap.get(joker + second + third + joker).add(score);
		hsmap.get(first + joker + joker + fourth).add(score);
		hsmap.get(first + joker + third + joker).add(score);
		hsmap.get(first + second + joker + joker).add(score);
		hsmap.get(first + joker + joker + joker).add(score);
		hsmap.get(joker + second + joker + joker).add(score);
		hsmap.get(joker + joker + third + joker).add(score);
		hsmap.get(joker + joker + joker + fourth).add(score);
		hsmap.get(joker + joker + joker + joker).add(score);
	}

	public static int[] solution(String[] info, String[] queries) {
		int[] answer = new int[queries.length];
		setting();
		for (int i = 0; i < info.length; i++) {
			infoSet(info[i].split(" "));
		}
		for (Entry<String, ArrayList<Integer>> entrySet : hsmap.entrySet()) {
			Collections.sort(entrySet.getValue());
		}
		int i = 0;
		for (String query : queries) {
			int cut = query.lastIndexOf(" ") + 1;
			int score = Integer.parseInt(query.substring(cut));
			String key = query.substring(0, cut - 1).replaceAll(" and ", "");
			ArrayList<Integer> temp = hsmap.get(key);
			int left = 0;
			int right = temp.size() - 1;
			while (left <= right) {
				int mid = (left + right) / 2;
				if (temp.get(mid) < score) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
			answer[i++] = temp.size() - left;
		}
		return answer;
	}

	public static void main(String[] args) {
		solution(
				new String[] { "java backend junior pizza 150", "python frontend senior chicken 210",
						"python frontend senior chicken 150", "cpp backend senior pizza 260",
						"java backend junior chicken 80", "python backend senior chicken 50" },
				new String[] { "java and backend and junior and pizza 100",
						"python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250",
						"- and backend and senior and - 150", "- and - and - and chicken 100",
						"- and - and - and - 150" });
	}

}
