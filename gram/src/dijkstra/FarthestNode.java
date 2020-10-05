package dijkstra;

import java.util.*;

class NodeFN implements Comparable<NodeFN>{
	int index;
	int dist;
	
	NodeFN(int i ,int d){
		this.index=i;
		this.dist=d;
	}

	@Override
	public int compareTo(NodeFN arg0) {
		return this.dist<=arg0.dist ? -1 : 1;
	}
	
	
}

public class FarthestNode {
	static final int INF = 100000;
	static ArrayList<ArrayList<NodeFN>> arr = new ArrayList<>();
	static int[] D;
	public static int solution(int n, int[][] edge) {
        int answer = 0;
        D=new int[n+1];
        for(int i =0;i<=n;i++) {
        	arr.add(new ArrayList<NodeFN>());
        	D[i]=INF;
        }
        
        for(int i =0;i<edge.length;i++) {
        	int v1 = edge[i][0];
        	int v2 = edge[i][1];
        	arr.get(v1).add(new NodeFN(v2,1));
        	arr.get(v2).add(new NodeFN(v1,1));
        }
        
        dijkstra();
        int max = 0;
        for(int i =1;i<=n;i++) {
        	if(max<D[i]) {
        		max=D[i];
        	}
        }
        for(int i =1;i<=n;i++) {
        	if(D[i]==max) {
        		answer++;
        	}
        }
        return answer;
    }
	
	public static void dijkstra() {
		PriorityQueue<NodeFN> q = new PriorityQueue<>();
		D[1]=0;
		q.offer(new NodeFN(1,0));
		while(!q.isEmpty()) {
			NodeFN n = q.poll();
			int idx=n.index;
			int d=n.dist;
			if(d>D[idx])
				continue;
			for(NodeFN nd : arr.get(idx)) {
				if(D[nd.index]>nd.dist+D[idx]) {
					D[nd.index]=nd.dist+D[idx];
					q.offer(new NodeFN(nd.index,D[nd.index]));
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		solution(6 , new int[][] {{3,6},{4,3},{3,2},{1,3},{1,2},{2,4},{5,2}});
	}

}
