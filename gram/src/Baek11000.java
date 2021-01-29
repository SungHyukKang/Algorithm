import java.util.*;


import java.io.*;
class Pair11000{
	int x,y;
	
	Pair11000(int x, int y){
		this.x=x;
		this.y=y;
	}
}


public class Baek11000 {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N =Integer.parseInt(br.readLine());
		ArrayList<Pair11000> list = new ArrayList<Pair11000>();
		PriorityQueue<Integer> pq=new PriorityQueue<>();
		for(int i =0;i<N;i++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			list.add(new Pair11000(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
		
		
		Collections.sort(list , new Comparator<Pair11000>() {
			@Override
			public int compare(Pair11000 o1, Pair11000 o2) {
				return o1.x>=o2.x ? 1 : -1;
			}
		});
		
		for(int i = 0;i<N;i++) {
			int end=list.get(i).y;
			if(!pq.isEmpty()&&pq.peek()<=list.get(i).x)
				pq.poll();
			pq.offer(end);
		}
		System.out.println(pq.size());
	}

}
