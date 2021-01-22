import java.util.*;

class Pair12978p implements Comparable<Pair12978p>{
	int index;
	int d;
	public Pair12978p(int index, int d) {
		this.index = index;
		this.d = d;
	}
	@Override
	public int compareTo(Pair12978p arg0) {
		return this.d<=arg0.d?-1:1;
	}
	
}
public class 배달 {
	static final int INF = 99999999;
	static int[] D ;
	static ArrayList<ArrayList<Pair12978p>> list = new ArrayList<>();
	static PriorityQueue<Pair12978p> pq  = new PriorityQueue<>();
	
	public static int solution(int N, int[][] road, int K) {
        int answer = 0;
        D=new int[N+1];
        for(int i =0;i<=N;i++)
        	list.add(new ArrayList<Pair12978p>());
        for(int[] path : road) {
        	list.get(path[0]).add(new Pair12978p(path[1],path[2]));
        	list.get(path[1]).add(new Pair12978p(path[0],path[2]));
        }
        for(int i=1;i<=N;i++) {
        	D[i]=INF;
        }
        dijkstra(1);
        for(int i=1;i<=N;i++)
        	if(D[i]<=K)
        		answer++;
        return answer;
    }
	public static void dijkstra(int start) {
		pq.offer(new Pair12978p(1,0));
		D[start]=0;
		while(!pq.isEmpty()) {
			Pair12978p p = pq.poll();
			int idx = p.index;
			int d = p.d;
			if(d>D[idx]) {
				continue;
			}
			for(Pair12978p node : list.get(idx)) {
				if(D[node.index]>node.d+D[idx]) {
					D[node.index]=node.d+D[idx];
					pq.offer(new Pair12978p(node.index,D[node.index]));
				}
			}
			
		}
	}
	public static void main(String[] args) {
		solution(5,new int[][]{{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}},3);
	}

}
