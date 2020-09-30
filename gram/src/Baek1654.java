import java.util.*;
import java.io.*;
public class Baek1654 {
	public static long stoi(String X) {return Long.parseLong(X);}
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long K =stoi(st.nextToken());
		long N =stoi(st.nextToken());
		long[] arr =new long[(int)K];
		long left =1 ;
		long right =0;
		long answer=0;
		for(int i =0;i<K;i++) {
			arr[i]=stoi(br.readLine());
			right= arr[i]>right ? arr[i] : right;
		}
		while(left<=right) {
			long mid = (left+right)/2;
			long sum=0;
			for(int i =0;i<K;i++) {
				sum+=arr[i]/mid;
			}
			
			if(sum>=N) {
				left=mid+1;
				answer=mid;
			}else
				right=mid-1;
		}
		System.out.println(answer);
	}
}
