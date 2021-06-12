import java.util.*;
import java.io.*;

public class Baek5021 {
	static Map<String, ArrayList<String>> hsmap = new HashMap<>();
	static Map<String, Double> val = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		String king = br.readLine();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String son = st.nextToken();
			String mot = st.nextToken();
			String fat = st.nextToken();
			hsmap.put(son, new ArrayList<>());
			hsmap.get(son).add(mot);
			hsmap.get(son).add(fat);
			val.put(son, 0.0);
			val.put(fat, 0.0);
			val.put(mot, 0.0);
		}
		hsmap.put(king, new ArrayList<>());
		val.put(king, 1.0);
		double max = 0;
		String answer = "";
		while (M-- > 0) {
			String jasik = br.readLine();
			if (val.get(jasik) == null)
				continue;
			dfs(jasik);
			if (max < val.get(jasik)) {
				answer = jasik;
				max = val.get(jasik);
			}
		}
		System.out.println(answer);
	}

	public static void dfs(String name) {
		if (hsmap.get(name) == null || hsmap.get(name).size() == 0) {
			return;
		}
		for (String X : hsmap.get(name)) {
			dfs(X);
			val.put(name, (val.get(hsmap.get(name).get(0)) + val.get(hsmap.get(name).get(1))) / 2);
		}
		return;
	}

}
