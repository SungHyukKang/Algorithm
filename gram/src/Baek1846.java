import java.util.*;
import java.io.*;
public class Baek1846 {
	public static int N;
	static Stack<Integer> stack =new Stack<>();
	static boolean[][] visited;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int stoi(String X) {return Integer.parseInt(X);}
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N=stoi(br.readLine());
		visited=new boolean[N+1][N+1];
		int[] arr =new int[N+1];
		dfs(arr,1);
		System.out.println("-1");
	}
	static void dfs(int[] arr,int row)throws IOException {
		print(arr);
		if(stack.size()==N) {
			for(int x : stack) {
				bw.write(x+"\n");
			}
			bw.close();
			System.exit(0);
		}else {
			for(int i=1;i<=N;i++) {
				arr[row]=i;
				if(isPossible(arr,row)&&!visited[row][arr[row]]) {
					visited[row][arr[row]]=true;
					stack.push(arr[row]);
					dfs(arr,row+1);
					stack.pop();
					visited[row][arr[row]]=false;
				}
			}
		}
	}
	static boolean isPossible(int[] arr,int row) {
		if(arr[row]==row||(arr[row]+row==N+1))
			return false;
		for(int i =1;i<=N;i++) {
			if(row==i)
				continue;
			if(arr[row]==arr[i])
				return false;
		}
		return true;
	}
	static void print(int[] arr) {
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				if(j==arr[i]) {
					System.out.print("1 ");
				}else
					System.out.print("0 ");
			}
			System.out.println();
		}
		System.out.println("-----------------");
	}
}
