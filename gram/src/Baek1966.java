import java.util.*;
import java.io.*;
public class Baek1966 {
	static class Pair1966{
		int idx;
		int pri;
		public Pair1966(int idx, int pri) {
			this.idx = idx;
			this.pri = pri;
		}
	}
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			Queue<Pair1966> q = new LinkedList<>();
			PriorityQueue<Integer> pr = new PriorityQueue<>(Collections.reverseOrder());
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				int pri = Integer.parseInt(st.nextToken());
				q.offer(new Pair1966(i,pri));
				pr.offer(pri);
			}
			int cnt=0;
			while(!q.isEmpty()) {
				Pair1966 p = q.poll();
				int priority=pr.peek();
				if(priority==p.pri) {
					cnt++;
					if(p.idx==M) {
						System.out.println(cnt);
						break;
					}
					pr.poll();
				}else {
					q.offer(p);
				}
			}
		}
	}

}
