import java.io.*;
public class INPC_B {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N =Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int cnt=0;
		if(N<0)
			cnt++;
		if(N==0) {
			System.out.println("1");
			return;
		}
		N=Math.abs(N);
		while(N!=0) {
			sb.append(N%2);
			N=N/2;
		}
		sb=sb.reverse();
		System.out.println(sb.length()+cnt);
	}
}