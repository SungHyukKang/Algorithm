import java.util.*;
import java.io.*;
public class Baek2110 {
	public static void main(String[] args)throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N =Integer.parseInt(st.nextToken());
		int C=Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		for(int i =0;i<N;i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		
		int left = 1;
		int right = arr[N-1]-arr[0];
		int d =0;
		int answer=0;
		while(left<=right) {
			int mid =(left+right)/2;
			int start = arr[0];
			int cnt =1;
			for(int i =1 ;i<N;i++) {
				d=arr[i]-start;
				if(mid<=d) {
					cnt++;
					start=arr[i];
				}
			}
			if(cnt>=C) {
				left=mid+1;
				answer=mid;
			}else
				right=mid-1;
		}
		System.out.println(answer);
	}
}
