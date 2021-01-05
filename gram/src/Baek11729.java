import java.util.*;
import java.io.*;
public class Baek11729 {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k=Integer.parseInt(br.readLine());
		System.out.println((1<<k)-1);
		hanoi(1,3,k);
		bw.flush();
		bw.close();
		br.close();
	}

	public static void hanoi(int a, int b , int n)throws IOException {
		if(n==1) {
			bw.write(a+" "+b+"\n");
			return;
		}
		hanoi(a,6-a-b,n-1);
		bw.write(a+" "+b+"\n");
		hanoi(6-a-b,b,n-1);
		
	}
	
}
