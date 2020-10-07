import java.util.*;
import java.io.*;
public class Baek1068 {
	static int N;
	static boolean[] visited;
	static int[] arr;
	static int cnt=0;
	static int rem;
	static int start;
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	static int stoi(String X) {return Integer.parseInt(X);}
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=stoi(br.readLine());
		visited = new boolean[N];
		start =0;
		arr=new int[N];
		for(int i =0;i<N;i++){
			list.add(new ArrayList<>());
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i =0;i<N;i++) {
			int num = stoi(st.nextToken());
			if(num==-1) {
				start=i;
				continue;
			}
			list.get(num).add(i);
		}
		
		rem =stoi(br.readLine());
		if(rem==start) {
			System.out.println("0");
			return;
		}
		for(int i =0;i<N;i++) {
			for(int j =0;j<list.get(i).size();j++) {
				if(list.get(i).get(j)==rem) {
					list.get(i).remove(j);
					break;
				}
			}
		}
		list.get(rem).clear();
		visited[start]=true;
		visited[rem]=true;
		dfs(start);
		System.out.println(cnt);
	}
	static void dfs(int s) {
		if(list.get(s).size()==0) {
			cnt++;
			return;
		}
		for(int x : list.get(s)) {
			if(!visited[x]) {
				visited[x]=true;
				dfs(x);
			}
		}
	}
}
