import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//class Tele{
//	int pre;
//	int cnt=0;
//	
//	Tele(int pre , int cnt){
//		this.pre = pre;
//		this.cnt =cnt;
//	}
//}

public class Baek13549 {
	static int N ;
	static int K;
	static int ans;
	static boolean[] visited= new boolean[100001];
	static Queue<Tele> q = new LinkedList<Tele>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		q.offer(new Tele(N,0));
		visited[N]=true;
		bfs();
		System.out.println(ans);
		
	}
	
	public static void bfs() {
		while(!q.isEmpty()) {
			Tele tele =q.poll();
			int pre =tele.pre;
			int cnt = tele.cnt;
			visited[pre]=true;
			if(pre==K) {
				ans=cnt;
				break;
			}
			if(isPossible(pre*2)&&!visited[pre*2]) {
				q.offer(new Tele(pre*2,cnt));
			}
			if(isPossible(pre-1)&&!visited[pre-1]) {
				q.offer(new Tele(pre-1,cnt+1));
			}
			if(isPossible(pre+1)&&!visited[pre+1]) {
				q.offer(new Tele(pre+1,cnt+1));
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
