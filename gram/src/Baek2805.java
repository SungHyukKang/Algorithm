import java.util.*;
import java.io.*;
public class Baek2805 {
	public static long stoi(String X) {return Long.parseLong(X);}
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long N =stoi(st.nextToken());
		long target =stoi(st.nextToken());
		long[] arr = new long[(int)N];
		st = new StringTokenizer(br.readLine());
		long left = 0;
		long  right=0;
		for(int i =0;i<N;i++) {
			arr[i]=stoi(st.nextToken());
			right= arr[i] >right ? arr[i] : right;
		}
		long answer =0;
		Arrays.sort(arr);
		while(left<=right) {
			long mid = (left+right)/2;
			long  sum=0;
			for(int i =0;i<N;i++) {
				if(arr[i]>mid) {
					sum+=arr[i]-mid;
				}
			}
			if(sum>=target) {
				answer=mid;
				left=mid+1;
			}else {
				right=mid-1;
			}
		}
		System.out.println(answer);
	}

}
