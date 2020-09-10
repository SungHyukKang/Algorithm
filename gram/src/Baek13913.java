import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.io.*;
class Tele2{
	int pre;
	int cnt=0;
	StringBuilder arr;
	Tele2(int pre , int cnt,StringBuilder arr){
		this.pre = pre;
		this.cnt =cnt;
		this.arr=arr;
	}
	
}

public class Baek13913 {
	static int N ;
	static int K;
	static int ans;
	static boolean[] visited= new boolean[100001];
	static Stack<Integer> stack = new Stack<>();
	static Queue<Tele2> q = new LinkedList<Tele2>();
	static StringBuilder sb = new StringBuilder();
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args)throws IOException {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		if(K<N) {
			System.out.println(N-K);
			for(int i=N;i>=K;i--) {
				System.out.print(i+" ");
			}
			return;
		}
		stack.add(N);
		sb.append(N+" ");
		q.offer(new Tele2(N,0,sb));
		visited[N]=true;
		bfs();
		bw.flush();
		bw.close();
	}
	
	public static void bfs()throws IOException {
		while(!q.isEmpty()) {
			Tele2 Tele2 =q.poll();
			int pre =Tele2.pre;
			int cnt = Tele2.cnt;
			StringBuilder sb = new StringBuilder(Tele2.arr.toString());
			if(pre==K) {
				ans=cnt;
				System.out.println(ans);
				bw.write(sb.toString());
				break;
			}
			if(isPossible(pre*2)&&!visited[pre*2]&&pre<K) {
				sb.append(pre*2+" ");
				q.offer(new Tele2(pre*2,cnt+1,sb));
				visited[pre*2]=true;
				sb=new StringBuilder(Tele2.arr.toString());
			}
			if(isPossible(pre+1)&&!visited[pre+1]&&pre<K) {
				sb.append(pre+1+" ");
				q.offer(new Tele2(pre+1,cnt+1,sb));
				visited[pre+1]=true;
				sb=new StringBuilder(Tele2.arr.toString());
			}
			if(isPossible(pre-1)&&!visited[pre-1]) {
				sb.append(pre-1+" ");
				q.offer(new Tele2(pre-1,cnt+1,sb));
				visited[pre-1]=true;
				sb=new StringBuilder(Tele2.arr.toString());
			}
		}
	}
	public static boolean isPossible(int N ) {
		if(N<0||N>=100001) {
			return false;
		}
		return true;
	}
}
