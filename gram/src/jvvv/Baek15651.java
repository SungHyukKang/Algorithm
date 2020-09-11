package jvvv;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.Stack;

public class Baek15651 {
//백준 N과 M (3)  , 백트래킹
	public static int N;
	public static int M;
	public static Stack<Integer> arr;
	public static boolean[] visited;
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void dfs()throws IOException {
		if(arr.size()==M) {
			for(int i =0;i<arr.size();i++) {
				int num= arr.get(i);
				bw.write(String.valueOf(num)+" ");
			}
			bw.write("\n");
			bw.flush();
			return;
		}
		for(int i =1;i<=N;i++) {
			if(!visited[i]) {
				arr.push(i);
				dfs();
				visited[i]=true;
				arr.pop();
				visited[i]=false;
			}
		}
	}
	public static void main(String[] args)throws IOException {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		if(M==1) {
			for(int i =1;i<=N;i++) {
				System.out.println(i);
			}
			return;
		}
		arr = new Stack<>();
		visited=new boolean[N+1];
		dfs();
		bw.close();
	}
}
