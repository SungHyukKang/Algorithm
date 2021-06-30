import java.util.*;
import java.io.*;

public class Baek17478 {
	static int N;
	static StringBuilder sb = new StringBuilder();
	static ArrayList<String> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
		String X = "\"재귀함수가 뭔가요?\"\n" + "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n"
				+ "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n"
				+ "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"";
		for (int i = 0; i < 4; i++) {
			list.add(X.split("\n")[i]);
		}
		dfs(0, "");
		System.out.println(sb);
	}

	public static void dfs(int depth, String hyphen) {
		if (depth == N) {
			sb.append(hyphen + "\"재귀함수가 뭔가요?\"\n");
			sb.append(hyphen + "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
			sb.append(hyphen + "라고 답변하였지.\n");
			return;
		}
		for (int i = 0; i < 4; i++) {
			sb.append(hyphen + list.get(i) + "\n");
		}
		dfs(depth + 1, hyphen + "____");
		sb.append(hyphen + "라고 답변하였지.\n");
	}
}
