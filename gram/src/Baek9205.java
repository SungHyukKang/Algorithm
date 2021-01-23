import java.io.*;
import java.util.*;

class Pair9205 {
	int x, y;

	Pair9205(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Baek9205 {
	static ArrayList<Pair9205> list;
	static ArrayList<ArrayList<Integer>> map;
	static Queue<Integer> q ;
	static boolean visited[];
	static int destination;
	static boolean tf;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			destination = n+1;
			visited=new boolean[n+2];
			list = new ArrayList<>();
			map = new ArrayList<>();
			q=new LinkedList<>();
			tf=false;
			for (int i = 0; i < n + 2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				list.add(new Pair9205(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
				map.add(new ArrayList<>());
			}
			for (int i = 0; i < list.size(); i++) {
				for (int j = i + 1; j < list.size(); j++) {
					if (Math.abs(list.get(i).x - list.get(j).x) + Math.abs(list.get(i).y - list.get(j).y) <= 1000) {
						map.get(i).add(j);
						map.get(j).add(i);
					}
				}
			}
			visited[0]=true;
			q.offer(0);
			bfs();
			System.out.println(tf ? "happy":"sad");
		}
	}

	public static void bfs() {
		while(!q.isEmpty()) {
			int x =q.poll();
			if(x==destination) {
				tf=true;
				break;
			}
			for(int c  : map.get(x)) {
				if(!visited[c]) {
					visited[c]=true;
					q.offer(c);
				}
			}
		}
	}
}
