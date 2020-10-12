import java.util.*;
import java.io.*;
public class Baek13023 {
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	static int[][] arr ;
	static boolean[] visited;
	static int N;
	static int M;
	static int ans=0;
	public static int stoi(String x) {return Integer.parseInt(x);}
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=stoi(st.nextToken());
		M=stoi(st.nextToken());
		visited=new boolean[N];
		arr=new int[N][N];
		for(int i =0;i<N;i++) {
			list.add(new ArrayList<>());
		}
		for(int i =0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int num1 =stoi(st.nextToken());
			int num2 =stoi(st.nextToken());
			list.get(num1).add(num2);
			list.get(num2).add(num1);
		}
		for(int i =0;i<N;i++) {
			visited=new boolean[N];
			visited[i]=true;
			dfs(i,0);
			if(ans==1) {
				break;
			}
		}
		System.out.println(ans);
	}
	static void dfs(int start,int cnt) {
		if(cnt==4) {
			ans=1;
			return;
		}
		for(int x : list.get(start)) {
			if(!visited[x]) {
				visited[x]=true;
				dfs(x,cnt+1);
				visited[x]=false;
			}
		}
	}

}
