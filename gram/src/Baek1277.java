import java.util.*;
import java.io.*;

class Pair1277{
	int x,y;
	
	Pair1277(int x, int y){
		this.x=x;
		this.y=y;
		
	}
}

class Node1277 implements Comparable<Node1277>{
	int index;
	double d;
	
	Node1277(int s, double d){
		this.index=s;
		this.d=d;
	}

	@Override
	public int compareTo(Node1277 arg0) {
		return this.d<=arg0.d ? -1 : 1;
	}
}

public class Baek1277 {
	static int N;
	static int W;
	static double M;
	static double[] D ;
	static double INF = 1000000001;
	static ArrayList<ArrayList<Node1277>> list = new ArrayList<>();
	public static int stoi(String X) {return Integer.parseInt(X);}
	public static double stod(String X) {return Double.parseDouble(X);}
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N =stoi(st.nextToken());
		W=stoi(st.nextToken());
		M=stod(br.readLine());
		D=new double[N+1];
		for(int i=1;i<=N;i++) {
			D[i]=INF;
		}
		ArrayList<Pair1277> pair = new ArrayList<>();
		pair.add(new Pair1277(-1,-1));
		for(int i =1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			pair.add(new Pair1277(stoi(st.nextToken()),stoi(st.nextToken())));
		}
		for(int i =0;i<=N;i++) {
			list.add(new ArrayList<Node1277>());
		}
		
		for(int i =1;i<=N;i++) {
			for(int j =i;j<=N;j++) {
				if(i>=j)
					continue;
				int x=pair.get(i).x-pair.get(j).x;
				int y=pair.get(i).y-pair.get(j).y;
				double xtoy=dis(x,y);
				if(xtoy>M)
					continue;
				list.get(i).add(new Node1277(j,xtoy));
				list.get(j).add(new Node1277(i,xtoy));
			}
		}
		
		for(int i=0;i<W;i++) {
			st=new StringTokenizer(br.readLine());
			int num=stoi(st.nextToken());
			int num2=stoi(st.nextToken());
			list.get(num).add(new Node1277(num2,0));
			list.get(num2).add(new Node1277(num,0));
		}
		dijkstra();
		System.out.println((int)((D[N])*1000));
	}
	public static void dijkstra() {
		PriorityQueue<Node1277> pq = new PriorityQueue<>();
		pq.add(new Node1277(1,0));
		D[1]=0;
		while(!pq.isEmpty()) {
			Node1277 n = pq.poll();
			int index=n.index;
			double dist= n.d;
			if(dist>D[index])
				continue;
			for(Node1277 node : list.get(index)) {
				if(D[node.index]>node.d+D[index]) {
					D[node.index]=node.d+D[index];
					pq.offer(new Node1277(node.index,D[node.index]));
				}
			}
			
		}
	}
	
	public static double dis(int x, int y) {
		double xx=Math.pow(x, 2);
		double yy=Math.pow(y, 2);
		double xy= Math.sqrt(xx+yy);
		return xy;
		
		
	}
}
