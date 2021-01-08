import java.util.*;
import java.io.*;
public class Baek1978 {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		boolean[] visited = new boolean[1001];
		for(int i =2;i<1001;i++) {
			if(!visited[i]) {
				for(int j=i*i;j<1001;j=j+i) {
					visited[j]=true;
				}
			}
		}
		visited[0]=true;
		visited[1]=true;
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st =new StringTokenizer(br.readLine());
		int cnt=0;
		while(st.hasMoreTokens()) {
			if(!visited[Integer.parseInt(st.nextToken())]) {
				cnt++;
			}
		}
		bw.write(cnt+"");
		bw.flush();
		bw.close();
		br.close();
		
	}

}
