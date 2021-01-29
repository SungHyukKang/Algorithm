import java.util.*;

class NodePGM_1 implements Comparable<NodePGM_1>{
	int s;
	int e;
	int d;
	
	NodePGM_1(int s, int e,int d){
		this.s= s;
		this.e=e;
		this.d=d;
	}

	@Override
	public int compareTo(NodePGM_1 arg0) {
		return this.d<=arg0.d ? -1:1;
	}
}

public class PGM_1 {
	public static int solution(int[][] jobs) {
        int answer = 0;
        PriorityQueue<NodePGM_1> pq = new PriorityQueue<NodePGM_1>();
        for(int i =0;i<jobs.length;i++) {
        		pq.offer(new NodePGM_1(jobs[i][0], jobs[i][0]+jobs[i][1], jobs[i][1]));
        }
        int end = pq.peek().e;
        NodePGM_1[] node = new NodePGM_1[pq.size()];
        int i = 0;
        int pre=0;
        while(!pq.isEmpty()) {
        	NodePGM_1  n = pq.poll();
        	if(i==0) {
        		node[i]=new NodePGM_1(n.s,end,n.d);
        	}else {
        		node[i] = new NodePGM_1(end,end+n.d,n.d+end-n.s);
        		end=end+n.d;
        	}
        	pre=pre+n.d;
        	i++;
        }
        int sum=0;
        for(NodePGM_1 n : node) {
        	System.out.println(n.s+" "+n.e+" "+n.d);
        	sum+=n.d;
        }
        answer=sum/jobs.length;
        System.out.println(answer);
        
        
        return answer;
    }
	public static void main(String[] args) {
		solution(new int[][] {{1,3},{1,9},{2,6}});
	}

}
