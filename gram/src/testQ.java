import java.util.*;

class P implements Comparable<P>{
	int x;
	
	P(int x){
		this.x=x;
	}

	@Override
	public int compareTo(P o) {
		return this.x<o.x? -1 : 1;
	}
}


public class testQ {

	public static void main(String[] args) {
		PriorityQueue<P> pq = new PriorityQueue<P>();
		pq.offer(new P(0));
		pq.offer(new P(1));
		pq.offer(new P(4));
		pq.offer(new P(2));
		while(!pq.isEmpty()) {
			System.out.println(pq.poll().x);
		}
	}

}
