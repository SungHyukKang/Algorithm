package jvvv;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class Baek15657 {
	public static int N;
	public static int M;
	public static Stack<Integer> arr;
	public static boolean[] visited= new boolean[10001];
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static ArrayList<Integer> list;
	public static void dfs()throws IOException {
		if(arr.size()==M+1) {
			for(int i =1;i<=M;i++) {
				int num = arr.get(i);
				bw.write(String.valueOf(num)+" ");
			}
			bw.write("\n");
			bw.flush();
			return;
		}
		for(int i =0;i<list.size();i++) {
			if(!visited[list.get(i)]&&arr.lastElement()<=list.get(i)) {
				arr.push(list.get(i));
				dfs();
				visited[list.get(i)]=true;
				arr.pop();
				visited[list.get(i)]=false;
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
		arr.add(-1);
		dfs();
		bw.close();
	}
}
