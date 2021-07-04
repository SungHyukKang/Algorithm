import java.util.*;
import java.io.*;

public class Baek4358 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String X;
		HashMap<String, Integer> hsmap = new HashMap<>();
		int cnt = 0;
		while ((X = br.readLine()) != null) {
			if (X.equals(""))
				break;
			cnt++;
			hsmap.put(X, hsmap.getOrDefault(X, 0) + 1);
		}
		HashMap<String, Double> hsmap2 = new HashMap<String, Double>();
		ArrayList<String> list = new ArrayList<>();
		for (String Z : hsmap.keySet()) {
			hsmap2.put(Z, (double) hsmap.get(Z) / cnt * 100);
			list.add(Z);
		}
		Collections.sort(list);
		StringBuilder sb = new StringBuilder();
		for (String Z : list) {
			sb.append(Z + " " + String.format("%.4f", hsmap2.get(Z)) + "\n");
		}
		System.out.println(sb);
	}

}
