import java.util.*;
import java.io.*;

class Triple12886 {
	int x;
	int y;
	int z;

	public Triple12886(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

}

public class Baek12886 {
	static boolean[][] visited = new boolean[1501][1501];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Queue<Triple12886> q = new LinkedList<>();
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		if ((A + B + C) % 3 != 0) {
			System.out.println("0");
			return;
		}
		q.offer(new Triple12886(A, B, C));
		while (!q.isEmpty()) {
			Triple12886 t = q.poll();
			int x = t.x;
			int y = t.y;
			int z = t.z;
			int[] arr = new int[3];
			arr[0] = x;
			arr[1] = y;
			arr[2] = z;
			Arrays.sort(arr);
			if (x == y && y == z) {
				System.out.println("1");
				System.exit(0);
			}
			if (x == 0 || y == 0 || z == 0)
				continue;
			if (arr[1] - arr[0] > 0 && !visited[arr[0] * 2][arr[1] - arr[0]]) {
				q.offer(new Triple12886(arr[0] * 2, arr[1] - arr[0], arr[2]));
				visited[arr[0] * 2][arr[1] - arr[0]] = true;
			}
			if (arr[2] - arr[0] > 0 && !visited[arr[0] * 2][arr[2] - arr[0]]) {
				q.offer(new Triple12886(arr[0] * 2, arr[1], arr[2] - arr[0]));
				visited[arr[0] * 2][arr[2] - arr[0]] = true;
			}
			if (arr[2] - arr[1] > 0 && !visited[arr[1] * 2][arr[2] - arr[1]]) {
				q.offer(new Triple12886(arr[0], arr[1] * 2, arr[2] - arr[1]));
				visited[arr[1] * 2][arr[2] - arr[1]] = true;
			}
		}
		System.out.println("0");
	}

}
