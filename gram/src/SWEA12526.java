import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class NodeS12526 {
	NodeS12526[] child;
	boolean isTerminal;
	boolean isBan;
	int nodeNum;
	int idx;
	int update;
	int idxUpdate;

	public NodeS12526() {
		this.child = new NodeS12526[26];
		this.isTerminal = false;
		this.isBan = false;
		this.nodeNum = 0;
		this.idx = 0;
	}

}

class UserSolutionS12526 {
	NodeS12526 root;
	int nodeNum;
	char[][] str;
	boolean banWord;
	int time;
	int[] count;

	int mstrlen(char[] str) {
		int len = 0;
		while (str[len] != 0)
			++len;
		return len;
	}

	void mstrcpy(char dst[], char src[]) {
		int c = 0;
		while ((dst[c] = src[c]) != 0)
			++c;
	}

	void init() {
		root = new NodeS12526();
		nodeNum = 1;
		str = new char[25001][20];
		time = 1;
		count = new int[25001];
		count[0] = -1;
	}

	void addWord(char[] mWord, NodeS12526 node, int depth) {
		if (depth == mstrlen(mWord)) {
			if (node.isBan) {
				count[node.idx] = -1;
				return;
			}
			if (!node.isTerminal) {
				node.isTerminal = true;
				node.idx = nodeNum;
				node.idxUpdate = time;
				count[node.idx]++;
				str[node.idx] = new char[20];
				if (count[node.idx] >= count[node.nodeNum]) {
					node.nodeNum = node.idx;
					node.update = node.idxUpdate;
				}
				mstrcpy(str[node.idx], mWord);
				nodeNum++;
			} else {
				count[node.idx]++;
				node.idxUpdate = time;
				if (count[node.idx] >= count[node.nodeNum]) {
					node.nodeNum = node.idx;
					node.update = node.idxUpdate;
				}
			}
			return;
		}
		int cToi = mWord[depth] - 'a';
		if (node.child[cToi] == null) {
			node.child[cToi] = new NodeS12526();
		}
		addWord(mWord, node.child[cToi], depth + 1);
		for (int i = 0; i < 26; i++) {
			if (node.child[i] != null) {
				if (count[node.nodeNum] < count[node.child[i].nodeNum]) {
					node.nodeNum = node.child[i].nodeNum;
					node.update = node.child[i].update;
				} else if (count[node.nodeNum] == count[node.child[i].nodeNum]) {
					if (node.update < node.child[i].update) {
						node.nodeNum = node.child[i].nodeNum;
						node.update = node.child[i].update;
					}
				}
			}
		}
	}

	void inputWord(char[] mWord) {
		NodeS12526 cur = root;
		addWord(mWord, cur, 0);
		time++;
	}

	int recommend(char[] mUser, char[] mAnswer) {
		NodeS12526 cur = root;
		int leng = mstrlen(mUser);
		for (int i = 0; i < leng; i++) {
			int cToi = mUser[i] - 'a';
			if (cur.child[cToi] == null) {
				mstrcpy(mAnswer, mUser);
				return leng;
			}
			cur = cur.child[cToi];
		}
		if (cur.nodeNum == 0) {
			mstrcpy(mAnswer, mUser);
			return mstrlen(mUser);
		}
		mstrcpy(mAnswer, str[cur.nodeNum]);
		return mstrlen(mAnswer);
	}

	public void ban(char[] mWord, NodeS12526 node, int depth) {
		if (mstrlen(mWord) == depth) {
			node.isBan = true;
			if (node.idx == node.nodeNum) {
				node.nodeNum = 0;
				node.update = -1;
			}
			count[node.idx] = -1;
			node.idxUpdate = -1;
			return;
		}
		int cToi = mWord[depth] - 'a';
		if (node.child[cToi] == null) {
			node.child[cToi] = new NodeS12526();
		}
		ban(mWord, node.child[cToi], depth + 1);
		if (node.child[cToi].nodeNum == 0) {
			node.nodeNum = 0;
		}
		for (int i = 0; i < 26; i++) {
			if (node.child[i] != null) {
				if (count[node.nodeNum] < count[node.child[i].nodeNum]) {
					node.nodeNum = node.child[i].nodeNum;
					node.update = node.child[i].update;
				} else if (count[node.nodeNum] == count[node.child[i].nodeNum]) {
					if (node.update < node.child[i].update) {
						node.nodeNum = node.child[i].nodeNum;
						node.update = node.child[i].update;
					}
				}
			}
		}
	}

	void banWord(char[] mWord) {
		NodeS12526 cur = root;
		ban(mWord, cur, 0);
	}

}

class SWEA12526 {
	private static BufferedReader br;
	private static UserSolutionS12526 usersolution = new UserSolutionS12526();

	private final static int INPUTWORD = 100;
	private final static int RECOMMEND = 200;
	private final static int BANWORD = 300;

	private static int mstrcmp(char[] str1, char[] str2) {
		int c = 0;
		while (str1[c] != 0 && str1[c] == str2[c]) {
			++c;
		}
		return str1[c] - str2[c];
	}

	private static int mstrlen(char[] str) {
		int len = 0;
		while (str[len] != 0)
			++len;
		return len;
	}

	private static boolean run() throws IOException {
		usersolution.init();

		boolean ret_val = true;

		int N;
		int type;
		char[] mWord = new char[20], mAnswer = new char[20], ans = new char[20];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			type = Integer.parseInt(st.nextToken());

			String rawStr = st.nextToken();
			for (int k = 0; k < rawStr.length(); ++k)
				mWord[k] = rawStr.charAt(k);
			mWord[rawStr.length()] = '\0';

			switch (type) {
			case INPUTWORD:
				usersolution.inputWord(mWord);
				break;
			case RECOMMEND:
				int len = usersolution.recommend(mWord, mAnswer);

				String rawAns = br.readLine();
				for (int k = 0; k < rawAns.length(); ++k)
					ans[k] = rawAns.charAt(k);
				ans[rawAns.length()] = '\0';
				if (!(len == mstrlen(ans) && mstrcmp(mAnswer, ans) == 0))
					ret_val = false;
//				System.out.println(len + " " + mstrlen(ans));
//				System.out.println(Arrays.toString(mAnswer) + " " + Arrays.toString(ans) + " " + ret_val);
				break;
			case BANWORD:
				usersolution.banWord(mWord);
				break;
			default:
				ret_val = false;
				break;
			}
		}

		return ret_val;
	}

	public static void main(String[] args) throws Exception {
		int T, MARK;
		// System.setIn(new java.io.FileInputStream("res/sample_input.txt"));
		br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer stinit = new StringTokenizer(br.readLine(), " ");
		T = Integer.parseInt(stinit.nextToken());
		MARK = Integer.parseInt(stinit.nextToken());

		for (int tc = 1; tc <= T; tc++) {
			int score = run() ? MARK : 0;
			System.out.println("#" + tc + " " + score);
		}

		br.close();
	}
}