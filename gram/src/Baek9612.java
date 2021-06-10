import java.util.*;
import java.io.*;

public class Baek9612 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashMap<String, Integer> hsmap = new HashMap<>();
		int max = 0;
		for (int i = 0; i < N; i++) {
			String animal = br.readLine();
			hsmap.put(animal, hsmap.getOrDefault(animal, 0) + 1);
			max = Math.max(hsmap.get(animal), max);
		}
		ArrayList<String> list = new ArrayList<>();
		for (String z : hsmap.keySet()) {
			if (hsmap.get(z) == max)
				list.add(z);
		}
		Collections.sort(list, Collections.reverseOrder());
		System.out.println(list.get(0) + " " + hsmap.get(list.get(0)));
	}

}
