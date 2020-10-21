import java.util.*;
import java.io.*;
public class Baek1032 {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N =Integer.parseInt(br.readLine());
		String[] x = new String[N];
		for(int i =0;i<N;i++) {
			x[i]=br.readLine();
		}
		StringBuilder sb = new StringBuilder();
		for(int i =0;i<x[0].length();i++) {
			boolean tf=true;
			for(int j =0;j<N-1;j++) {
				if(x[j].charAt(i)==x[j+1].charAt(i)) {
					continue;
				}else {
					tf=false;
					sb.append("?");
					break;
				}
			}
			if(tf) {
				sb.append(x[0].charAt(i));
			}
		}
		System.out.println(sb);
	}

}
