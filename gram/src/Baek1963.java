import java.util.*;
import java.io.*;

class Pair1963 {
	int cnt;
	int num;

	public Pair1963(int cnt, int num) {
		this.cnt = cnt;
		this.num = num;
	}

}

public class Baek1963 {
	static Queue<Pair1963> q;
	static boolean[] visited;
	static boolean[] sosu;
	static int target;
	static boolean tf;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		sosu = new boolean[10000];
		visited = new boolean[10000];
		sosu[0] = true;
		sosu[1] = true;
		for (int i = 2; i <= Math.sqrt(9999); i++) {
			if (sosu[i])
				continue;
			for (int j = i * i; j <= 9999; j = j + i) {
				sosu[j] = true;
			}
		}
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			q = new LinkedList<>();
			visited = new boolean[10000];
			int start = Integer.parseInt(st.nextToken());
			q.offer(new Pair1963(0, start));
			visited[start] = true;
			target = Integer.parseInt(st.nextToken());
			bfs();
		}
		bw.flush();
		bw.close();
		br.close();
	}

	public static void bfs() throws IOException {
		tf = false;
		while (!q.isEmpty()) {
			Pair1963 p = q.poll();
			int cnt = p.cnt;
			int num = p.num;
			String strNum = String.valueOf(num);
			if (num == target) {
				bw.write(cnt + "\n");
				tf = true;
				break;
			}

			for (int i = 1; i <= 9; i++) {
				if (strNum.charAt(0) != i - '0') {
					int Z = Integer.parseInt(String.valueOf(i) + strNum.substring(1));
					if (!sosu[Z] && !visited[Z]) {
						q.offer(new Pair1963(cnt + 1, Z));
						visited[Z] = true;
					}
				}
			}
			for (int i = 0; i <= 9; i++) {
				if (i == 0 && strNum.charAt(0) == '0')
					continue;
				if (strNum.charAt(1) != i - '0') {
					int Z = Integer.parseInt(strNum.substring(0, 1) + String.valueOf(i) + strNum.substring(2));
					if (!sosu[Z] && !visited[Z]) {
						q.offer(new Pair1963(cnt + 1, Z));
						visited[Z] = true;
					}
				}
			}
			for (int i = 0; i <= 9; i++) {
				if (i == 0 && strNum.charAt(0) == '0')
					continue;
				if (strNum.charAt(2) != i - '0') {
					int Z = Integer.parseInt(strNum.substring(0, 2) + String.valueOf(i) + strNum.substring(3));
					if (!sosu[Z] && !visited[Z]) {
						q.offer(new Pair1963(cnt + 1, Z));
						visited[Z] = true;
					}
				}
			}
			for (int i = 0; i <= 9; i++) {
				if (i == 0 && strNum.charAt(0) == '0')
					continue;
				if (strNum.charAt(3) != i - '0') {
					int Z = Integer.parseInt(strNum.substring(0, 3) + String.valueOf(i));
					if (!sosu[Z] && !visited[Z]) {
						q.offer(new Pair1963(cnt + 1, Z));
						visited[Z] = true;
					}
				}
			}

		}
		if (!tf)
			bw.write("Impossible\n");
	}

}
