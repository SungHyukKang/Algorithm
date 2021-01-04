import java.util.*;
import java.io.*;

class Pair1713 implements Comparable<Pair1713>{
	int index=0;
	int like=0;
	int t=0;
	public Pair1713(int index, int like,int t) {
		this.index = index;
		this.like = like;
		this.t=t;
	}
	@Override
	public int compareTo(Pair1713 o) {
		if(this.like>o.like) {
			return 1;
		}else if(this.like==o.like) {
			return this.t<=o.t? -1:1;
		}else
			return -1;
	}
	
}

public class Baek1713 {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int T = Integer.parseInt(br.readLine());
		PriorityQueue<Pair1713> pq = new PriorityQueue<>();
		StringTokenizer st=  new StringTokenizer(br.readLine());
		for(int i =0;i<T;i++) {
			ArrayList<Pair1713> list = new ArrayList<>();
			int index = Integer.parseInt(st.nextToken());
			boolean tf = false;
			if(pq.isEmpty()) {
				pq.add(new Pair1713(index,1,i));
				continue;
			}
			while(!pq.isEmpty()) {
				Pair1713 p = pq.poll();
				list.add(p);
			}
			if(list.size()<N) {
				for(Pair1713 p : list) {
					if(p.index==index) {
						p.like++;
						tf=true;
					}
					pq.offer(p);
				}
				if(!tf) {
					pq.offer(new Pair1713(index,1,i));
				}
			}else if(list.size()==N) {
				for(Pair1713 p :list) {
					if(p.index==index) {
						p.like++;
						tf=true;
						break;
					}
				}
				if(tf) {
					for(Pair1713 p :list) {
						pq.offer(p);
					}
				}else {
					for(Pair1713 p :list) {
						pq.offer(p);
					}
					pq.poll();
					pq.offer(new Pair1713(index,1,i));
				}
			}
		}
		
		ArrayList<Integer> ans = new ArrayList<>();
		while(!pq.isEmpty()) {
			Pair1713 p = pq.poll();
			ans.add(p.index);
		}
		Collections.sort(ans);
		for(int x : ans) {
			System.out.print(x+" ");
		}
	}

}
