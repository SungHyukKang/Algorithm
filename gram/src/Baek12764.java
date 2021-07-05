import java.util.*;
import java.io.*;

class Node12765 implements Comparable<Node12765> {
	int end;
	int index;

	public Node12765(int end, int index) {
		this.end = end;
		this.index = index;
	}

	@Override
	public int compareTo(Node12765 o) {
		return this.end <= o.end ? -1 : 1;
	}

	@Override
	public String toString() {
		return "Node12765 [end=" + end + ", index=" + index + "]";
	}

}

public class Baek12764 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashMap<Integer, Integer> info = new HashMap<>();
		ArrayList<Integer> start = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			start.add(s);
			info.put(s, e);
		}
		Collections.sort(start);
		PriorityQueue<Node12765> end = new PriorityQueue<>();
		int[] arr = new int[100001];
		int[] timeSet = new int[100001];
		Arrays.fill(arr, 0);
		int cnt = 0;
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for (int i = 0; i < 100001; i++)
			queue.offer(i);
		int m = 0;
		for (int i = 0; i < start.size(); i++) {
			int x = start.get(i);
			while (!end.isEmpty() && end.peek().end < x) {
				int id = end.poll().index;
				queue.offer(id);
			}
			int id = queue.poll();
			end.offer(new Node12765(info.get(x), id));
			arr[id]++;
			m = Math.max(m, end.size());
		}
		System.out.println(m);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			sb.append(arr[i] + " ");
		}
		System.out.println(sb);
	}

}
