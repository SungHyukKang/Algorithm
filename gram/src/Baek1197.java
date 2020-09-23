import java.util.*;
import java.io.*;

class MinHeap implements Comparable<MinHeap>{
	int start;
	int end;
	int dist;
	
	MinHeap(int s , int e , int d){
		this.start=s;
		this.end=e;
		this.dist=d;
	}

	@Override
	public int compareTo(MinHeap o) {
		return this.dist<=o.dist ? -1 : 1;
	}
}

public class Baek1197 {
	static int V;
	static int E;
	static PriorityQueue<MinHeap> pq = new PriorityQueue<MinHeap>();
	static int parent[];
	static int stoi(String X) {return Integer.parseInt(X);}
	public static int find(int a) {
		if(a==parent[a]) {//만일 자신의 부모노드가 자신이라면 자기 자신을 리턴
			return a;
		}
		parent[a]=find(parent[a]); // 가장 최상위 부모노드를 발견할 때 까지 find함수를 실행한다 . ex) 3->1->2->5 라면 parent[a]=parent[parent[parent[parent[3]]];
		return parent[a]; //최 상위 부모노드를 리턴
	}
	
	public static void union(int a, int b) {
		int aRoot=find(a); //a의 최상위 부모노드를 찾는다.
		int bRoot=find(b); //b의 최상위 부모노드를 찾는다.
		if(aRoot!=bRoot) { //두 부모가 같지 않다면
			parent[aRoot]=b; //a의 최 상위 부모노드인 aRoot의 최상위 부모노드를 b로 SET
		}else {
			return; //같다면 리턴해준다.
		}
	}
	
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int sum=0;
		V =stoi(st.nextToken()); //정점의 개수
		E = stoi(st.nextToken()); // 간선의 개수
		parent=new int[V+1];
		for(int i =1;i<=V;i++) {
			parent[i]=i;//자신의 부모노드는 자신으로 초기화.
		}
		
		for(int i =0 ;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int num = stoi(st.nextToken());
			int num2 = stoi(st.nextToken());
			int num3 = stoi(st.nextToken());
			pq.offer(new MinHeap(num , num2 , num3)); // 우선순위 큐에 가중치의 최소 힙으로 추가해줌 ==> 가장 작은 가중치로 우선순위 큐가 정렬됨. 
		}
		
		for(int i =0;i<E;i++) {
			MinHeap mh = pq.poll();//가장 작은 가중치를 가진 간선을 poll
			int start = mh.start; // 시작노드
			int end = mh.end; // 끝 노드
			int dist = mh.dist; // 간선의 가중치
			
			int a = find(start); // start의 최상위부모 노드를 찾는다 . 
			int b = find(end); //end의 최 상위 부모노드를 찾음.
//			print();
			if(a==b)// 만약 최상위 부모노드가 같다면 cycle이 생기므로 무시 , continue  
				continue;
			union(start,end); // 두개의 최상위 노드가 다르다면 start의 부모노드를 end의 부모노드로 SET
			sum+=dist; // 간선의 가중치를  합.
		}
		System.out.println(sum);
	}

	
	public static void print() {
		for(int i =1 ; i<parent.length;i++) {
			System.out.println(i + "의 부모노드 "+parent[i]);
		}
	}
	
}
