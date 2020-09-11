import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Baek5014 {
	public static boolean[] visited;
	public static int F;
	public static int S;
	public static int G;
	public static int U;
	public static int D;
	public static Queue<Integer> queue = new LinkedList<>();
	
	public static void main(String[] args)throws Exception {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		F =Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G =Integer.parseInt(st.nextToken());
		U =Integer.parseInt(st.nextToken());
		D =Integer.parseInt(st.nextToken());
		int cnt=0;
		visited = new boolean[F+1];
		queue.offer(S);
		visited[S]=true;
		int answer=-1;
		while(!queue.isEmpty()) {
			int pre = queue.poll();
			if(pre==G) {
				answer=cnt;
			}
			if(isPossible(pre+U)&&pre+U<=G&&!visited[pre+U]) {
				visited[pre+U]=true;
				queue.offer(pre+U);
				cnt++;
			}else if(isPossible(pre-D)&&pre+U>G&&!visited[pre-D]) {
				queue.offer(pre-D);
				visited[pre-D]=true;
				cnt++;
			}
		}
		if(answer==-1)
			System.out.println("use the stairs");
		else
			System.out.println(answer);
	}
	public static boolean isPossible(int x) {
		if(x>F||x<1)
			return false;
		return true;
	}
	
}
