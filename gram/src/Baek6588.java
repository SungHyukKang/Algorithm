import java.util.*;
import java.io.*;
public class Baek6588 {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int x =-1;
		ArrayList<Integer> list = new ArrayList<>();
		boolean[] visited = new boolean[1000001];
		visited[0]=true;
		visited[1]=true;
		for(int i =2;i<=(int)Math.sqrt(1000000);i++) {
			if(!visited[i]) {
				for(int j=i*i;j<=1000000;j+=i) {
						visited[j]=true;
				}
			}
		}
		for(int i=2;i<visited.length;i++) {
			if(!visited[i])
				list.add(i);
		}
		while(true) {
			x=Integer.parseInt(br.readLine());
			if(x==0)
				break;
			int s=0,e=0;
			for(int i =0;i<list.size();i++) {
				if(list.get(i)>x) {
					e=i-1;
					break;
				}
			}
			int sum=list.get(e);
			while(true) {//x=8 sum = 
				if(sum<x){
					sum=list.get(s)+list.get(e);
					s++;
				}else if(sum==x) {
					bw.write(x+" = "+list.get(s-1)+" + "+list.get(e)+"\n");
					break;
				}else {
					s=0;
					e--;
					sum=list.get(e);
				}
			}
		}
		bw.flush();
		bw.close();
		br.close();
		
	}

}
