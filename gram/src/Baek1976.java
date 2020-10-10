import java.util.*;
import java.io.*;
public class Baek1976 {
	static int[] parent ;
	
	public static int find(int s) {
		if(parent[s]==s)
			return s;
		parent[s]=find(parent[s]);
		return parent[s];
	}
	public static void union(int a, int b) {
		int aRoot=find(a);
		int bRoot=find(b);
		if(aRoot!=bRoot)
			parent[aRoot]=b;
		else
			return;
	}
	public static int stoi(String X) {return Integer.parseInt(X);}
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = stoi(br.readLine());
		int M = stoi(br.readLine());
		int[][] arr =new int[N+1][N+1];
		StringTokenizer st;
		parent=new int[N+1];
		for(int i =1;i<=N;i++)
			parent[i]=i;
		for(int i =1;i<=N;i++) {
			st=  new StringTokenizer(br.readLine());
			for(int j =1;j<=N;j++) {
				int x = stoi(st.nextToken());
				if(x==1) {
					union(i,j);
				}
			}
		}
		st=new StringTokenizer(br.readLine());
		int z =0;
		for(int i =0;i<M;i++) {
			int x =stoi(st.nextToken());
			if(z==0)
				z=find(x);
			else {
				if(z!=find(x)) {
					System.out.println("NO");
					return;
				}
			}
		}
		System.out.println("YES");
	}
}
