import java.util.*;
import java.io.*;
public class Baek1717 {
	static int[] parent;
	
	static int find(int s) {
		if(parent[s]==s) {
			return s;
		}
		parent[s]=find(parent[s]);
		return parent[s];
	}
	static void union(int a, int b) {
		int aRoot=find(a);
		int bRoot=find(b);
		
		if(aRoot!=bRoot) {
			parent[aRoot]=b;
		}else
			return;
	}
	
	
	public static int stoi(String X) {return Integer.parseInt(X);}
	public static void main(String[] args)throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = stoi(st.nextToken());
		int m = stoi(st.nextToken());
		parent =new int[n+1];
		for(int i =0;i<=n;i++) {
			parent[i]=i;
		}
		for(int i =0;i<m;i++) {
			st= new StringTokenizer(br.readLine());
			int num=stoi(st.nextToken());
			int num2=stoi(st.nextToken());
			int num3=stoi(st.nextToken());
			
			if(num==0) {
				union(num2,num3);
			}
			if(num==1) {
				int a =find(num2);
				int b =find(num3);
				if(a==b) {
					bw.write("YES\n");
				}else
					bw.write("NO\n");
			}
		}
		bw.close();
		br.close();
	}

}
