import java.util.*;
import java.io.*;
public class Baek2529 {
	static int N;
	static char[] arr;
	static Stack<Integer> stack = new Stack<>();
	static ArrayList<String> list = new ArrayList<>();
	static boolean[] visited;
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		arr =new char[N]; 
		visited=new boolean[10];
		String X = br.readLine().replace(" ", "");
		for(int i =0;i<X.length();i++) {
			arr[i]=X.charAt(i);
		}
		dfs();
		System.out.println(list.get(list.size()-1));
		System.out.println(list.get(0));
	}
	public static void dfs() {
		StringBuilder sb = new StringBuilder();
		if(stack.size()==N+1) {
			for(int i =0;i<stack.size()-1;i++) {
				if(arr[i]=='<') {
					if(stack.get(i)<stack.get(i+1)) {
						sb.append(stack.get(i));
					}else
						return;
				}else{
					if(stack.get(i)>stack.get(i+1)) {
						sb.append(stack.get(i));
					}else
						return;
				}
			}
			sb.append(stack.lastElement());
			list.add(sb.toString());
			return;
		}
		for(int i =0;i<10;i++) {
			if(!visited[i]) {
				visited[i]=true;
				stack.push(i);
				dfs();
				stack.pop();
				visited[i]=false;
			}
		}
	}
}
