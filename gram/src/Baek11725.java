import java.util.*;
import java.io.*;
public class Baek11725 {
	static int N ;
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	static int[] arr;
	static int cnt=0;
	static boolean[] visited;
	public static int stoi(String X) {return Integer.parseInt(X);}
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=stoi(br.readLine());
		arr=new int[N+1];
		visited =new boolean[N+1];
		for(int i =0;i<=N;i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i =0;i<N-1;i++) {
			StringTokenizer st =new StringTokenizer(br.readLine());
			int v1 = stoi(st.nextToken());
			int v2 = stoi(st.nextToken());
			list.get(v1).add(v2);
			list.get(v2).add(v1);
		}
		visited[1]=true;
		dfs(1);
		for(int i=2;i<=N;i++) {
			System.out.println(arr[i]);
		}
		
	}

	public static void dfs(int start) {
		if(cnt==N) {
			return;
		}
		for(int X : list.get(start)) {
			if(!visited[X]) {
				visited[X]=true;
				arr[X]=start;
				cnt++;
				dfs(X);
			}
		}
	}
	
}
