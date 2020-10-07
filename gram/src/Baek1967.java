import java.util.*;
import java.io.*;

class Node1967{
	int i,d;
	
	Node1967(int i,int d){
		this.i=i;
		this.d=d;
	}
}

public class Baek1967 {
	static int N;
	static int sofar=0;
	static int pre;
	static int max=0;
	static boolean[] visited;
	static ArrayList<ArrayList<Node1967>> list = new ArrayList<>();
	static ArrayList<ArrayList<Node1967>> ijc = new ArrayList<>();
	public static int stoi(String X) {return Integer.parseInt(X);}
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=stoi(br.readLine());
		if(N==1) {
			System.out.println("0");
			return;
		}
		visited=new boolean[N+1];
		for(int i =0;i<=N;i++) {
			list.add(new ArrayList<>());
			ijc.add(new ArrayList<>());
		}
		for(int i =0;i<N-1;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num =stoi(st.nextToken());
			int num2 =stoi(st.nextToken());
			int num3 =stoi(st.nextToken());
			list.get(num).add(new Node1967(num2,num3));
			ijc.get(num2).add(new Node1967(num,num3));
			ijc.get(num).add(new Node1967(num2,num3));
		}
		
		ArrayList<Integer> child = new ArrayList<>();
		for(int i =1;i<list.size();i++) {
			if(list.get(i).size()==0) {
				child.add(i);
			}
		}
		if(child.size()==1) {
			dfs2(1,0);
			System.out.println(max);
			return;
		}
		visited[1]=true;
		dfs(1,0);
		max=0;
		visited=new boolean[N+1];
		dfs(sofar,0);
		System.out.println(max);
	}
	public static void dfs2(int start,int sum) {
			if(sum>max) {
				max=sum;
			}
		for(Node1967 n : list.get(start)) {
			if(!visited[n.i]) {
				visited[n.i]=true;
				sum+=n.d;
				dfs2(n.i,sum);
			}
		}
		
	}
	
	public static void dfs(int start,int sum) {
		if(max<sum) {
			max=sum;
			sofar=start;
		}
		for(Node1967 n : ijc.get(start)) {
			if(!visited[n.i]) {
				visited[n.i]=true;
				dfs(n.i,sum+n.d);
			}
		}
	}
}
