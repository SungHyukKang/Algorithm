import java.util.*;
import java.io.*;
public class Baek10451 {
	public static boolean[] visited;
	public static int[] arr;
	static int cnt;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			int N = Integer.parseInt(br.readLine());
			arr=new int[N+1];
			visited=new boolean[N+1];
			cnt=0;
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int i =1 ;i <=N;i++)
				arr[i]=Integer.parseInt(st.nextToken());
			for(int i =1;i<=N;i++)
				if(!visited[i])
				dfs(i);
			bw.write(cnt+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
		
	}

	public static void dfs(int start) {
		if(visited[start]) {
			cnt++;
			return;
		}
		visited[start]=true;
		dfs(arr[start]);
	}
}
