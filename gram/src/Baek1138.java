import java.util.*;
import java.io.*;
public class Baek1138 {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N =Integer.parseInt(br.readLine());
		StringTokenizer st =new StringTokenizer(br.readLine());
		int[] arr =new int[N];
		for(int i =0;i<N;i++) {
			int x = Integer.parseInt(st.nextToken());
			for(int j=0;j<N;j++) {
				if(arr[j]==0&&x==0) {
					arr[j]=i+1;
					break;
				}
				if(arr[j]==0) {
					x--;
				}
			}
		}
		for(int i=0;i<N;i++) {
			System.out.print(arr[i]+" ");
		}
		
	}

}
