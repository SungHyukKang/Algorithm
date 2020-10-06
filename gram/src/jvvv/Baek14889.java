package jvvv;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;


public class Baek14889 {
	public static int N;
	public static boolean[] visited;
	public static Stack<Integer> stack = new Stack<>();
	public static int[][] arr;
	public static int max=9999999;
	public static void dfs() {
		if(stack.size()-1==N/2) {
			int sum=0;
			int sum2=0;
			int ans=0;
			for(int i =1;i<stack.size();i++) {
				for(int j=1;j<stack.size();j++) {
					if(stack.get(i)==stack.get(j))
						continue;
					sum+=arr[stack.get(i)][stack.get(j)];
				}
			}
			for(int i =1;i<=N;i++) {
				if(!visited[i]) {
					for(int j=1;j<=N;j++) {
						if(i==j)
							continue;
						if(!visited[j]) {
							sum2+=arr[i][j];
						}
					}
				}
			}
			ans = Math.abs(sum-sum2);
			if(ans<max) {
				max=ans;
			}
			return;
		}
		for(int i =1;i<=N;i++) {
			if(!visited[i]&&stack.lastElement()<i) {
				visited[i]=true;
				stack.push(i);
				dfs();
				stack.pop();
				visited[i]=false;
			}
		}
		
	}
	public static int stoi(String X) {return Integer.parseInt(X);}
	public static void main(String[] args)throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		N=stoi(br.readLine());
		arr =new int[N+1][N+1];
		visited=new boolean[N+1];
		stack.add(-1);
		for(int i = 1;i<=N;i++){
			StringTokenizer st=  new StringTokenizer(br.readLine());
			for(int j =1;j<=N;j++){
				arr[i][j]=stoi(st.nextToken());
			}
		}
		dfs();
		System.out.println(max);
	}
}
