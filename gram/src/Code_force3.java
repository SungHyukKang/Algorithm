import java.util.*;
import java.io.*;
public class Code_force3 {
	static int x;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int t=0;t<N;t++) {
			x = Integer.parseInt(br.readLine());
			int[] arr = new int[x];
			int max=0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0;i<x;i++) {
				arr[i]=Integer.parseInt(st.nextToken());
				if(max<arr[i])max=arr[i];
			}
			for(int i=0;i<x;i++) {
				if(arr[i]==max) {
				if(isPossible(i-1)&&arr[i]>arr[i-1]) {
					System.out.println(i+1);
					break;
				}
				if(isPossible(i+1)&&arr[i]>arr[i+1]) {
					System.out.println(i+1);
					break;
				}
				}
				if(i==x-1)
					System.out.println("-1");
			}
		}
		
	}
	public static boolean isPossible(int t) {
		if(t<0||t>=x) {
			return false;
		}
		return true;
	}
}
