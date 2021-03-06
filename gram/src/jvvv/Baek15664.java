package jvvv;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Stack;

public class Baek15664 {
	public static int N;
	public static int M;
	public static Stack<Integer> arr;
	public static boolean[] visited= new boolean[10001];
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static ArrayList<Integer> list;
	public static LinkedHashSet<String> lhsset = new LinkedHashSet<String>();
	public static StringBuilder sb= new StringBuilder();
	public static void dfs(int start)throws IOException {
		if(arr.size()==M) {
			for(int i =0;i<M;i++) {
				int num = arr.get(i);
				sb.append(num+" ");
			}
			lhsset.add(sb.toString());
			sb=new StringBuilder();
			return;
		}
		for(int i =start;i<list.size();i++) {
			if(!visited[i]) {
				visited[i]=true;
				arr.push(list.get(i));
				dfs(i);
				arr.pop();
				visited[i]=false;
			}	
		}
	}
	public static void main(String[] args)throws IOException {
		Scanner sc = new Scanner(System.in);
		list = new ArrayList<>();
		N = sc.nextInt();
		M = sc.nextInt();
		for(int i =0;i<N;i++) {
			list.add(sc.nextInt());
		}
		Collections.sort(list);
		arr = new Stack<>();
		for(int i =0;i<list.size();i++)
			dfs(i);
		for(String Z : lhsset) {
			bw.write(Z+"\n");
		}
		bw.flush();
		bw.close();
		
	}
}
