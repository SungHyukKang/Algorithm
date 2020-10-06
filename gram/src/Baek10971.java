import java.util.*;
import java.io.*;
public class Baek10971 {
	static int N;
	static int[][] arr;
	static int pre;
	static boolean[] visited;
	static int min=210000000;
	public static int stoi(String X) {return Integer.parseInt(X);}
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=stoi(br.readLine());
		arr=new int[N][N];
		visited=new boolean[N];
		for(int i =0;i<N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				arr[i][j]=stoi(st.nextToken());
			}
		}
		for(int i =0;i<N;i++) {
			pre=i;
			int cnt=0;
			int sum=0;
			dfs(sum,i,cnt);
		}
		System.out.println(min);
	}
	
	public static void dfs(int sum,int start,int cnt) {
		if(cnt==N) {
			if(pre==start) {
				if(min>sum)
					min=sum;
			}
				
			return;
		}
		for(int i =0;i<N;i++) {
			if(!visited[i]) {
				if(arr[start][i]==0)
					continue;
				visited[i]=true;
				sum+=arr[start][i];
				cnt++;
				dfs(sum,i,cnt);
				cnt--;
				sum=sum-arr[start][i];
				visited[i]=false;
			}
		}
	}
}
