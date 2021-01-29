import java.util.*;

class Pair7662 extends PriorityQueue<Integer> implements Comparable<Pair7662>{
	int x;
	
	public void pollLast() {
		System.out.println(this.size());
	}
	
	@Override
	public int compareTo(Pair7662 arg0) {
		return this.x<=arg0.x?-1:1;
	}
	
}
public class Baek7662 {

	public static void main(String[] args) {
		Pair7662 p =new Pair7662();
		p.offer(0);
		p.offer(1);
		p.offer(2);
		p.pollLast();
		System.out.println(p);
	}

}
