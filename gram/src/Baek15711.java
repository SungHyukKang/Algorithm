import java.util.*;
import java.io.*;
public class Baek15711 {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int x =-1;
		ArrayList<Long> list = new ArrayList<>();
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
		
		bw.flush();
		bw.close();
		br.close();
		
	}

}
