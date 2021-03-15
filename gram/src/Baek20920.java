import java.util.*;
import java.io.*;

class Word20920 {
	int cnt;
	String word;

	public Word20920(int cnt, String word) {
		this.cnt = cnt;
		this.word = word;
	}

	@Override
	public String toString() {
		return "Word20920 [cnt=" + cnt + ", word=" + word + "]";
	}

}

public class Baek20920 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<String, Integer> hsmap = new HashMap<>();
		for (int i = 0; i < N; i++) {
			String X = br.readLine();
			if (X.length() < M)
				continue;
			hsmap.put(X, hsmap.getOrDefault(X, 0) + 1);
		}
		ArrayList<Word20920> list = new ArrayList<>();
		for (String X : hsmap.keySet()) {
			list.add(new Word20920(hsmap.get(X), X));
		}
		Collections.sort(list, new Comparator<Word20920>() {

			@Override
			public int compare(Word20920 o1, Word20920 o2) {
				if (o1.cnt < o2.cnt) {
					return 1;
				} else if (o1.cnt == o2.cnt) {
					if (o1.word.length() < o2.word.length()) {
						return 1;
					} else if (o1.word.length() == o2.word.length()) {
						return o1.word.compareTo(o2.word);
					}
				}
				return -1;
			}
		});
		for (Word20920 w : list) {
			bw.write(w.word);
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
