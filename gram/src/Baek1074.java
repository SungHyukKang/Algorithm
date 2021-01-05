import java.util.*;
import java.io.*;
public class Baek1074 {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		System.out.println(func(N,r,c));
	}
	public static int func(int n,int r, int c) {
		if(n==0)
			return 0;
		int half = 1<<(n-1);
		if(half>r&&half>c) {
			return func(n-1,r,c);
		}else if(half>r&&half<=c) {
			return half*half+func(n-1,r,c);			
		}else if(half<=r&&half>c) {
			return 2*half*half+func(n-1,r,c);
		}else {
			return 3*half*half+func(n-1,r,c);
		}
	}
}
