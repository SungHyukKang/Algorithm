import java.util.*;
import java.io.*;

class Node2{
	int start;
	int end;
	int dist;
	
	Node2(int start ,int end , int dist){
		this.start=start;
		this.end=end;
		this.dist=dist;
	}
}
public class Baek1446 {
	static ArrayList<Node2> arr= new ArrayList<>();
	static int N;
	static int[] D;
	static boolean[] visited;
	static final int INF = 2100000000;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		D=new int[M+1];
		
		for(int i =0;i<=M;i++) {
			D[i]=INF;
		}
		ArrayList<Integer> startP = new ArrayList<>();
		for(int i =0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			int num3= Integer.parseInt(st.nextToken());
			startP.add(num);
			if(num2-num>num3&&num2<=M)
			arr.add(new Node2(num,num2,num3));
		}
		
		Collections.sort(startP);
		
	}
	public static void dijkstra(int start) {
	}
}
