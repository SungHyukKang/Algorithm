import java.util.*;
import java.io.*;
public class Baek12865 {
	public static void main(String[] args)throws IOException	 {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n =Integer.parseInt(st.nextToken());
		int k =Integer.parseInt(st.nextToken());
		int[] w=new int[n+1];
		int[] v=new int[n+1];
		int[][] arr = new int[n+1][k+1];
		for(int i =1;i<=n;i++) {
			st=new StringTokenizer(br.readLine());
			int wei=Integer.parseInt(st.nextToken());
			int val=Integer.parseInt(st.nextToken());
			w[i]=wei;
			v[i]=val;
		}
		for(int i =1;i<=n;i++) {
			for(int j =1;j<=k;j++) {
				arr[i][j]=arr[i-1][j];
				if(j>=w[i]) {
					arr[i][j]=Math.max(arr[i-1][j],arr[i-1][j-w[i]]+v[i]);
				}
			}
		}
		System.out.println(arr[n][k]);
	}
}
