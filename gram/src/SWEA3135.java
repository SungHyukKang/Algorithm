import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

class TrieS3135 {
	TrieS3135[] child;
	int childNum;
	boolean isTerminal;

	public TrieS3135() {
		this.child = new TrieS3135[26];
		childNum = 0;
		isTerminal = false;
	}

}

class UserSolution3135 {
	TrieS3135 root;

	public void init() {
		root = new TrieS3135();
	}

	public void insert(int buffer_size, String buf) {
		TrieS3135 node = root;

		for (int i = 0; i < buffer_size; i++) {
			int ch = buf.charAt(i) - 'a';
			if (node.child[ch] == null) {
				node.child[ch] = new TrieS3135();
			}
			node.childNum++;
			node = node.child[ch];
		}
		node.childNum++;
		node.isTerminal = true;
	}

	public int query(int buffer_size, String buf) {
		TrieS3135 node = root;
		int answer = 0;
		for (int i = 0; i < buffer_size; i++) {
			if (node.child[buf.charAt(i) - 'a'] == null) {
				return 0;
			}
			node = node.child[buf.charAt(i) - 'a'];
		}
		answer = node.childNum;
		return answer;
	}
}

public class SWEA3135 {

	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);

		UserSolution3135 dictManager = new UserSolution3135();

		for (int TestCase = in.nextInt(), tc = 1; tc <= TestCase; tc = tc + 1) {

			int Query_N = in.nextInt();

			out.print("#" + tc);

			dictManager.init();

			for (int i = 1; i <= Query_N; i++) {
				int type = in.nextInt();

				if (type == 1) {
					String buf = in.next();
					dictManager.insert(buf.length(), buf);
				} else {
					String buf = in.next();
					int answer = dictManager.query(buf.length(), buf);
					out.print(" " + answer);
				}
			}
			out.println("");
		}
		out.close();
	}

	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream), 32768);
			tokenizer = null;
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

	}
}