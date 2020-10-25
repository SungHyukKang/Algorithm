import java.util.*;
import java.io.*;

class Spec{
	int key;
	int weight;
	int i;
	int rank;
	
	Spec(int key,int weight,int i){
		this.key=key;
		this.weight=weight;
		this.i=i;
	}
}

public class Baek7568 {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N =Integer.parseInt(br.readLine());
		ArrayList<Spec> list = new ArrayList<>();
		for(int i =0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a= Integer.parseInt(st.nextToken());
			int b= Integer.parseInt(st.nextToken());
			list.add(new Spec(a,b,i));
		}
		
		for(int i =0;i<list.size();i++) {
			int rank=0;
			for(int j=0;j<list.size();j++) {
				if(j==i)
					continue;
				if(list.get(i).key<list.get(j).key&&list.get(i).weight<list.get(j).weight) { 
					rank++;
				}
			}
			list.get(i).rank=rank;
		}
		for(int i =0;i<list.size();i++) {
			System.out.print((list.get(i).rank+1)+" ");
		}
	}
}
