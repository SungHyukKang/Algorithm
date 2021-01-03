import java.util.*;
import java.io.*;
public class Baek1009 {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int  i=0;i<T;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int gob=1;
			for(int j=1;j<=b;j++) {
				gob=gob*a%10;
			}
			if(gob==0)
				gob=10;
			System.out.println(gob);
		}
	}

}
