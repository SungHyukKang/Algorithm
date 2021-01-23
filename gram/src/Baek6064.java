import java.util.*;
import java.io.*;
public class Baek6064 {
	
	public static int gcd(int big , int small) {
		if(big%small==0) {
			return small;
		}
		return gcd(small,big%small);
	}
	public static int lcm(int a, int b) {
		return a*b/gcd(a,b);
	}
	
	public static void main(String[] args)throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int  T= Integer.parseInt(br.readLine());
		for(int t = 0 ; t<T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int xx =x;
			int yy=x;
			int maximum = lcm(Math.max(M, N),Math.min(M, N));
				for(int i =0;i<N;i++) {
					int ty = yy % N ==0? N:yy%N;
					if(ty==y)
						break;
					yy=yy+M;
					xx+=M;
				}
				System.out.println(xx>maximum ? "-1":xx);
		}
	}

}
