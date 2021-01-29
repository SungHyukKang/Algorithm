import java.util.*;
import java.io.*;

class Node1477 implements Comparable<Node1477>{
	int s;
	int e;
	int d;
	
	Node1477(int s, int e, int d){
		this.s=s;
		this.e=e;
		this.d=d;
	}

	@Override
	public int compareTo(Node1477 arg0) {
		return this.d<=arg0.d ? 1 : -1;
	}
}

public class Baek1477 {
	public static int stoi(String X ) {return Integer.parseInt(X);}
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = stoi(st.nextToken());
		int M = stoi(st.nextToken());
		int L = stoi(st.nextToken());
		ArrayList<Integer> list = new ArrayList<>();
		PriorityQueue<Node1477> pq = new PriorityQueue<>();
		st=new StringTokenizer(br.readLine());
		for(int i = 0 ;i<N;i++) {
			int num =stoi(st.nextToken());
			list.add(num);
		}
		Collections.sort(list);
		System.out.println(list);
		for(int i =1;i<N;i++) {
			pq.offer(new Node1477(list.get(i-1),list.get(i),list.get(i)-list.get(i-1)));
		}
		pq.offer(new Node1477(list.get(list.size()-1), L, L-list.get(list.size()-1)));
		for(int i =0;i<M;i++) {
			Node1477 n =pq.poll();
			System.out.println("start");
			System.out.println(n.s+" "+n.e+ " "+n.d);
			int go = (n.s+n.e)/2;
			pq.offer(new Node1477(n.s,go,go-n.s));
			pq.offer(new Node1477(go,n.e,n.e-go));
			System.out.println(go);
			System.out.println(pq.peek().s+" "+pq.peek().e+" "+pq.peek().d);
			System.out.println("end");
		}
		while(!pq.isEmpty()) {
			Node1477 n =pq.poll();
			System.out.println(n.s+ " "+n.e+ " "+n.d);
		}
	}

}
