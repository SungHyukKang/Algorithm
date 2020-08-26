package jvvv;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
public class Baek6603 {
	public static int[] arr ;
	public static boolean[] visited ;
	public static int N;
	public static Stack<Integer> stack = new Stack<>();
	public static void dfs() {
		if(stack.size()==7) {
			for(int i =1;i<stack.size();i++) {
				System.out.print(stack.get(i)+" ");
			}
			System.out.println();
			return;
		}
		for(int i =1;i<=N;i++) {
			if(!visited[i]&&stack.lastElement()<arr[i]) {
				visited[i]=true;
				stack.push(arr[i]);
				dfs();
				stack.pop();
				visited[i]=false;
			}
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			stack = new Stack<>();
			if(N==0)
				return;
			arr=new int[N+1];
			visited=new boolean[N+1];
			for(int i =1;i<=N;i++) {
				arr[i]=Integer.parseInt(st.nextToken());
			}
			stack.push(-1);
			dfs();
			System.out.println();
		}
	}

}
