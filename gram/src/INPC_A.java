import java.io.*;
import java.util.*;
public class INPC_A {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N =Integer.parseInt(st.nextToken());
		int M =Integer.parseInt(st.nextToken());
		
		if(M<=2) {
			System.out.println("NEWBIE!");
			return;
		}
		
		if(M<=N) {
			System.out.println("OLDBIE!");
			return;
		}
		
		System.out.println("TLE!");
	}

}
