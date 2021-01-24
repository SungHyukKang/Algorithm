import java.util.*;
import java.io.*;
public class Baek2252 {
	static int N;
	static int M;
	static ArrayList<ArrayList<Integer>> list =new ArrayList<>();
	static Queue<Integer> q = new LinkedList<>();
	static int[] D;
	static int[] result;
	public static void main(String[] args)throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		D=new int[N+1];
		result=new int[N+1];
		for(int i =0;i<=N;i++) {
			list.add(new ArrayList<>());
		}
		for(int i =0;i<M;i++) {
			st =new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			list.get(a).add(b);
			D[b]++;
		}
		topologySort();
		for(int i=1;i<=N;i++)
			System.out.print(result[i]+" ");
		
	}
	public static void topologySort() {
		for(int i=1;i<D.length;i++) {
			if(D[i]==0) {
				q.offer(i);
			}
		}
		for(int i=1;i<=N;i++) {
			if(q.isEmpty()) {
				break;
			}
			int x =q.poll();
			result[i]=x;
			for(int index : list.get(x)) {
				D[index]--;
				if(D[index]==0)
					q.offer(index);
			}
		}
		
	}
}
