import java.util.*;
import java.io.*;

class Pair1132 {
	char alpha;
	long size;

	public Pair1132(char alpha, long size) {
		this.alpha = alpha;
		this.size = size;
	}

	@Override
	public String toString() {
		return "Pair1132 [alpha=" + alpha + ", size=" + size + "]";
	}

}

public class Baek1132 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<String> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			list.add(br.readLine());
		}
		HashMap<Character, Long> hsmap = new HashMap<>();
		for (int i = 0; i < list.size(); i++) {
			char[] ch = list.get(i).toCharArray();
			for (int j = 0; j < ch.length; j++) {
				hsmap.put(ch[j], hsmap.getOrDefault(ch[j], (long) 0) + (long) Math.pow(10, ch.length - j - 1));
			}
		}
		ArrayList<Pair1132> al = new ArrayList<>();
		for (char x : hsmap.keySet()) {
			al.add(new Pair1132(x, hsmap.get(x)));
		}

		Collections.sort(al, new Comparator<Pair1132>() {

			@Override
			public int compare(Pair1132 o1, Pair1132 o2) {
				return o1.size <= o2.size ? 1 : -1;
			}
		});
		long answer = 0;
		int num = 9;
		ArrayList<Pair1132> pairs = new ArrayList<>();
		for (Pair1132 p : al) {
			pairs.add(new Pair1132(p.alpha, num--));
		}

		while (true) {
			Collections.sort(pairs, new Comparator<Pair1132>() {
				@Override
				public int compare(Pair1132 o1, Pair1132 o2) {
					return o1.size <= o2.size ? -1 : 1;
				}
			});
			boolean tf = true;
			for (String Z : list) {
				if (Z.charAt(0) == pairs.get(0).alpha && pairs.get(0).size == 0) {
					pairs.get(0).size = pairs.get(1).size * 10;
					pairs.get(1).size = 0;
					tf = false;
				}
			}
			if (tf)
				break;
		}
		HashMap<Character, Integer> map = new HashMap<>();
		for (Pair1132 p : pairs) {
			if (p.size >= 10) {
				map.put(p.alpha, (int) p.size / 10);
			} else {
				map.put(p.alpha, (int) p.size);
			}
		}
		for (Pair1132 p : al) {
			answer += p.size * map.get(p.alpha);
		}
		System.out.println(answer);
	}

}
