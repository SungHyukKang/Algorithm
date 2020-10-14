import java.util.*;
import java.io.*;
public class Baek2668 {
	static int N;
	static int[] arr;
	static boolean[] visited;
	static HashSet<Integer> hsset = new HashSet<>();
	static int s;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		arr=new int[N+1];
		visited = new boolean[N+1];
		ArrayList<Integer> list = new ArrayList<>();
		for(int i =1;i<=N;i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		for(int i=1;i<=N;i++) {
			s=i;
			visited =new boolean[N+1];
			dfs(arr[i]);
		}
		for(int X : hsset) {
			list.add(X);
		}
		Collections.sort(list);
		System.out.println(list.size());
		for(int X :list)
			System.out.println(X);
	}
	public static void dfs(int start) {
		if(start==s) {
			visited[start]=true;
			for(int i =1;i<=N;i++) {
				if(visited[i])
					hsset.add(i);
			}
			return;
		}
		if(!visited[arr[start]]) {
			visited[start]=true;
			dfs(arr[start]);
		}
		
		
	}
}
