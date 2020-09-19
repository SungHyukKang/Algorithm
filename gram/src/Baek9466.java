import java.util.*;
import java.io.*;
public class Baek9466 {
	static int[] arr;
	static int N;
	static boolean[] visited ;
	static boolean[] visited2 ;
	static int S;
	static int cnt;
	static HashSet<Integer> hsset ;
	static Stack<Integer> stack = new Stack<>();
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			N=Integer.parseInt(br.readLine());
			arr=new int[N+1];
			cnt =0;
			visited=new boolean[N+1];
			visited2=new boolean[N+1];
			st = new StringTokenizer(br.readLine());
			for(int i =1;i<=N;i++) {
				arr[i]=Integer.parseInt(st.nextToken());
			}
			for(int i =1;i<=N;i++) {
					dfs(i);
			}
			System.out.println(N-cnt);
		}
	}
	
	public static void dfs(int start) {
		if(visited[start]) {
			return;
		}
		visited[start]=true;
		int next = arr[start];
		
		if(!visited[next]) {
			dfs(next);
		}else {
			if(!visited2[next]) {
				cnt++;
				for(int i =next;i!=start;i=arr[i]) {
					cnt++;
				}
			}
		}

		visited2[start]=true;
		
	}
}
