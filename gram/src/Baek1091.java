import java.util.*;
import java.io.*;
public class Baek1091 {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N =Integer.parseInt(br.readLine());
		int[] P = new int[N];
		int[] S = new int[N];
		StringTokenizer st= new StringTokenizer(br.readLine());
		for(int i =0;i<N;i++) {
			P[i]=Integer.parseInt(st.nextToken());
		}
		st= new StringTokenizer(br.readLine());
		int[] temp=new int[N];
		int[] temp2=new int[N];
		for(int i =0;i<N;i++) {
			S[i]=Integer.parseInt(st.nextToken());
			temp[i]=S[i];
			temp2[i]=S[i];
		}
		int[] cpy2 = new int[N];
		for(int i =0;i<S.length;i++) {
			cpy2[i]=temp[i];
		}
		for(int i =0;i<S.length;i++) {
			temp2[S[i]]=cpy2[i];
		}
		if(ok(P,temp2)) {
			System.out.println("0");
			return;
		}
		
		int cnt=0;
		while(!ok(P,temp)) {
			int[] cpy = new int[N];
			for(int i =0;i<S.length;i++) {
				cpy[i]=temp[i];
			}
			for(int i =0;i<S.length;i++) {
				temp[S[i]]=cpy[i];
			}
//			for(int i =0;i<S.length;i++) {
//				System.out.print(temp[i]%3+" " );
//			}
			cnt++;
//			System.out.println();
		}
        if(cnt>1000000)
            System.out.println("-1");
        else
		    System.out.println(cnt);
		
	}
	public static boolean ok(int[] P,int[] S) {
		for(int i =0;i<P.length;i++) {
			if(P[i]!=S[i]%3) {
				return false;
			}
		}
		return true;
	}
}
