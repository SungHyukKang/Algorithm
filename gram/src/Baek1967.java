import java.util.*;
import java.io.*;

class Node1967 {
	int i, d;

	Node1967(int i, int d) {
		this.i = i;
		this.d = d;
	}
}

public class Baek1967 {
	static int N;
	static boolean[] visited;
	static int[] D;
	static ArrayList<ArrayList<Node1967>> list = new ArrayList<>();
	public static int stoi(String X) {
		return Integer.parseInt(X);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = stoi(br.readLine());
		if (N == 1) {
			System.out.println("0");
			return;
		}
		visited = new boolean[N + 1];
		D = new int[N + 1];

		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
			D[i] = 21000000;
		}
		for (int i = 0; i < N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = stoi(st.nextToken());
			int e = stoi(st.nextToken());
			int d = stoi(st.nextToken());
			list.get(s).add(new Node1967(e, d));
			list.get(e).add(new Node1967(s, d));
		}
		dfs(1,0);
		D[1]=0;
		
		int restart=0;
		int dis=0;
		for(int  i=1;i<D.length;i++) {
			if(dis<D[i]) {
				dis=D[i];
				restart=i;
			}
			D[i]=21000000;
		}
		visited=new boolean[N+1];
		dfs(restart,0);
		D[0]=-1;
		D[restart]=-1;
		Arrays.sort(D);
		System.out.println(D[D.length-1]);
	}

	static void dfs(int start, int sum) {
		for (Node1967 n : list.get(start)) {
			if (!visited[n.i]) {
				visited[n.i] = true;
				sum += n.d;
				if(D[n.i]>sum)
					D[n.i] = sum;
				dfs(n.i, sum);
				sum-=n.d;
				visited[n.i]=false;
			}
		}
	}

}
