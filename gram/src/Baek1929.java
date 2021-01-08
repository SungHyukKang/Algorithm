import java.util.*;
import java.io.*;
public class Baek1929 {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		boolean[] visited = new boolean[1000001];
		StringTokenizer st =new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M= Integer.parseInt(st.nextToken());
		for(int i =2;i<=(int)Math.sqrt(M);i++) {
			if(!visited[i]) {
				for(int j=i*i;j<=M;j=j+i) {
					visited[j]=true;
				}
			}
		}
		visited[0]=true;
		visited[1]=true;
		
		for(int i =N;i<=M;i++) {
			if(!visited[i]) {
				bw.write(i+"\n");
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
		
	}

}
