package jvvv;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class Baek15654 {
	public static int N;
	public static int M;
	public static Stack<Integer> arr;
	public static boolean[] visited= new boolean[10001];
	public static ArrayList<Integer> list;
	public static void dfs() {
		
		if(arr.size()==M) {
			for(int i =0;i<M;i++) {
				System.out.print(arr.get(i)+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i =0;i<list.size();i++) {
			if(!visited[list.get(i)]) {
				visited[list.get(i)]=true;
				arr.push(list.get(i));
				dfs();
				arr.pop();
				visited[list.get(i)]=false;
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		list = new ArrayList<>();
		N = sc.nextInt();
		M = sc.nextInt();
		for(int i =0;i<N;i++) {
			list.add(sc.nextInt());
		}
		Collections.sort(list);
			arr = new Stack<>();
			dfs();
	}
}
