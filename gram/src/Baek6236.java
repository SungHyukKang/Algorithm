import java.util.*;
import java.io.*;
public class Baek6236 {
	public static int stoi(String X) {return Integer.parseInt(X);}
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = stoi(st.nextToken());
		int M = stoi(st.nextToken());
		int[] arr = new int[N];
		int left = 0;
		int right =0;
		for(int i =0;i<N;i++) {
			arr[i]=stoi(br.readLine());
			right+=arr[i];
			left = arr[i]>left ? arr[i] : left;
		}
		while(left<=right) {
			int mid=(left+right)/2;
			int sum = 0;
			int cnt = 0;
			System.out.println(left);
			System.out.println(right);
			for(int i =0;i<N;i++) {
				if(sum+arr[i]>mid) {
					sum=0;
					cnt++;
				} 
				sum+= arr[i];
			}
			if(sum!=0) 
				cnt++;
			if(cnt<=M)
				right=mid -1;
			else
				left = mid+1;
		}
		System.out.println(left);
		
	}

}
