import java.util.*;
import java.io.*;

public class Baek1629 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		int Z = Integer.parseInt(st.nextToken());
		if (Z == 1) {
			System.out.println(0);
			return;
		}
		System.out.println(rec(X, Y, Z));
	}// 10,11,12
		// 1

	public static long rec(int x, int y, int z) {// 10-> 4- >4
		if(y<=1) {
			return x%z;
		}
		long val = rec(x,y/2,z);
		val=val*val%z;
		if(y%2==0)
			return val;
		return val*x%z;
		
	}
}
