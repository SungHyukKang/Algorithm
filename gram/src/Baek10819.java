import java.util.*;
import java.io.*;
public class Baek10819 {
	static int N;
	static int[] arr;
	static boolean[] visited;
	static Stack<Integer> stack = new Stack<>();
	static int max=0;
	public static int stoi (String X) {return Integer.parseInt(X);}
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=stoi(br.readLine());
		visited = new boolean[N];
		arr=new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i =0;i<N;i++) {
			arr[i]=stoi(st.nextToken());
		}
		dfs();
		System.out.println(max);
	}
	public static void dfs() {
		if(stack.size()==N) {
			int sum=0;
			for(int i =0;i<N-1;i++) {
				sum+=Math.abs(arr[stack.get(i)]-arr[stack.get(i+1)]);
			}
			if(max<sum)
				max=sum;
			return;
		}
		for(int i=0;i<N;i++) {
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
